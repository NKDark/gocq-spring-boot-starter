package top.nkdark.gocq.handler

import com.alibaba.fastjson2.JSON
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import top.nkdark.gocq.bot.ApiHandler
import top.nkdark.gocq.bot.Bot
import top.nkdark.gocq.bot.BotContainer
import top.nkdark.gocq.bot.BotFactory
import java.util.concurrent.ExecutorService

@Component
class BotWebSocketHandler(
    private val botFactory: BotFactory,
    private val apiHandler: ApiHandler,
    private val eventHandler: EventHandler,
    private val executor: ExecutorService,
    private val botContainer: BotContainer,
) : TextWebSocketHandler() {

    private val log = LoggerFactory.getLogger(BotWebSocketHandler::class.java)

    override fun afterConnectionEstablished(session: WebSocketSession) {
        val xSelfId = session.handshakeHeaders["x-self-id"]?.get(0)?.toLong()
        log.info("{} connected", xSelfId)
        xSelfId?.let { uin ->
            val bot = botFactory.createBot(uin, session)
            botContainer.bots[uin] = bot
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        val xSelfId = session.handshakeHeaders["x-self-id"]?.get(0)?.toLong()
        log.info("{} disconnected", xSelfId)
        botContainer.bots.remove(xSelfId)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val xSelfId = session.handshakeHeaders["x-self-id"]?.get(0)?.toLong()
        xSelfId?.let { uin ->
            val bot: Bot = botContainer.bots[uin]
                ?: botFactory.createBot(uin, session).also { botContainer.bots[uin] = it }

            bot.botSession = session

            val payloadJson = JSON.parseObject(message.payload)
            if (payloadJson.containsKey("echo")) {
                apiHandler.onReceiveApiMessage(payloadJson)
            } else {
                executor.execute { eventHandler.handle(bot, payloadJson) }
            }
        }
    }
}

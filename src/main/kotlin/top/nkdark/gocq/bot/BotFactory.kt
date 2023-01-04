package top.nkdark.gocq.bot

import org.springframework.stereotype.Component
import org.springframework.web.socket.WebSocketSession

@Component
class BotFactory(private val apiHandler: ApiHandler) {
    fun createBot(botId: Long, session: WebSocketSession): Bot = GoCQBot(botId, session, apiHandler)
}
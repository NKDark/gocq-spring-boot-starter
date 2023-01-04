package top.nkdark.gocq.handler

import com.alibaba.fastjson2.JSONObject
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import top.nkdark.gocq.boot.BotProperties
import top.nkdark.gocq.bot.Bot
import top.nkdark.gocq.bot.BotPlugin
import top.nkdark.gocq.proto.GroupMessageEvent
import top.nkdark.gocq.proto.PrivateMessageEvent

@Component
class EventHandler(private val applicationContext: ApplicationContext, private val botProperties: BotProperties) {

    private fun <T> getPlugin(clazz: Class<T>): T? = try {
        applicationContext.getBean(clazz)
    } catch (_: Exception) {
        null
    }

    fun handle(bot: Bot, eventJson: JSONObject) {
        when (eventJson.getString("post_type")) {
            "message" -> handleMessage(bot, eventJson)
            "notice" -> handleNotice(bot, eventJson)
            "request" -> handleRequest(bot, eventJson)
//            "meta_event" -> handleMeta(bot, eventJson)
        }
    }

    private fun handleMessage(bot: Bot, eventJson: JSONObject) {
        when (eventJson.getString("message_type")) {
            "private" -> {
                val event = eventJson.toJavaObject(PrivateMessageEvent::class.java)
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onPrivateMessage(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }
            "group" -> {
                val event = eventJson.toJavaObject(GroupMessageEvent::class.java)
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupMessage(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }
        }
    }

    private fun handleNotice(bot: Bot, eventJson: JSONObject) {
        TODO("Not yet implemented")
    }

    private fun handleRequest(bot: Bot, eventJson: JSONObject) {
        TODO("Not yet implemented")
    }

}
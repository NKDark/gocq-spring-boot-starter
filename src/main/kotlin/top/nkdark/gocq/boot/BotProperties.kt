package top.nkdark.gocq.boot

import org.springframework.boot.context.properties.ConfigurationProperties
import top.nkdark.gocq.bot.BotPlugin


@ConfigurationProperties(prefix = "spring.bot")
data class BotProperties (
    var url: String = "/ws/*/",
    var maxTextMessageBufferSize: Int = 512000,
    var maxBinaryMessageBufferSize: Int = 512000,
    var maxSessionIdleTimeout: Long = 15 * 60000L,
    var apiTimeout: Long = 60000L,
    var pluginList: List<Class<out BotPlugin>> = ArrayList()
)
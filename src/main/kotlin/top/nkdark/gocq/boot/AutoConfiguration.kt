package top.nkdark.gocq.boot

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@ComponentScan("top.nkdark.gocq")
@Configuration
@EnableWebSocket
@EnableConfigurationProperties(value = [BotProperties::class, EventProperties::class])
class AutoConfiguration(val botProperties: BotProperties, val webSocketHandler: WebSocketHandler) : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(webSocketHandler, botProperties.url).setAllowedOrigins("*")
    }

}
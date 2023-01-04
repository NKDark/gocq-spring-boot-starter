package top.nkdark.gocq.boot

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.ExecutorService
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

@Component
class BotBean(val botProperties: BotProperties, val eventProperties: EventProperties) {

    @Bean
    @ConditionalOnMissingBean
    fun createExecutor(): ExecutorService {
        return ThreadPoolExecutor(
            eventProperties.corePoolSize,
            eventProperties.maxPoolSize,
            eventProperties.keepAliveTime,
            TimeUnit.MILLISECONDS,
            ArrayBlockingQueue(eventProperties.workQueueSize)
        )
    }


    @Bean
    @ConditionalOnMissingBean
    fun createWebSocketContainer(): ServletServerContainerFactoryBean? {
        val container = ServletServerContainerFactoryBean()
        // ws 传输数据的时候，数据过大有时候会接收不到，所以在此处设置bufferSize
        container.setMaxSessionIdleTimeout(botProperties.maxSessionIdleTimeout)
        container.setMaxTextMessageBufferSize(botProperties.maxTextMessageBufferSize)
        container.setMaxBinaryMessageBufferSize(botProperties.maxBinaryMessageBufferSize)
        return container
    }
}
package top.nkdark.gocq.boot

import org.slf4j.LoggerFactory
import org.springframework.boot.Banner
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
import org.springframework.boot.context.logging.LoggingApplicationListener
import org.springframework.context.ApplicationListener
import org.springframework.core.annotation.Order

@Order(LoggingApplicationListener.DEFAULT_ORDER)
class BannerApplicationListener : ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    private val log = LoggerFactory.getLogger(BannerApplicationListener::class.java)

    companion object {
        private val BANNER_MODE = Banner.Mode.CONSOLE
    }

    private fun buildBannerText() =
        StringBuilder().append(System.getProperty("line.separator"))
            .append(logo)
            .append(" :: SpringCQ :: ")
            .append(System.getProperty("line.separator"))
            .toString()

    override fun onApplicationEvent(event: ApplicationEnvironmentPreparedEvent) {
        when (BANNER_MODE) {
            Banner.Mode.OFF -> return
            Banner.Mode.CONSOLE -> println(buildBannerText())
            Banner.Mode.LOG -> log.info(buildBannerText())
        }
    }
}
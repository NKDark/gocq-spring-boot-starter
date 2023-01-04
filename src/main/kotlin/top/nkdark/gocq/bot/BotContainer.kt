package top.nkdark.gocq.bot

import org.springframework.stereotype.Component

@Component
class BotContainer {
    val bots = mutableMapOf<Long, Bot>()
}
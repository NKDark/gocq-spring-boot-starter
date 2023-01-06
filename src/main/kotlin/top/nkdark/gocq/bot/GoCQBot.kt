package top.nkdark.gocq.bot

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.socket.WebSocketSession

open class GoCQBot(
        override val selfId: Long,
        override var botSession: WebSocketSession,
        override var apiHandler: ApiHandler,
        override val log: Logger = LoggerFactory.getLogger("GoCQBot-$selfId")
) : Bot
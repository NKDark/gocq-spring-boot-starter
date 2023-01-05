package top.nkdark.gocq.bot

import org.springframework.web.socket.WebSocketSession

open class GoCQBot(
        override val selfId: Long,
        override var botSession: WebSocketSession,
        override var apiHandler: ApiHandler,
) : Bot
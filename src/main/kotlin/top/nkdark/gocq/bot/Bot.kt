package top.nkdark.gocq.bot

import org.springframework.web.socket.WebSocketSession
import top.nkdark.gocq.proto.SendPrivateMsgResp

interface Bot {
    val selfId: Long
    var botSession: WebSocketSession
    var apiHandler: ApiHandler

    fun sendPrivateMsg(userId: Long, message: String, autoEscape: Boolean = false): SendPrivateMsgResp? {
        return SendPrivateMsgResp(0)
    }
}
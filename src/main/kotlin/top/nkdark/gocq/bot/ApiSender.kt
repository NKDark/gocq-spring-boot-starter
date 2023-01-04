package top.nkdark.gocq.bot

import com.alibaba.fastjson2.JSONObject
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import java.io.IOException

class ApiSender(private val apiSession: WebSocketSession, private val apiTimeout: Long) : Thread() {
    private lateinit var responseJson: JSONObject
    private val lock = Object()

    @Throws(IOException::class, InterruptedException::class)
    fun sendApiJson(apiJson: JSONObject): JSONObject {
        synchronized(apiSession) {
            apiSession.sendMessage(TextMessage(apiJson.toJSONString()))
        }
        synchronized(lock) {
            lock.wait(apiTimeout);
        }
        return responseJson
    }

    fun onReceiveJson(responseJson: JSONObject) {
        this.responseJson = responseJson
        synchronized(lock) {
            lock.notify()
        }
    }
}

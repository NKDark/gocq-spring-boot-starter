package top.nkdark.gocq.bot

import com.alibaba.fastjson2.JSONObject
import top.nkdark.gocq.boot.BotProperties

class ApiHandler(private val botProperties: BotProperties) {
    private var apiEcho: Int = 0

    private val apiCallbackMap = HashMap<String, ApiSender>()

    fun onReceiveApiMessage(message: JSONObject) {
        val echo = message["echo"]?.toString()
        val apiSender = apiCallbackMap[echo]
        apiSender?.onReceiveJson(message)
        apiCallbackMap.remove(echo)
    }
}
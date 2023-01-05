package top.nkdark.gocq.bot

import com.alibaba.fastjson2.JSONObject
import org.slf4j.LoggerFactory
import org.springframework.web.socket.WebSocketSession
import top.nkdark.gocq.boot.BotProperties
import java.io.IOException
import java.util.concurrent.atomic.AtomicLong

class ApiHandler(private val botProperties: BotProperties) {
    private val log = LoggerFactory.getLogger(ApiHandler::class.java)

    private var apiEcho = AtomicLong()

    private val apiCallbackMap = HashMap<String, ApiSender>()

    /**
     * 收到 以前调用的API 的响应
     *
     * @param message 内容
     */
    fun onReceiveApiMessage(message: JSONObject) {
        val echo = message["echo"]?.toString()
        val apiSender = apiCallbackMap[echo]
        apiSender?.onReceiveJson(message)
        apiCallbackMap.remove(echo)
    }

    /**
     * 构造API需要的json，自定义request
     *
     * @param apiRequest 自定义请求
     * @return 结果
     */
    private fun constructApiJson(apiRequest: IApiRequest): JSONObject {
        val apiJson = JSONObject()
        apiJson["action"] = apiRequest.getEndpoint()
        apiRequest.getParams()?.let { apiJson["params"] = it }
        apiJson["echo"] = apiEcho.getAndIncrement()
        return apiJson
    }

    /**
     * 构造API需要的json，使用预定义的Enum
     *
     * @param action 需要调用的API
     * @param params 参数
     * @return 结果
     */
    private fun constructApiJson(action: ApiEnum, params: JSONObject?): JSONObject {
        val apiJson = JSONObject()
        apiJson["action"] = action.endpoint
        params?.let { apiJson["params"] = it }
        apiJson["echo"] = apiEcho.getAndIncrement()
        return apiJson
    }

    /**
     * 发送自定义API
     *
     * @param botSession websocketSession
     * @param apiRequest 自定义请求
     * @return 结果
     * @throws IOException          发送异常
     * @throws InterruptedException 线程异常
     */
    @Throws(IOException::class, InterruptedException::class)
    fun sendApiMessage(botSession: WebSocketSession, apiRequest: IApiRequest): JSONObject {
        val apiJson = constructApiJson(apiRequest)
        val echo = apiJson.getString("echo")
        val apiSender = ApiSender(botSession, botProperties.apiTimeout)
        apiCallbackMap[echo] = apiSender
        return apiSender.sendApiJson(apiJson)
    }

    /**
     * 调用定义好的API
     *
     * @param botSession 机器人session
     * @param action     执行的操作
     * @param params     参数
     * @return 结果
     */

    fun sendApiMessage(botSession: WebSocketSession, action: ApiEnum, params: JSONObject): JSONObject {
        val apiJson = constructApiJson(action, params)
        val echo = apiJson.getString("echo")
        val apiSender = ApiSender(botSession, botProperties.apiTimeout)
        apiCallbackMap[echo] = apiSender
        return try {
            apiSender.sendApiJson(apiJson)
        } catch (e: Exception) {
            log.error("Send Api message error: [${action.description}]", e)
            val retJson = JSONObject()
            retJson["status"] = "failed"
            retJson["retcode"] = -1
            retJson
        }
    }
}
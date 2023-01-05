package top.nkdark.gocq.bot

import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.TypeReference
import com.alibaba.fastjson2.to
import org.springframework.web.socket.WebSocketSession
import top.nkdark.gocq.proto.*
import java.io.IOException


interface Bot {
    val selfId: Long
    var botSession: WebSocketSession
    var apiHandler: ApiHandler

    fun sendPrivateMsg(userId: Long, message: String, autoEscape: Boolean = false): ApiData<MessageRespData>? {
        val action = ApiEnum.SEND_PRIVATE_MSG

        val params = JSONObject()
        params["user_id"] = userId
        params["message"] = message
        params["auto_escape"] = autoEscape

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<MessageRespData>>() {})
    }

    fun sendGroupMsg(groupId: Long, message: String, autoEscape: Boolean = false): ApiData<MessageRespData>? {
        val action = ApiEnum.SEND_GROUP_MSG

        val params = JSONObject()
        params["group_id"] = groupId
        params["message"] = message
        params["auto_escape"] = autoEscape

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<MessageRespData>>() {})
    }

    fun sendGroupForwardMsg(groupId: Long, messages: String): ApiRawData {
        val action = ApiEnum.SEND_GROUP_FORWARD_MSG

        val params = JSONObject()
        params["group_id"] = groupId
        params["messages"] = messages

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun sendMsg(
        messageType: EMessageType?,
        userId: Long?,
        groupId: Long?,
        message: String,
        autoEscape: Boolean = false,
    ): ApiData<MessageRespData>? {
        val action = ApiEnum.SEND_MSG

        val params = JSONObject()
        params["message_type"] = messageType
        params["user_id"] = userId
        params["group_id"] = groupId
        params["message"] = message
        params["auto_escape"] = autoEscape

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<MessageRespData>>() {})
    }

    fun deleteMsg(messageId: Int): ApiRawData {
        val action = ApiEnum.DELETE_MSG

        val params = JSONObject()
        params["message_id"] = messageId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun getMsg(messageId: Int): ApiData<MessageData> {
        val action = ApiEnum.DELETE_MSG

        val params = JSONObject()
        params["message_id"] = messageId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<MessageData>>() {})
    }

    fun getForwardMsg(messageId: Int): ApiListData<Message> {
        val action = ApiEnum.DELETE_MSG

        val params = JSONObject()
        params["message_id"] = messageId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiListData<Message>>() {})
    }

    fun sendPrivateForwardMsg(userId: Long, messages: String): ApiData<MessageRespData>? {
        val action = ApiEnum.SEND_PRIVATE_FORWARD_MSG

        val params = JSONObject()
        params["user_id"] = userId
        params["messages"] = messages

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<MessageRespData>>() {})
    }

    @Throws(IOException::class, InterruptedException::class)
    fun callCustomApi(apiRequest: IApiRequest): ApiRawData = apiHandler.sendApiMessage(botSession, apiRequest).to()
}
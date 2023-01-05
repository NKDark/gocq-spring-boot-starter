@file:Suppress("unused")

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

    fun getImage(file: String): ApiData<ImageData> {
        val action = ApiEnum.GET_IMAGE

        val params = JSONObject()
        params["file"] = file

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<ImageData>>() {})
    }

    fun markMsgAsRead(messageId: Int): ApiRawData {
        val action = ApiEnum.MARK_MSG_AS_READ

        val params = JSONObject()
        params["message_id"] = messageId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setGroupKick(groupId: Long, userId: Long, rejectAddRequest: Boolean = false): ApiRawData {
        val action = ApiEnum.SET_GROUP_KICK

        val params = JSONObject()
        params["group_id"] = groupId
        params["user_id"] = userId
        params["reject_add_request"] = rejectAddRequest

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setGroupBan(groupId: Long, userId: Long, duration: Int = 30 * 60): ApiRawData? {
        val action = ApiEnum.SET_GROUP_BAN

        val params = JSONObject()
        params["group_id"] = groupId
        params["user_id"] = userId
        params["duration"] = duration

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setGroupAnonymousBan(
        groupId: Long,
        anonymous: Anonymous?,
        anonymousFlag: String?,
        duration: Int = 30 * 60,
    ): ApiRawData? {
        if (null == anonymous && null == anonymousFlag) return null
        val action = ApiEnum.SET_GROUP_ANONYMOUS_BAN

        val params = JSONObject()
        params["group_id"] = groupId
        params["anonymous"] = anonymous
        params["anonymous_flag"] = anonymousFlag
        params["duration"] = duration

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setGroupCard(groupId: Long, userId: Long, card: String): ApiRawData {
        val action = ApiEnum.SET_GROUP_CARD

        val params = JSONObject()
        params["group_id"] = groupId
        params["user_id"] = userId
        params["card"] = card

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setGroupName(groupId: Long, groupName: String): ApiRawData {
        val action = ApiEnum.SET_GROUP_NAME

        val params = JSONObject()
        params["group_id"] = groupId
        params["group_name"] = groupName

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setGroupLeave(groupId: Long, isDismiss: Boolean = false): ApiRawData {
        val action = ApiEnum.SET_GROUP_LEAVE

        val params = JSONObject()
        params["group_id"] = groupId
        params["is_dismiss"] = isDismiss

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setGroupSpecialTitle(groupId: Long, userId: Long, specialTitle: String = "", duration: Int = -1): ApiRawData {
        val action = ApiEnum.SET_GROUP_SPECIAL_TITLE

        val params = JSONObject()
        params["group_id"] = groupId
        params["user_id"] = userId
        params["special_title"] = specialTitle
        params["duration"] = duration

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun sendGroupSign(groupId: Long): ApiRawData {
        val action = ApiEnum.SEND_GROUP_SIGN

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setFriendAddRequest(flag: String, approve: Boolean = true, remark: String = ""): ApiRawData {
        val action = ApiEnum.SET_FRIEND_ADD_REQUEST

        val params = JSONObject()
        params["flag"] = flag
        params["approve"] = approve
        params["remark"] = remark

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun getLoginInfo(): ApiData<LoginInfoData> {
        val action = ApiEnum.GET_LOGIN_INFO

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<LoginInfoData>>() {})
    }

    fun getQiDianAccountInfo(): ApiData<QiDianAccountInfoData> {
        val action = ApiEnum.QIDIAN_GET_ACCOUNT_INFO

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<QiDianAccountInfoData>>() {})
    }

    fun setGroupAddRequest(
        flag: String,
        subType: EGroupRequestType,
        approve: Boolean = true,
        reason: String = "",
    ): ApiRawData {
        val action = ApiEnum.SET_GROUP_ADD_REQUEST

        val params = JSONObject()
        params["flag"] = flag
        params["subType"] = subType.toString()
        params["approve"] = approve
        params["reason"] = reason

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setQQProfile(
        nickname: String,
        company: String,
        email: String,
        college: String,
        personalNote: String,
    ): ApiRawData {
        val action = ApiEnum.SET_QQ_PROFILE

        val params = JSONObject()
        params["nickname"] = nickname
        params["company"] = company
        params["email"] = email
        params["college"] = college
        params["personal_note"] = personalNote

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun getStrangerInfo(userId: Long, noCache: Boolean = false): ApiData<StrangerInfoData>? {
        val action = ApiEnum.GET_STRANGER_INFO

        val params = JSONObject()
        params["user_id"] = userId
        params["no_cache"] = noCache

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<StrangerInfoData>>() {})
    }

    fun getFriendList(): ApiListData<FriendInfoData>? {
        val action = ApiEnum.GET_STRANGER_INFO

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiListData<FriendInfoData>>() {})
    }

    fun getUnidirectionalFriendList(): ApiData<UnidirectionalFriendInfoData>? {
        val action = ApiEnum.GET_UNIDIRECTIONAL_FRIEND_LIST

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<UnidirectionalFriendInfoData>>() {})
    }

    fun deleteFriend(userId: Long): ApiRawData {
        val action = ApiEnum.DELETE_FRIEND

        val params = JSONObject()
        params["user_id"] = userId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<UnidirectionalFriendInfoData>>() {})
    }

    fun getGroupInfo(groupId: Long, noCache: Boolean = false): ApiData<GroupInfoData>? {
        val action = ApiEnum.GET_GROUP_INFO

        val params = JSONObject()
        params["group_id"] = groupId
        params["no_cache"] = noCache

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupInfoData>>() {})
    }

    fun getGroupList(): ApiListData<GroupInfoData>? {
        val action = ApiEnum.GET_GROUP_LIST

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiListData<GroupInfoData>>() {})
    }

    fun getGroupMemberInfo(groupId: Long, userId: Long, noCache: Boolean = false): ApiData<GroupMemberInfoData>? {
        val action = ApiEnum.GET_GROUP_MEMBER_INFO

        val params = JSONObject()
        params["group_id"] = groupId
        params["user_id"] = userId
        params["no_cache"] = noCache

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupMemberInfoData>>() {})
    }

    fun getGroupMemberList(groupId: Long, noCache: Boolean = false): ApiListData<GroupMemberInfoData>? {
        val action = ApiEnum.GET_GROUP_MEMBER_LIST

        val params = JSONObject()
        params["group_id"] = groupId
        params["no_cache"] = noCache

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiListData<GroupMemberInfoData>>() {})
    }

    fun getGroupHonorInfo(groupId: Long, type: EGroupHonorType): ApiData<GroupHonorInfoData> {
        val action = ApiEnum.GET_GROUP_HONOR_INFO

        val params = JSONObject()
        params["group_id"] = groupId
        params["type"] = type.toString()

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupHonorInfoData>>() {})
    }

    fun canSendImage(): ApiData<CanDoRespData> {
        val action = ApiEnum.CAN_SEND_IMAGE

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<CanDoRespData>>() {})
    }

    fun canSendRecord(): ApiData<CanDoRespData> {
        val action = ApiEnum.CAN_SEND_RECORD

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<CanDoRespData>>() {})
    }

    fun getVersionInfo(): ApiData<VersionInfoData> {
        val action = ApiEnum.GET_VERSION_INFO

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<VersionInfoData>>() {})
    }

    fun setRestart(delay: Long = 0): ApiRawData {
        val action = ApiEnum.GET_VERSION_INFO

        val params = JSONObject()
        params["delay"] = delay

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 设置群头像
     *
     * @param groupId 群号
     * @param file    支持 file:// http:// base64://
     * @param cache   通过网络 URL 发送时有效, 1表示使用缓存, 0关闭关闭缓存, 默认 为1
     */
    fun setGroupPortrait(groupId: Long, file: String, cache: Int): ApiRawData {
        val action = ApiEnum.SET_GROUP_PORTRAIT

        val params = JSONObject()
        params["group_id"] = groupId
        params["file"] = file
        params["cache"] = cache

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun ocrImage(image: String): ApiData<OCRRespData> {
        val action = ApiEnum.OCR_IMAGE

        val params = JSONObject()
        params["image"] = image

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<OCRRespData>>() {})
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
@file:Suppress("unused")

package top.nkdark.gocq.bot

import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.TypeReference
import com.alibaba.fastjson2.to
import org.slf4j.Logger
import org.springframework.web.socket.WebSocketSession
import top.nkdark.gocq.proto.*
import top.nkdark.gocq.proto.guild.*
import java.io.IOException


interface Bot {
    val selfId: Long
    var botSession: WebSocketSession
    var apiHandler: ApiHandler

    val log: Logger

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
    ): ApiData<MessageRespData> {
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
        val action = ApiEnum.GET_MSG

        val params = JSONObject()
        params["message_id"] = messageId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<MessageData>>() {})
    }

    fun getForwardMsg(messageId: Int): ApiListData<Message> {
        val action = ApiEnum.GET_FORWARD_MSG

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

    fun setGroupBan(groupId: Long, userId: Long, duration: Int = 30 * 60): ApiRawData {
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

    fun setGroupWholeBan(groupId: Long, enable: Boolean = true): ApiRawData {
        val action = ApiEnum.SET_GROUP_WHOLE_BAN

        val params = JSONObject()
        params["group_id"] = groupId
        params["enable"] = enable

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun setGroupAdmin(groupId: Long, userId: Long, enable: Boolean = true): ApiRawData {
        val action = ApiEnum.SET_GROUP_ADMIN

        val params = JSONObject()
        params["group_id"] = groupId
        params["user_id"] = userId
        params["enable"] = enable

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

    fun getFriendList(): ApiListData<FriendInfoData> {
        val action = ApiEnum.GET_FRIEND_LIST

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiListData<FriendInfoData>>() {})
    }

    fun getUnidirectionalFriendList(): ApiData<UnidirectionalFriendInfoData> {
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
        val action = ApiEnum.SET_RESTART

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

    fun getGroupSystemMsg(): ApiData<GroupSystemMsgData> {
        val action = ApiEnum.GET_GROUP_SYSTEM_MSG

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<OCRRespData>>() {})
    }

    /**
     * 上传私聊文件
     *
     * 只能上传本地文件, 需要上传 http 文件的话请先调用 download_file API下载
     *
     * @param userId 对方 QQ 号
     * @param file   本地文件路径
     * @param name   文件名称
     */
    fun uploadPrivateFile(userId: Long, file: String, name: String): ApiRawData {
        val action = ApiEnum.UPLOAD_PRIVATE_FILE

        val params = JSONObject()
        params["user_id"] = userId
        params["file"] = file
        params["name"] = name

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 上传群文件
     *
     * 在不提供 folder 参数的情况下默认上传到根目录
     *
     * 只能上传本地文件, 需要上传 http 文件的话请先调用 download_file API下载
     *
     * @param groupId   群号
     * @param file      本地文件路径
     * @param name      文件名称
     * @param folder    父目录ID
     */
    fun uploadGroupFile(groupId: Long, file: String, name: String, folder: String?): ApiRawData {
        val action = ApiEnum.UPLOAD_GROUP_FILE

        val params = JSONObject()
        params["group_id"] = groupId
        params["file"] = file
        params["name"] = name
        params["folder"] = folder

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 获取群文件系统信息
     *
     * @param groupId   群号
     */
    fun getGroupFileSystemInfo(groupId: Long): ApiData<GroupFileSystemInfoData> {
        val action = ApiEnum.GET_GROUP_FILE_SYSTEM_INFO

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupFileSystemInfoData>>() {})
    }

    /**
     * 获取群根目录文件列表
     *
     * @param groupId   群号
     */
    fun getGroupRootFiles(groupId: Long): ApiData<GroupFilesData> {
        val action = ApiEnum.GET_GROUP_ROOT_FILES

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupFilesData>>() {})
    }

    /**
     * 获取群子目录文件列表
     *
     * @param groupId   群号
     * @param folderId  文件夹ID 参考 Folder 对象
     */
    fun getGroupFilesByFolder(groupId: Long, folderId: String): ApiData<GroupFilesData> {
        val action = ApiEnum.GET_GROUP_FILES_BY_FOLDER

        val params = JSONObject()
        params["group_id"] = groupId
        params["folder_id"] = folderId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupFilesData>>() {})
    }

    /**
     * 创建群文件文件夹
     *
     * 仅能在根目录创建文件夹
     *
     * @param groupId   群号
     * @param name      文件名称
     * @param parentId  仅能为 /
     */
    fun createGroupFileFolder(groupId: Long, name: String, parentId: String): ApiRawData {
        val action = ApiEnum.CREATE_GROUP_FILE_FOLDER

        val params = JSONObject()
        params["group_id"] = groupId
        params["name"] = name
        params["parent_id"] = parentId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 删除群文件文件夹
     *
     * @param groupId  群号
     * @param folderId 文件夹ID 参考 Folder 对象
     */
    fun deleteGroupFolder(groupId: Long, folderId: String): ApiRawData {
        val action = ApiEnum.DELETE_GROUP_FOLDER

        val params = JSONObject()
        params["group_id"] = groupId
        params["folder_id"] = folderId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 删除群文件
     *
     * @param groupId 群号
     * @param fileId  文件夹ID 参考 File 对象
     * @param busid   文件类型 参考 File 对象
     */
    fun deleteGroupFile(groupId: Long, fileId: String, busid: Int): ApiRawData {
        val action = ApiEnum.DELETE_GROUP_FILE

        val params = JSONObject()
        params["group_id"] = groupId
        params["file_id"] = fileId
        params["busid"] = busid

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 获取群文件资源链接
     *
     * @param groupId 群号
     * @param fileId  文件夹ID 参考 File 对象
     * @param busid   文件类型 参考 File 对象
     */
    fun getGroupFileUrl(groupId: Long, fileId: String, busid: String): ApiData<UrlData> {
        val action = ApiEnum.GET_GROUP_FILE_URL

        val params = JSONObject()
        params["group_id"] = groupId
        params["file_id"] = fileId
        params["busid"] = busid

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<UrlData>>() {})
    }

    /**
     * 获取状态
     */
    fun getStatus(): ApiData<StatusData> {
        val action = ApiEnum.GET_STATUS

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<StatusData>>() {})
    }

    /**
     * 获取群文件资源链接
     *
     * @param groupId 群号
     */
    fun getGroupAtAllRemain(groupId: Long): ApiData<GroupAtAllRemainRespData> {
        val action = ApiEnum.GET_GROUP_AT_ALL_REMAIN

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupAtAllRemainRespData>>() {})
    }

    /**
     * 发送群公告
     *
     * @param groupId 群号
     * @param content 公告内容
     * @param image   图片路径（可选）
     */
    fun sendGroupNotice(groupId: Long, content: String, image: String?): ApiRawData {
        val action = ApiEnum.SEND_GROUP_NOTICE

        val params = JSONObject()
        params["group_id"] = groupId
        params["content"] = content
        params["image"] = image

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 获取群公告
     *
     * @param groupId 群号
     */
    fun getGroupNotice(groupId: Long): ApiListData<GroupNoticeRespData> {
        val action = ApiEnum.GET_GROUP_NOTICE

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiListData<GroupNoticeRespData>>() {})
    }

    /**
     * 重载事件过滤器
     *
     * @param file 事件过滤器文件
     */
    fun reloadEventFilter(file: String): ApiRawData {
        val action = ApiEnum.RELOAD_EVENT_FILTER

        val params = JSONObject()
        params["file"] = file

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 下载文件到缓存目录
     *
     * @param url           链接地址
     * @param threadCount   下载线程数
     * @param headers       自定义请求头
     */
    fun downloadFile(url: String, threadCount: Int, headers: String): ApiData<DownloadFileRespData> {
        val action = ApiEnum.DOWNLOAD_FILE

        val params = JSONObject()
        params["url"] = url
        params["thread_count"] = threadCount
        params["headers"] = headers

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<DownloadFileRespData>>() {})
    }

    fun downloadFile(url: String, threadCount: Int, headers: JSONObject): ApiData<DownloadFileRespData> {
        val list = headers.map { "${it.key}=${it.value}" }.toList()
        return downloadFile(url, threadCount, list)
    }

    fun downloadFile(url: String, threadCount: Int, headers: Map<String, String>): ApiData<DownloadFileRespData> {
        val list = headers.map { "${it.key}=${it.value}" }.toList()
        return downloadFile(url, threadCount, list)
    }

    fun downloadFile(url: String, threadCount: Int, headers: List<String>): ApiData<DownloadFileRespData> {
        val reduce = headers.reduce { self, that -> "$self\r\n$that" }
        return downloadFile(url, threadCount, reduce)
    }

    /**
     * 获取当前账号在线客户端列表
     *
     * @param noCache 是否无视缓存
     */
    fun getOnlineClients(noCache: Boolean): ApiData<OnlineClientsData> {
        val action = ApiEnum.GET_ONLINE_CLIENTS

        val params = JSONObject()
        params["no_cache"] = noCache

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<OnlineClientsData>>() {})
    }

    /**
     * 获取群消息历史记录
     *
     * @param messageSeq 起始消息序号, 可通过 get_msg 获得
     * @param groupId    群号
     *
     * @return 从起始序号开始的前19条消息 不提供起始序号将默认获取最新的消息
     */
    fun getGroupMsgHistory(messageSeq: Long?, groupId: Long): ApiData<GroupMsgHistoryData> {
        val action = ApiEnum.GET_GROUP_MSG_HISTORY

        val params = JSONObject()
        params["message_seq"] = messageSeq
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupMsgHistoryData>>() {})
    }

    /**
     * 设置精华消息
     *
     * @param messageId 消息ID
     */
    fun setEssenceMsg(messageId: Int): ApiRawData {
        val action = ApiEnum.SET_ESSENCE_MSG

        val params = JSONObject()
        params["message_id"] = messageId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 移出精华消息
     *
     * @param messageId 消息ID
     */
    fun deleteEssenceMsg(messageId: Int): ApiRawData {
        val action = ApiEnum.DELETE_ESSENCE_MSG

        val params = JSONObject()
        params["message_id"] = messageId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 获取精华消息列表
     *
     * @param groupId 群号
     */
    fun getEssenceMsgList(groupId: Long): ApiListData<EssenceMsgData> {
        val action = ApiEnum.GET_ESSENCE_MSG_LIST

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiListData<EssenceMsgData>>() {})
    }

    /**
     * 检查链接安全性
     *
     * @param url 需要检查的链接
     */
    fun checkUrlSafely(url: Long): ApiData<UrlSafetyData> {
        val action = ApiEnum.CHECK_URL_SAFELY

        val params = JSONObject()
        params["url"] = url

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<UrlSafetyData>>() {})
    }

    /**
     * 获取在线机型
     *
     * @param model 机型名称
     */
    fun getModelShow(model: String): ApiListData<ModelShowRespData> {
        val action = ApiEnum.GET_MODEL_SHOW

        val params = JSONObject()
        params["model"] = model

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiListData<ModelShowRespData>>() {})
    }

    /**
     * 设置在线机型
     *
     * [示例](https://github.com/Mrs4s/go-cqhttp/pull/872#issuecomment-831180149)
     *
     * [可能不好使](https://github.com/Mrs4s/go-cqhttp/pull/872#issuecomment-1249986232)，未测试
     *
     * @param model     机型名称
     * @param modelShow
     */
    fun setModelShow(model: String, modelShow: String): ApiRawData {
        val action = ApiEnum.SET_MODEL_SHOW

        val params = JSONObject()
        params["model"] = model
        params["model_show"] = modelShow

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * 删除单向好友
     *
     * @param userId    单向好友QQ号
     */
    fun deleteUnidirectionalFriend(userId: Long): ApiRawData {
        val action = ApiEnum.DELETE_UNIDIRECTIONAL_FRIEND

        val params = JSONObject()
        params["user_id"] = userId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun sendPrivateForwardMsg(userId: Long, messages: String): ApiData<MessageRespData> {
        val action = ApiEnum.SEND_PRIVATE_FORWARD_MSG

        val params = JSONObject()
        params["user_id"] = userId
        params["messages"] = messages

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<MessageRespData>>() {})
    }

    fun getGuildServiceProfile(): ApiData<GuildServiceProfileData> {
        val action = ApiEnum.GET_GUILD_SERVICE_PROFILE

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<GuildServiceProfileData>>() {})
    }

    fun getGuildList(): ApiListData<GuildInfoData>? {
        val action = ApiEnum.GET_GUILD_LIST

        apiHandler.sendApiMessage(botSession, action, null)
            .let {
                return if (it.containsKey("data")) it.to(object :
                    TypeReference<ApiListData<GuildServiceProfileData>>() {}) else null
            }
    }

    fun getGuildMetaByGuest(guildId: String): ApiData<GuildMetaByGuildData> {
        val action = ApiEnum.GET_GUILD_META_BY_GUEST

        val params = JSONObject()
        params["guild_id"] = guildId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GuildMetaByGuildData>>() {})
    }

    fun getGuildChannelList(guildId: String, noCache: Boolean): ApiListData<GuildServiceProfileData>? {
        val action = ApiEnum.GET_GUILD_CHANNEL_LIST

        val params = JSONObject()
        params["guild_id"] = guildId
        params["no_cache"] = noCache

        apiHandler.sendApiMessage(botSession, action, params)
            .let {
                return if (it.containsKey("data")) it.to(object :
                    TypeReference<ApiListData<GuildServiceProfileData>>() {}) else null
            }
    }

    fun getGuildMemberList(guildId: String, nextToken: String?): ApiData<GuildMetaByGuildData> {
        val action = ApiEnum.GET_GUILD_MEMBER_LIST

        val params = JSONObject()
        params["guild_id"] = guildId
        params["next_token"] = nextToken

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GuildMetaByGuildData>>() {})
    }

    fun getGuildMemberProfile(guildId: String, userId: String): ApiData<GuildMemberProfileData> {
        val action = ApiEnum.GET_GUILD_MEMBER_PROFILE

        val params = JSONObject()
        params["guild_id"] = guildId
        params["user_id"] = userId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GuildMemberProfileData>>() {})
    }

    fun sendGuildChannelMsg(guildId: String, channelId: String, message: String): ApiData<GuildMessageRespData> {
        val action = ApiEnum.SEND_GUILD_CHANNEL_MSG

        val params = JSONObject()
        params["guild_id"] = guildId
        params["channel_id"] = channelId
        params["message"] = message

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GuildMessageRespData>>() {})
    }

    fun getTopicChannelFeeds(guildId: String, channelId: String): ApiRawData? {
        val action = ApiEnum.GET_TOPIC_CHANNEL_FEEDS

        val params = JSONObject()
        params["guild_id"] = guildId
        params["channel_id"] = channelId

        apiHandler.sendApiMessage(botSession, action, params)
            .let {
                return if (it["retdata"] == 0) {
                    it.to(object : TypeReference<ApiRawData>() {})
                } else {
                    log.error("getTopicChannelFeeds failed cause: ${it["msg"]}")
                    null
                }
            }
    }

    @Throws(IOException::class, InterruptedException::class)
    fun callCustomApi(apiRequest: IApiRequest): ApiRawData = apiHandler.sendApiMessage(botSession, apiRequest).to()
}

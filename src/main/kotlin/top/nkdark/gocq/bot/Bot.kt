@file:Suppress("unused")

package top.nkdark.gocq.bot

import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.TypeReference
import com.alibaba.fastjson2.to
import org.slf4j.Logger
import org.springframework.web.socket.WebSocketSession
import top.nkdark.gocq.*
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
     * ???????????????
     *
     * @param groupId ??????
     * @param file    ?????? file:// http:// base64://
     * @param cache   ???????????? URL ???????????????, 1??????????????????, 0??????????????????, ?????? ???1
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
     * ??????????????????
     *
     * ????????????????????????, ???????????? http ???????????????????????? download_file API??????
     *
     * @param userId ?????? QQ ???
     * @param file   ??????????????????
     * @param name   ????????????
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
     * ???????????????
     *
     * ???????????? folder ??????????????????????????????????????????
     *
     * ????????????????????????, ???????????? http ???????????????????????? download_file API??????
     *
     * @param groupId   ??????
     * @param file      ??????????????????
     * @param name      ????????????
     * @param folder    ?????????ID
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
     * ???????????????????????????
     *
     * @param groupId   ??????
     */
    fun getGroupFileSystemInfo(groupId: Long): ApiData<GroupFileSystemInfoData> {
        val action = ApiEnum.GET_GROUP_FILE_SYSTEM_INFO

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupFileSystemInfoData>>() {})
    }

    /**
     * ??????????????????????????????
     *
     * @param groupId   ??????
     */
    fun getGroupRootFiles(groupId: Long): ApiData<GroupFilesData> {
        val action = ApiEnum.GET_GROUP_ROOT_FILES

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupFilesData>>() {})
    }

    /**
     * ??????????????????????????????
     *
     * @param groupId   ??????
     * @param folderId  ?????????ID ?????? Folder ??????
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
     * ????????????????????????
     *
     * ?????????????????????????????????
     *
     * @param groupId   ??????
     * @param name      ????????????
     * @param parentId  ????????? /
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
     * ????????????????????????
     *
     * @param groupId  ??????
     * @param folderId ?????????ID ?????? Folder ??????
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
     * ???????????????
     *
     * @param groupId ??????
     * @param fileId  ?????????ID ?????? File ??????
     * @param busid   ???????????? ?????? File ??????
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
     * ???????????????????????????
     *
     * @param groupId ??????
     * @param fileId  ?????????ID ?????? File ??????
     * @param busid   ???????????? ?????? File ??????
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
     * ????????????
     */
    fun getStatus(): ApiData<StatusData> {
        val action = ApiEnum.GET_STATUS

        return apiHandler.sendApiMessage(botSession, action, null)
            .to(object : TypeReference<ApiData<StatusData>>() {})
    }

    /**
     * ???????????????????????????
     *
     * @param groupId ??????
     */
    fun getGroupAtAllRemain(groupId: Long): ApiData<GroupAtAllRemainRespData> {
        val action = ApiEnum.GET_GROUP_AT_ALL_REMAIN

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GroupAtAllRemainRespData>>() {})
    }

    /**
     * ???????????????
     *
     * @param groupId ??????
     * @param content ????????????
     * @param image   ????????????????????????
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
     * ???????????????
     *
     * @param groupId ??????
     */
    fun getGroupNotice(groupId: Long): ApiListData<GroupNoticeRespData> {
        val action = ApiEnum.GET_GROUP_NOTICE

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiListData<GroupNoticeRespData>>() {})
    }

    /**
     * ?????????????????????
     *
     * @param file ?????????????????????
     */
    fun reloadEventFilter(file: String): ApiRawData {
        val action = ApiEnum.RELOAD_EVENT_FILTER

        val params = JSONObject()
        params["file"] = file

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * ???????????????????????????
     *
     * @param url           ????????????
     * @param threadCount   ???????????????
     * @param headers       ??????????????????
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
     * ???????????????????????????????????????
     *
     * @param noCache ??????????????????
     */
    fun getOnlineClients(noCache: Boolean): ApiData<OnlineClientsData> {
        val action = ApiEnum.GET_ONLINE_CLIENTS

        val params = JSONObject()
        params["no_cache"] = noCache

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<OnlineClientsData>>() {})
    }

    /**
     * ???????????????????????????
     *
     * @param messageSeq ??????????????????, ????????? get_msg ??????
     * @param groupId    ??????
     *
     * @return ???????????????????????????19????????? ???????????????????????????????????????????????????
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
     * ??????????????????
     *
     * @param messageId ??????ID
     */
    fun setEssenceMsg(messageId: Int): ApiRawData {
        val action = ApiEnum.SET_ESSENCE_MSG

        val params = JSONObject()
        params["message_id"] = messageId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * ??????????????????
     *
     * @param messageId ??????ID
     */
    fun deleteEssenceMsg(messageId: Int): ApiRawData {
        val action = ApiEnum.DELETE_ESSENCE_MSG

        val params = JSONObject()
        params["message_id"] = messageId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    /**
     * ????????????????????????
     *
     * @param groupId ??????
     */
    fun getEssenceMsgList(groupId: Long): ApiListData<EssenceMsgData> {
        val action = ApiEnum.GET_ESSENCE_MSG_LIST

        val params = JSONObject()
        params["group_id"] = groupId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiListData<EssenceMsgData>>() {})
    }

    /**
     * ?????????????????????
     *
     * @param url ?????????????????????
     */
    fun checkUrlSafely(url: Long): ApiData<UrlSafetyData> {
        val action = ApiEnum.CHECK_URL_SAFELY

        val params = JSONObject()
        params["url"] = url

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<UrlSafetyData>>() {})
    }

    /**
     * ??????????????????
     *
     * @param model ????????????
     */
    fun getModelShow(model: String): ApiListData<ModelShowRespData> {
        val action = ApiEnum.GET_MODEL_SHOW

        val params = JSONObject()
        params["model"] = model

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiListData<ModelShowRespData>>() {})
    }

    /**
     * ??????????????????
     *
     * [??????](https://github.com/Mrs4s/go-cqhttp/pull/872#issuecomment-831180149)
     *
     * [???????????????](https://github.com/Mrs4s/go-cqhttp/pull/872#issuecomment-1249986232)????????????
     *
     * @param model     ????????????
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
     * ??????????????????
     *
     * @param userId    ????????????QQ???
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

    fun getGuildMemberList(guildId: String, nextToken: String?): ApiData<GuildMemberListData> {
        val action = ApiEnum.GET_GUILD_MEMBER_LIST

        val params = JSONObject()
        params["guild_id"] = guildId
        params["next_token"] = nextToken

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GuildMemberListData>>() {})
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

    fun getTopicChannelFeeds(guildId: String, channelId: String): ApiData<FeedInfo>? {
        val action = ApiEnum.GET_TOPIC_CHANNEL_FEEDS

        val params = JSONObject()
        params["guild_id"] = guildId
        params["channel_id"] = channelId

        apiHandler.sendApiMessage(botSession, action, params)
            .let {
                return if (it["retcode"] == 0) {
                    it.to(object : TypeReference<ApiData<FeedInfo>>() {})
                } else {
                    log.error("getTopicChannelFeeds failed cause: ${it["msg"]}")
                    null
                }
            }
    }

    fun deleteGuildRole(guildId: String, roleId: String): ApiRawData {
        val action = ApiEnum.DELETE_GUILD_ROLE

        val params = JSONObject()
        params["guild_id"] = guildId
        params["role_id"] = roleId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun getGuildMsg(messageId: String, noCache: Boolean): ApiData<GuildMsg> {
        val action = ApiEnum.GET_GUILD_MSG

        val params = JSONObject()
        params["message_id"] = messageId
        params["no_cache"] = noCache

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiData<GuildMsg>>() {})
    }

    fun getGuildRoles(guildId: String): ApiListData<GuildRole> {
        val action = ApiEnum.GET_GUILD_ROLES

        val params = JSONObject()
        params["guild_id"] = guildId

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiListData<GuildRole>>() {})
    }

    /**
     * ?????????????????????????????????
     * ??????????????? ??????????????????
     */
    fun setGuildMemberRole(guildId: String, set: Boolean = false, roleId: String, users: String = "array"): ApiRawData {
        val action = ApiEnum.SET_GUILD_MEMBER_ROLE

        val params = JSONObject()
        params["guild_id"] = guildId
        params["set"] = set
        params["role_id"] = roleId
        params["users"] = users

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun updateGuildRole(guildId: String, roleId: String, name: String, color: String): ApiRawData {
        val action = ApiEnum.UPDATE_GUILD_ROLE

        val params = JSONObject()
        params["guild_id"] = guildId
        params["role_id"] = roleId
        params["name"] = name
        params["color"] = color
        params["independent"] = false

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    fun createGuildRole(
        guildId: String,
        color: String,
        name: String,
        initialUsers: List<String>
    ): ApiData<GuildRoleData> {
        val action = ApiEnum.CREATE_GUILD_ROLE

        val params = JSONObject()
        params["guild_id"] = guildId
        params["name"] = name
        params["color"] = color
        params["independent"] = false
        params["initial_users"] = initialUsers

        return apiHandler.sendApiMessage(botSession, action, params)
            .to(object : TypeReference<ApiRawData>() {})
    }

    @Throws(IOException::class, InterruptedException::class)
    fun callCustomApi(apiRequest: IApiRequest): ApiRawData = apiHandler.sendApiMessage(botSession, apiRequest).to()
}

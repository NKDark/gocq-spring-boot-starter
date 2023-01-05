package top.nkdark.gocq.proto

import com.alibaba.fastjson2.annotation.JSONField
import java.math.BigInteger

data class MessageRespData(@JSONField(name = "message_id") val messageId: Int)

data class Message(
    @JSONField(name = "content") val content: String,
    @JSONField(name = "sender") val sender: Sender,
    @JSONField(name = "time") val time: Long,
)

data class Sender(
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "user_id") val userId: Long,
)

data class MessageData(
    @JSONField(name = "group") val group: Boolean,
    @JSONField(name = "group_id") val groupId: Long?,
    @JSONField(name = "message_id") val messageId: Int,
    @JSONField(name = "real_id") val realId: Int,
    @JSONField(name = "message_type") val messageType: String,
    @JSONField(name = "sender") val sender: Sender,
    @JSONField(name = "time") val time: Int,
    @JSONField(name = "message") val message: String,
    @JSONField(name = "raw_message") val rawMessage: String,
)

data class ForwardMessageData(@JSONField(name = "messages") val messages: List<Message>)

data class ImageData(
    @JSONField(name = "size") val size: Int,
    @JSONField(name = "filename") val filename: String,
    @JSONField(name = "url") val url: String,
)

data class LoginInfoData(
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "user_id") val userId: Long,
)

data class QiDianAccountInfoData(
    @JSONField(name = "master_id") val masterId: Long,
    @JSONField(name = "ext_name") val extName: String,
    @JSONField(name = "create_time") val createTime: Long,
)

data class StrangerInfoData(
    @JSONField(name = "user_id") val userId: Long,
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "sex") val sex: String,
    @JSONField(name = "age") val age: Int,
    @JSONField(name = "qid") val qid: String,
    @JSONField(name = "level") val level: Int,
    @JSONField(name = "login_days") val loginDays: Int,
)

data class FriendInfoData(
    @JSONField(name = "user_id") val userId: Long,
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "remark") val remark: String,
)

data class UnidirectionalFriendInfoData(
    @JSONField(name = "user_id") val userId: Long,
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "source") val source: String,
)

/**
 * 这里提供了一个API用于获取群图片, group_id 为群号 https://p.qlogo.cn/gh/{group_id}/{group_id}/100
 */
data class GroupInfoData(
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 群名称
     */
    @JSONField(name = "group_name") val groupName: String,
    /**
     * 群备注
     */
    @JSONField(name = "group_memo") val groupMemo: String,
    /**
     * 群创建时间
     */
    @JSONField(name = "group_create_time") val groupCreateTime: Long,
    /**
     * 群等级
     */
    @JSONField(name = "group_level") val groupLevel: Long,
    /**
     * 成员数
     */
    @JSONField(name = "member_count") val memberCount: Int,
    /**
     * 最大成员数（群容量）
     */
    @JSONField(name = "max_member_count") val maxMemberCount: Int,
)

data class GroupMemberInfoData(
    @JSONField(name = "group_id") val groupId: Long,
    @JSONField(name = "user_id") val userId: Long,
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "card") val card: String,
    @JSONField(name = "sex") val sex: String,
    @JSONField(name = "age") val age: Int,
    @JSONField(name = "area") val area: String?,
    @JSONField(name = "join_time") val joinTime: Int,
    @JSONField(name = "last_sent_time") val lastSentTime: Int,
    @JSONField(name = "level") val level: Int,
    @JSONField(name = "role") val role: String,
    @JSONField(name = "unfriendly") val unfriendly: Boolean,
    @JSONField(name = "title") val title: String?,
    @JSONField(name = "title_expire_time") val titleExpireTime: Long?,
    @JSONField(name = "card_changeable") val cardChangeable: Boolean,
    @JSONField(name = "shut_up_timestamp") val shutUpTimestamp: Long?,
)

data class GroupHonorInfoData(
    @JSONField(name = "group_id") val groupId: Long,
    @JSONField(name = "current_talkative") val currentTalkative: CurrentTalkative?,
    @JSONField(name = "talkative_list") val talkativeList: List<HonorList>?,
    @JSONField(name = "performer_list") val performerList: List<HonorList>?,
    @JSONField(name = "legend_list") val legendList: List<HonorList>?,
    @JSONField(name = "strong_newbie_list") val strongNewbieList: List<HonorList>?,
    @JSONField(name = "emotion_list") val emotionList: List<HonorList>?,
) {
    data class CurrentTalkative(
        /**
         * QQ 号
         */
        @JSONField(name = "user_id") val userId: Long,
        /**
         * 昵称
         */
        @JSONField(name = "nickname") val nickname: String,
        /**
         * 头像 URL
         */
        @JSONField(name = "avatar") val avatar: String,
        /**
         * 持续天数
         */
        @JSONField(name = "day_count") val dayCount: Int,
    )

    data class HonorList(
        /**
         * QQ 号
         */
        @JSONField(name = "user_id") val userId: Long,
        /**
         * 昵称
         */
        @JSONField(name = "nickname") val nickname: String,
        /**
         * 头像 URL
         */
        @JSONField(name = "avatar") val avatar: String,
        /**
         * 荣誉描述
         */
        @JSONField(name = "description") val description: String,
    )
}

/**
 * currently not supported
 */
data class CookiesData(@JSONField(name = "cookies") val cookies: String)

/**
 * currently not supported
 */
data class CsrfTokenData(@JSONField(name = "token") val token: String)

/**
 * currently not supported
 */
data class CredentialsData(
    @JSONField(name = "cookies") val cookies: String,
    @JSONField(name = "csrf_token") val csrf_token: String,
)

/**
 * currently not supported
 */
data class RecordData(@JSONField(name = "file") val file: String)

data class CanDoRespData(@JSONField(name = "yes") val yes: Boolean)

data class VersionInfoData(
    @JSONField(name = "app_name") val appName: String = "go-cqhttp",
    @JSONField(name = "app_version") val appVersion: String,
    @JSONField(name = "app_full_name") val appFullName: String,
    @JSONField(name = "protocol_version") val protocolVersion: String = "v11",
    @JSONField(name = "coolq_edition") val coolQEdition: String = "pro",
    @JSONField(name = "coolq_directory") val coolQDirectory: String,
    @JSONField(name = "go-cqhttp") val goCqHttp: Boolean = true,
    @JSONField(name = "plugin_version") val pluginVersion: String = "4.15.0",
    @JSONField(name = "plugin_build_number") val pluginBuildNumber: Int = 99,
    @JSONField(name = "plugin_build_configuration") val pluginBuildConfiguration: String = "release",
    @JSONField(name = "runtime_version") val runtimeVersion: String,
    @JSONField(name = "runtime_os") val runtimeOs: String,
    @JSONField(name = "version") val version: String,
    @JSONField(name = "protocol") val protocol: Int,
)

data class OCRRespData(
    @JSONField(name = "texts") val texts: List<TextDetection>,
    @JSONField(name = "language") val language: String,
) {
    data class TextDetection(
        @JSONField(name = "text") val text: String,
        @JSONField(name = "confidence") val confidence: Int,
        @JSONField(name = "coordinates") val coordinates: List<Double>,
    )
}

data class GroupSystemMsgData(
    @JSONField(name = "invited_requests") val invitedRequests: List<InvitedRequest>,
    @JSONField(name = "join_requests") val joinRequests: List<JoinRequest>,
) {
    data class InvitedRequest(
        @JSONField(name = "request_id") val requestId: Long,
        @JSONField(name = "invitor_uin") val invitorUin: Long,
        @JSONField(name = "invitor_nick") val invitorNick: String,
        @JSONField(name = "group_id") val groupId: Long,
        @JSONField(name = "group_name") val groupName: String,
        @JSONField(name = "checked") val checked: Boolean,
        @JSONField(name = "actor") val actor: Long,
    )

    data class JoinRequest(
        @JSONField(name = "request_id") val requestId: Long,
        @JSONField(name = "requester_uin") val requesterUin: Long,
        @JSONField(name = "requester_nick") val requesterNick: String,
        @JSONField(name = "message") val message: String,
        @JSONField(name = "group_id") val groupId: Long,
        @JSONField(name = "group_name") val groupName: String,
        @JSONField(name = "checked") val checked: Boolean,
        @JSONField(name = "actor") val actor: Long,
    )
}

data class GroupFileSystemInfoData(
    @JSONField(name = "file_count") val fileCount: Int,
    @JSONField(name = "limit_count") val limitCount: Int,
    @JSONField(name = "used_space") val usedSpace: Long,
    @JSONField(name = "total_space") val totalSpace: Long,
)

data class GroupFilesData(
    @JSONField(name = "files") val files: List<FileData>,
    @JSONField(name = "folders") val folders: List<FolderData>,
) {
    data class FileData(
        @JSONField(name = "group_id") val groupId: Long,
        @JSONField(name = "file_id") val fileId: Long,
        @JSONField(name = "file_name") val fileName: Long,
        /**
         * 文件类型
         */
        @JSONField(name = "busid") val busid: Int,
        @JSONField(name = "file_size") val fileSize: Long,
        @JSONField(name = "upload_time") val uploadTime: Long,
        @JSONField(name = "dead_time") val deadTime: Long,
        @JSONField(name = "modify_time") val modifyTime: Long,
        @JSONField(name = "download_times") val downloadTimes: Int,
        @JSONField(name = "uploader") val uploader: Long,
        @JSONField(name = "uploader_name") val uploaderName: String,
    )

    data class FolderData(
        @JSONField(name = "group_id") val groupId: Long,
        @JSONField(name = "folder_id") val folderId: Long,
        @JSONField(name = "folder_name") val folderName: Long,
        @JSONField(name = "create_time") val createTime: Long,
        @JSONField(name = "creator") val creator: Long,
        @JSONField(name = "creator_name") val creatorName: String,
        @JSONField(name = "total_file_count") val totalFileCount: Int,
    )
}

data class UrlData(@JSONField(name = "url") val url: String)

data class StatusData(
    @JSONField(name = "app_initialized") val appInitialized: Boolean = true,
    @JSONField(name = "app_enabled") val appEnabled: Boolean = true,
    @JSONField(name = "plugins_good") val pluginsGood: Boolean = true,
    @JSONField(name = "app_good") val appGood: Boolean = true,
    @JSONField(name = "online") val online: Boolean = true,
    @JSONField(name = "good") val good: Boolean = true,
    @JSONField(name = "stat") val stat: Statistics,
) {
    data class Statistics(
        @JSONField(name = "packet_received") val packetReceived: BigInteger,
        @JSONField(name = "packet_sent") val packetSent: BigInteger,
        @JSONField(name = "packet_lost") val packetLost: Long,
        @JSONField(name = "message_received") val messageReceived: BigInteger,
        @JSONField(name = "message_sent") val messageSent: BigInteger,
        @JSONField(name = "disconnect_times") val disconnectTimes: Long,
        @JSONField(name = "lost_times") val lostTimes: Long,
        @JSONField(name = "last_message_time") val lastMessageTime: Long,
    )
}

data class GroupAtAllRemainRespData(
    @JSONField(name = "can_at_all") val canAtAll: Boolean,
    @JSONField(name = "remain_at_all_count_for_group") val remainAtAllCountForGroup: Int,
    @JSONField(name = "remain_at_all_count_for_uin") val remainAtAllCountForUin: Int,
)

data class GroupNoticeRespData(
    @JSONField(name = "sender_id") val sender_id: Long,
    @JSONField(name = "publish_time") val publish_time: Long,
    @JSONField(name = "message") val message: GroupNoticeMessageData,
) {
    data class GroupNoticeMessageData(
        @JSONField(name = "text") val text: String,
        @JSONField(name = "images") val images: List<GroupNoticeImageData>?,
    )

    data class GroupNoticeImageData(
        @JSONField(name = "height") val height: String,
        @JSONField(name = "width") val width: String,
        @JSONField(name = "id") val id: String,
    )
}

data class DownloadFileRespData(@JSONField(name = "file") val file: String)

data class OnlineClientsData(@JSONField(name = "clients") val clients: List<Device>)

data class GroupMsgHistoryData(@JSONField(name = "messages") val messages: List<Message>)

data class EssenceMsgData(
    @JSONField(name = "sender_id") val senderId: Long,
    @JSONField(name = "sender_nick") val senderNick: String,
    @JSONField(name = "sender_time") val senderTime: Long,
    @JSONField(name = "operator_id") val operatorId: Long,
    @JSONField(name = "operator_nick") val operatorNick: String,
    @JSONField(name = "operator_time") val operatorTime: Long,
    @JSONField(name = "message_id") val messageId: Int,
)

data class UrlSafetyData(@JSONField(name = "level") val level: Int)

/**
 * 在线机型信息
 */
data class ModelShowRespData(@JSONField(name = "variants") val variants: List<Variants>) {
    data class Variants(
        @JSONField(name = "model_show") val modelShow: String,
        @JSONField(name = "need_pay") val needPay: Boolean,
    )
}

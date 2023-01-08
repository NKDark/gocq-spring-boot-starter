package top.nkdark.gocq.proto

import com.alibaba.fastjson2.annotation.JSONField

data class PrivateMessageEvent(
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "post_type") val postType: String,
    @JSONField(name = "message_type") val messageType: String,
    @JSONField(name = "sub_type") val subType: String,
    @JSONField(name = "temp_source") val tempSource: Int?,
    @JSONField(name = "message_id") val messageId: Int,
    @JSONField(name = "user_id") val userId: Long,
    @JSONField(name = "message") val message: String,
    @JSONField(name = "raw_message") val rawMessage: String,
    @JSONField(name = "font") val font: Int,
    @JSONField(name = "sender") val sender: MessageSender,
)

data class GroupMessageEvent(
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "post_type") val postType: String,
    @JSONField(name = "message_type") val messageType: String,
    @JSONField(name = "sub_type") val subType: String,
    @JSONField(name = "message_id") val messageId: Int,
    @JSONField(name = "group_id") val groupId: Long,
    @JSONField(name = "user_id") val userId: Long,
    @JSONField(name = "anonymous") val anonymous: Anonymous?,
    @JSONField(name = "message") val message: String,
    @JSONField(name = "raw_message") val rawMessage: String,
    @JSONField(name = "font") val font: Int,
    @JSONField(name = "sender") val sender: IMessageSender,
)

/**
 * 群文件上传事件
 */
data class GroupUploadNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `group_upload`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 发送者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 文件信息
     */
    @JSONField(name = "file") val file: FileInfo,
)

/**
 * 群管理员变动事件
 */
data class GroupAdminChangeNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `group_admin`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 事件子类型, 分别表示设置和取消管理员
     *
     * 可能的值: `set`, `unset`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 管理员 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
)

/**
 * 群成员减少事件
 */
data class GroupMemberDecreaseNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `group_decrease`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 事件子类型, 分别表示主动退群、成员被踢、登录号被踢
     *
     * 可能的值: `leave`, `kick`, `kick_me`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 操作者 QQ 号 ( 如果是主动退群, 则和 user_id 相同 )
     */
    @JSONField(name = "operator_id") val operatorId: Long,
    /**
     * 离开者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
)

/**
 * 群成员增加事件
 */
data class GroupMemberIncreaseNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `group_increase`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 事件子类型, 分别表示管理员已同意入群、管理员邀请入群
     *
     * 可能的值: `approve`, `invite`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 操作者 QQ 号
     */
    @JSONField(name = "operator_id") val operatorId: Long,
    /**
     * 加入者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
)

/**
 * 群禁言事件
 */
data class GroupBanNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `group_ban`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 事件子类型, 分别表示禁言、解除禁言
     *
     * 可能的值: `ban`, `lift_ban`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 操作者 QQ 号
     */
    @JSONField(name = "operator_id") val operatorId: Long,
    /**
     * 被禁言 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 禁言时长, 单位秒
     */
    @JSONField(name = "duration") val duration: Long,
)

/**
 * 好友添加事件
 */
data class FriendAddNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `friend_add`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 新添加好友 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
)

/**
 * 群消息撤回事件
 */
data class GroupRecallNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `group_recall`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 消息发送者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 操作者 QQ 号
     */
    @JSONField(name = "operator_id") val operatorId: Long,
    /**
     * 被撤回的消息 ID
     */
    @JSONField(name = "message_id") val messageId: Long,
)

/**
 * 好友消息撤回事件
 */
data class FriendRecallNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `friend_recall`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 好友 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 被撤回的消息 ID
     */
    @JSONField(name = "message_id") val messageId: Long,
)

/**
 * 好友戳一戳事件
 */
data class FriendPokeNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `notify`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 事件子类型
     *
     * 可能的值: `poke`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 发送者 QQ 号
     */
    @JSONField(name = "sender_id") val senderId: Long,
    /**
     * 发送者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 被戳者 QQ 号
     */
    @JSONField(name = "target_id") val targetId: Long,
)

/**
 * 群内戳一戳事件
 *
 * 此事件无法在手表协议上触发
 */
data class GroupPokeNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `notify`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 事件子类型
     *
     * 可能的值: `poke`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 发送者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 被戳者 QQ 号
     */
    @JSONField(name = "target_id") val targetId: Long,
)

/**
 * 群红包运气王提示事件
 *
 * 此事件无法在手表协议上触发
 */
data class GroupLuckyKingChangeNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `notify`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 事件子类型
     *
     * 可能的值: `lucky_king`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 红包发送者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 运气王 QQ 号
     */
    @JSONField(name = "target_id") val targetId: Long,
)

/**
 * 群成员荣誉变更提示事件
 *
 * 此事件无法在手表协议上触发
 */
data class GroupHonorChangeNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `notify`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 事件子类型
     *
     * 可能的值: `honor`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 红包发送者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 荣誉类型
     *
     * 可能的值: `talkative:龙王`, `performer:群聊之火`, `emotion:快乐源泉`
     */
    @JSONField(name = "honor_type") val honorType: String,
)

/**
 * 群成员头衔变更事件
 *
 * 此事件不保证时效性, 仅在收到消息时校验卡片
 */
data class GroupTitleUpdateNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `group_card`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 提示类型
     *
     * 可能的值: `title`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 成员id
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 获得的新头衔
     */
    @JSONField(name = "title") val title: String,
)

/**
 * 群成员名片更新事件
 *
 * 此事件不保证时效性, 仅在收到消息时校验卡片
 */
data class GroupCardUpdateNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `group_card`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 成员id
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 新名片
     *
     * 当名片为空时为空字符串, 并不是昵称
     */
    @JSONField(name = "card_new") val cardNew: String,
    /**
     * 旧名片
     *
     * 当名片为空时为空字符串, 并不是昵称
     */
    @JSONField(name = "card_old") val cardOld: String,
)

/**
 * 接收到离线文件事件
 */
data class OfflineFileNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 通知类型
     *
     * 可能的值: `offline_file`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 成员id
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 文件数据
     */
    @JSONField(name = "file") val file: OfflineFile,
)

/**
 * 加好友请求事件
 */
data class FriendRequestEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `request`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 请求类型
     *
     * 可能的值: `friend`
     */
    @JSONField(name = "request_type") val requestType: String,
    /**
     * 发送请求的 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 验证信息
     */
    @JSONField(name = "comment") val comment: String,
    /**
     * 请求 flag, 在调用处理请求的 API 时需要传入
     */
    @JSONField(name = "flag") val flag: String,
)

/**
 * 加群请求／邀请事件
 */
data class GroupRequestEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `request`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 请求类型
     *
     * 可能的值: `group`
     */
    @JSONField(name = "request_type") val requestType: String,
    /**
     * 群号
     */
    @JSONField(name = "group_id") val groupId: Long,
    /**
     * 发送请求的 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 验证信息
     */
    @JSONField(name = "comment") val comment: String,
    /**
     * 请求 flag, 在调用处理请求的 API 时需要传入
     */
    @JSONField(name = "flag") val flag: String,
)

/**
 * 其他客户端在线状态变更事件
 */
data class ClientStatusChangeNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 消息类型
     *
     * 可能的值: `client_status`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 客户端信息
     */
    @JSONField(name = "client") val client: Device,
    /**
     * 当前是否在线
     */
    @JSONField(name = "online") val online: Boolean,
)

/**
 * 精华消息事件
 */
data class EssenceNoticeEvent(
    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time") val time: Long,
    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id") val selfId: Long,
    /**
     * 上报类型
     *
     * 可能的值: `notice`
     */
    @JSONField(name = "post_type") val postType: String,
    /**
     * 请求类型
     *
     * 可能的值: `essence`
     */
    @JSONField(name = "notice_type") val noticeType: String,
    /**
     * 添加为add,移出为delete
     *
     * 可能的值: `add`, `delete`
     */
    @JSONField(name = "sub_type") val subType: String,
    /**
     * 消息发送者ID
     */
    @JSONField(name = "sender_id") val senderId: Long,
    /**
     * 操作者ID
     */
    @JSONField(name = "operator_id") val operatorId: Long,
    /**
     * 消息ID
     */
    @JSONField(name = "message_id") val messageId: Int,
)

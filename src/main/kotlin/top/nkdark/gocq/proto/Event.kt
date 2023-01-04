package top.nkdark.gocq.proto

import com.alibaba.fastjson2.annotation.JSONField

data class Event(
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "post_type") val postType: String,
)

data class MessageEvent(
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "post_type") val postType: String,
    @JSONField(name = "message_type") val messageType: String,
    @JSONField(name = "sub_type") val subType: String,
    @JSONField(name = "message_id") val messageId: Int,
    @JSONField(name = "user_id") val userId: Long,
    @JSONField(name = "message") val message: Long,
    @JSONField(name = "raw_message") val rawMessage: String,
    @JSONField(name = "font") val font: Int,
    @JSONField(name = "sender") val sender: IMessageSender,
)

data class MessageSentEvent(
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "post_type") val postType: String,
    @JSONField(name = "message_type") val messageType: String,
    @JSONField(name = "sub_type") val subType: String,
    @JSONField(name = "message_id") val messageId: Int,
    @JSONField(name = "user_id") val userId: Long,
    @JSONField(name = "message") val message: Long,
    @JSONField(name = "raw_message") val rawMessage: String,
    @JSONField(name = "font") val font: Int,
    @JSONField(name = "sender") val sender: IMessageSender,
    @JSONField(name = "temp_source") val tempSource: Int,
)

data class PrivateMessageEvent(
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "post_type") val postType: String,
)

data class RequestEvent(
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "post_type") val postType: String,
)

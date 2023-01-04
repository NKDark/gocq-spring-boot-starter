package top.nkdark.gocq.proto

import com.alibaba.fastjson2.annotation.JSONField
import java.text.ParseException

interface IMessageSender

class MessageSender(
    @JSONField(name = "user_id") userId: Long,
    @JSONField(name = "nickname") nickname: String,
    @JSONField(name = "sex") sex: String,
    @JSONField(name = "age") age: Int,
) : IMessageSender

class MessageGroupTempSender(
    @JSONField(name = "user_id") userId: Long,
    @JSONField(name = "nickname") nickname: String,
    @JSONField(name = "sex") sex: String,
    @JSONField(name = "age") age: Int,
    @JSONField(name = "group_id") groupId: Long,
) : IMessageSender

class MessageGroupSender(
    @JSONField(name = "user_id") userId: Long,
    @JSONField(name = "nickname") nickname: String,
    @JSONField(name = "sex") sex: String,
    @JSONField(name = "age") age: Int,
    @JSONField(name = "card") card: String?,
    @JSONField(name = "area") area: String?,
    @JSONField(name = "level") level: String?,
    @JSONField(name = "role") role: String?,
    @JSONField(name = "title") title: String?,
) : IMessageSender

class MessageType(s: String) {
    private val messageType: EMessageType

    init {
        messageType = when (s) {
            "private" -> EMessageType.Private
            "group" -> EMessageType.Group
            else -> throw ParseException("This field can only be `private` or `group`", 114514)
        }
    }

    override fun toString(): String {
        return messageType.toString()
    }
}

enum class EMessageType(private val s: String) {
    Private("private"),
    Group("group");

    override fun toString(): String {
        return s
    }
}

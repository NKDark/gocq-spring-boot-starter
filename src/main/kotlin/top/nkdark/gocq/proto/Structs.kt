@file:Suppress("unused")

package top.nkdark.gocq.proto

import com.alibaba.fastjson2.annotation.JSONField

interface IMessageSender

data class MessageSender(
    /**
     * 发送者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 昵称
     */
    @JSONField(name = "nickname") val nickname: String,
    /**
     * 性别, male 或 female 或 unknown
     */
    @JSONField(name = "sex") val sex: String,
    /**
     * 年龄
     */
    @JSONField(name = "age") val age: Int,
) : IMessageSender

data class GroupTempMessageSender(
    @JSONField(name = "user_id") val userId: Long,
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "sex") val sex: String,
    @JSONField(name = "age") val age: Int,
    @JSONField(name = "group_id") val groupId: Long,
) : IMessageSender

data class GroupMessageSender(
    /**
     * 	发送者 QQ 号
     */
    @JSONField(name = "user_id") val userId: Long,
    /**
     * 昵称
     */
    @JSONField(name = "nickname") val nickname: String,
    /**
     * 群名片／备注
     */
    @JSONField(name = "card") val card: String?,
    /**
     * 性别, male 或 female 或 unknown
     */
    @JSONField(name = "sex") val sex: String,
    /**
     * 年龄
     */
    @JSONField(name = "age") val age: Int,
    /**
     * 地区
     */
    @JSONField(name = "area") val area: String?,
    /**
     * 	成员等级
     */
    @JSONField(name = "level") val level: String?,
    /**
     * 角色, owner 或 admin 或 member
     */
    @JSONField(name = "role") val role: String?,
    /**
     * 专属头衔
     */
    @JSONField(name = "title") val title: String?,
) : IMessageSender

data class Anonymous(
    /**
     * 	匿名用户 ID
     */
    @JSONField(name = "id") val id: Long,
    /**
     * 匿名用户名称
     */
    @JSONField(name = "name") val name: String,
    /**
     * 匿名用户 flag, 在调用禁言 API 时需要传入
     */
    @JSONField(name = "flag") val flag: String,
)

data class FileInfo(
    /**
     * 文件 ID
     */
    @JSONField(name = "id") val id: String,
    /**
     * 文件名
     */
    @JSONField(name = "name") val name: String,
    /**
     * 文件大小
     */
    @JSONField(name = "size") val size: Long,
    /**
     * busid ( 目前不清楚有什么作用 )
     */
    @JSONField(name = "busid") val busid: Long,
)

data class OfflineFile(
    /**
     * 文件名
     */
    @JSONField(name = "name") val name: String,
    /**
     * 文件大小
     */
    @JSONField(name = "size") val size: Long,
    /**
     * 下载链接
     */
    @JSONField(name = "url") val url: String,
)

data class Device(
    /**
     * 客户端ID
     */
    @JSONField(name = "app_id") val appId: Long,
    /**
     * 设备名称
     */
    @JSONField(name = "device_name") val deviceName: String,
    /**
     * 设备类型
     */
    @JSONField(name = "device_kind") val deviceKind: String,
)

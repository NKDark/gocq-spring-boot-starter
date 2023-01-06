package top.nkdark.gocq.proto.guild

import com.alibaba.fastjson2.annotation.JSONField


/**
 * 频道系统内BOT的资料
 */
data class GuildServiceProfileData(
    /**
     * 昵称
     */
    @JSONField(name = "nickname") val nickname: String,
    /**
     * 自身的ID
     */
    @JSONField(name = "tiny_id") val tinyId: String,
    /**
     * 头像链接
     */
    @JSONField(name = "avatar_url") val avatarUrl: String,
)

/**
 * 频道详情
 */
data class GuildInfoData(
    /**
     * 频道ID
     */
    @JSONField(name = "guild_id") val guildId: String,
    /**
     * 频道名称
     */
    @JSONField(name = "guild_name") val guildName: String,
    /**
     * 频道显示ID, 公测后可能作为搜索ID使用
     */
    @JSONField(name = "guild_display_id") val guildDisplayId: Long,
)

data class GuildMetaByGuildData(
    /**
     * 频道ID
     */
    @JSONField(name = "guild_id") val guildId: String,
    /**
     * 频道名称
     */
    @JSONField(name = "guild_name") val guildName: String,
    /**
     * 频道简介
     */
    @JSONField(name = "guild_profile") val guildProfile: String,
    @JSONField(name = "create_time") val createTime: Long,
    @JSONField(name = "max_member_count") val maxMemberCount: Long,
    @JSONField(name = "max_robot_count") val maxRobotCount: Long,
    @JSONField(name = "max_admin_count") val maxAdminCount: Long,
    @JSONField(name = "member_count") val memberCount: Long,
    @JSONField(name = "owner_id") val ownerId: String,
)

data class GuildMemberListData(
    @JSONField(name = "members") val members: List<GuildMemberInfo>,
    @JSONField(name = "finished") val finished: Boolean,
    @JSONField(name = "next_token") val nextToken: String?,
)

data class GuildMemberInfo(
    @JSONField(name = "tiny_id") val tinyId: String,
    @JSONField(name = "title") val title: String,
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "role_id") val roleId: String,
    @JSONField(name = "role_name") val roleName: String,
)

data class GuildMemberProfileData(
    /**
     * 用户ID
     */
    @JSONField(name = "tiny_id") val tinyId: String,
    /**
     * 用户昵称
     */
    @JSONField(name = "nickname") val nickname: String,
    /**
     * 头像链接
     */
    @JSONField(name = "avatar_url") val avatarUrl: String,
    @JSONField(name = "join_time") val joinTime: Long,
    @JSONField(name = "roles") val roles: List<RoleInfo>,
)

data class RoleInfo(
    /**
     * 权限组ID
     */
    @JSONField(name = "role_id") val roleId: String,
    /**
     * 权限组名称
     */
    @JSONField(name = "role_name") val roleName: String,
)

data class GuildMessageRespData(@JSONField(name = "message_id") val messageId: String)

data class FeedInfo(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "contents") val contents: List<FeedContent>,
    @JSONField(name = "create_time") val createTime: Int,
    @JSONField(name = "guild_id") val guildId: String,
    @JSONField(name = "id") val id: String,
    @JSONField(name = "poster_info") val posterInfo: PosterInfo,
    @JSONField(name = "resource") val resource: Resource,
    @JSONField(name = "sub_title") val subTitle: String,
    @JSONField(name = "title") val title: String,
)

data class FeedContent(
    @JSONField(name = "data") val `data`: IData,
    @JSONField(name = "type") val type: String,
)

data class PosterInfo(
    @JSONField(name = "icon_url") val iconUrl: String,
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "tiny_id") val tinyId: String,
)

data class Resource(
    @JSONField(name = "images") val images: List<FeedMedia>,
    @JSONField(name = "videos") val videos: List<FeedMedia>,
)

data class FeedMedia(
    @JSONField(name = "file_id") val fileId: String,
    @JSONField(name = "pattern_id") val patternId: String,
    @JSONField(name = "url") val url: String,
    @JSONField(name = "height") val height: Int,
    @JSONField(name = "width") val width: Int,
)

interface IData

@Suppress("unused")
data class TextData(@JSONField(name = "text") val text: String) : IData

@Suppress("unused")
data class FaceData(@JSONField(name = "id") val id: String) : IData

@Suppress("unused")
data class AtData(
    /**
     * 目标ID
     */
    @JSONField(name = "id") val id: String,
    /**
     * 目标ID, 为确保和 array message 的一致性保留
     */
    @JSONField(name = "qq") val qq: String,
) : IData

@Suppress("unused")
data class UrlQuoteData(
    /**
     * 显示文本
     */
    @JSONField(name = "display_text") val displayText: String,
    /**
     * 链接
     */
    @JSONField(name = "url") val url: String,
) : IData

@Suppress("unused")
data class ChannelQuoteData(
    /**
     * 显示文本
     */
    @JSONField(name = "display_text") val displayText: String,
    /**
     * 频道ID
     */
    @JSONField(name = "guild_id") val guildId: String,
    /**
     * 子频道ID
     */
    @JSONField(name = "channel_id") val channelId: String,
) : IData

data class GuildMsg(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "guild_id") val guildId: String,
    @JSONField(name = "message") val message: String,
    @JSONField(name = "message_id") val messageId: String,
    @JSONField(name = "message_seq") val messageSeq: Long,
    @JSONField(name = "message_source") val messageSource: String,
    @JSONField(name = "reactions") val reactions: List<Any>,
    @JSONField(name = "sender") val sender: Sender,
    @JSONField(name = "time") val time: Long
)

data class GuildRole(
    @JSONField(name = "argb_color") val argbColor: Long,
    @JSONField(name = "disabled") val disabled: Boolean,
    @JSONField(name = "independent") val independent: Boolean,
    @JSONField(name = "max_count") val maxCount: Int,
    @JSONField(name = "member_count") val memberCount: Int,
    @JSONField(name = "owned") val owned: Boolean,
    @JSONField(name = "role_id") val roleId: String,
    @JSONField(name = "role_name") val roleName: String
)

data class GuildRoleData(@JSONField(name = "role_id") val roleId: Long)

package top.nkdark.gocq.proto.guild

import com.alibaba.fastjson2.annotation.JSONField


data class GuildMessageEvent(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "guild_id") val guildId: String,
    @JSONField(name = "message") val message: String,
    @JSONField(name = "message_id") val messageId: String,
    @JSONField(name = "message_type") val messageType: String,
    @JSONField(name = "post_type") val postType: String,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "self_tiny_id") val selfTinyId: String,
    @JSONField(name = "sender") val sender: Sender,
    @JSONField(name = "sub_type") val subType: String,
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "user_id") val userId: String,
)

data class Sender(
    @JSONField(name = "nickname") val nickname: String,
    @JSONField(name = "tiny_id") val tinyId: String,
    @JSONField(name = "user_id") val userId: Long,
)

data class MessageReactionsUpdatedNoticeEvent(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "current_reactions") val currentReactions: List<CurrentReaction>,
    @JSONField(name = "guild_id") val guildId: String,
    @JSONField(name = "message_id") val messageId: String,
    @JSONField(name = "notice_type") val noticeType: String,
    @JSONField(name = "operator_id") val operatorId: String,
    @JSONField(name = "post_type") val postType: String,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "self_tiny_id") val selfTinyId: String,
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "user_id") val userId: Int,
)

data class CurrentReaction(
    @JSONField(name = "clicked") val clicked: Boolean,
    @JSONField(name = "count") val count: Int,
    @JSONField(name = "emoji_id") val emojiId: String,
    @JSONField(name = "emoji_index") val emojiIndex: Int,
    @JSONField(name = "emoji_name") val emojiName: String,
    @JSONField(name = "emoji_type") val emojiType: Int,
)

data class ChannelUpdatedNoticeEvent(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "guild_id") val guildId: String,
    @JSONField(name = "new_info") val newInfo: NewInfo,
    @JSONField(name = "notice_type") val noticeType: String,
    @JSONField(name = "old_info") val oldInfo: OldInfo,
    @JSONField(name = "operator_id") val operatorId: String,
    @JSONField(name = "post_type") val postType: String,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "self_tiny_id") val selfTinyId: String,
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "user_id") val userId: Long,
)

data class NewInfo(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "channel_name") val channelName: String,
    @JSONField(name = "channel_type") val channelType: Int,
    @JSONField(name = "create_time") val createTime: Int,
    @JSONField(name = "creator_tiny_id") val creatorTinyId: String,
    @JSONField(name = "current_slow_mode") val currentSlowMode: Int,
    @JSONField(name = "owner_guild_id") val ownerGuildId: String,
    @JSONField(name = "slow_modes") val slowModes: List<SlowMode>,
    @JSONField(name = "talk_permission") val talkPermission: Int,
    @JSONField(name = "visible_type") val visibleType: Int,
)

data class OldInfo(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "channel_name") val channelName: String,
    @JSONField(name = "channel_type") val channelType: Int,
    @JSONField(name = "create_time") val createTime: Int,
    @JSONField(name = "creator_tiny_id") val creatorTinyId: String,
    @JSONField(name = "current_slow_mode") val currentSlowMode: Int,
    @JSONField(name = "owner_guild_id") val ownerGuildId: String,
    @JSONField(name = "slow_modes") val slowModes: List<SlowMode>,
    @JSONField(name = "talk_permission") val talkPermission: Int,
    @JSONField(name = "visible_type") val visibleType: Int,
)

data class SlowMode(
    @JSONField(name = "slow_mode_circle") val slowModeCircle: Int,
    @JSONField(name = "slow_mode_key") val slowModeKey: Int,
    @JSONField(name = "slow_mode_text") val slowModeText: String,
    @JSONField(name = "speak_frequency") val speakFrequency: Int,
)

data class ChannelDestroyedNoticeEvent(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "channel_info") val channelInfo: ChannelInfo,
    @JSONField(name = "guild_id") val guildId: String,
    @JSONField(name = "notice_type") val noticeType: String,
    @JSONField(name = "operator_id") val operatorId: String,
    @JSONField(name = "post_type") val postType: String,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "self_tiny_id") val selfTinyId: String,
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "user_id") val userId: Long,
)

data class ChannelInfo(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "channel_name") val channelName: String,
    @JSONField(name = "channel_type") val channelType: Int,
    @JSONField(name = "create_time") val createTime: Long,
    @JSONField(name = "creator_tiny_id") val creatorTinyId: String,
    @JSONField(name = "current_slow_mode") val currentSlowMode: Int,
    @JSONField(name = "owner_guild_id") val ownerGuildId: String,
    @JSONField(name = "slow_modes") val slowModes: List<SlowMode>,
    @JSONField(name = "talk_permission") val talkPermission: Int,
    @JSONField(name = "visible_type") val visibleType: Int,
)

data class ChannelCreatedNoticeEvent(
    @JSONField(name = "channel_id") val channelId: String,
    @JSONField(name = "channel_info") val channelInfo: ChannelInfo,
    @JSONField(name = "guild_id") val guildId: String,
    @JSONField(name = "notice_type") val noticeType: String,
    @JSONField(name = "operator_id") val operatorId: String,
    @JSONField(name = "post_type") val postType: String,
    @JSONField(name = "self_id") val selfId: Long,
    @JSONField(name = "self_tiny_id") val selfTinyId: String,
    @JSONField(name = "time") val time: Long,
    @JSONField(name = "user_id") val userId: Long,
)

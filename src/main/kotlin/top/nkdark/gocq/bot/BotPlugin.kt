package top.nkdark.gocq.bot

import top.nkdark.gocq.proto.*
import top.nkdark.gocq.proto.guild.*

abstract class BotPlugin {
    /**
     * 收到私聊消息时调用此方法
     *
     * @param   bot     机器人对象
     * @param   event   事件内容
     * @return  消息是否处理完毕,
     *          `MatchedAndBlock`表示处理完毕不继续下一个插件处理,
     *          `NotMatch`表示未处理并继续下一个插件处理
     */
    open fun onPrivateMessage(bot: Bot, event: PrivateMessageEvent) = NotMatch

    open fun onGroupMessage(bot: Bot, event: GroupMessageEvent) = NotMatch

    open fun onGroupUploadNotice(bot: Bot, event: GroupUploadNoticeEvent) = NotMatch

    open fun onGroupAdminChangeNotice(bot: Bot, event: GroupAdminChangeNoticeEvent) = NotMatch

    open fun onGroupMemberDecreaseNotice(bot: Bot, event: GroupMemberDecreaseNoticeEvent) = NotMatch

    open fun onGroupMemberIncreaseNotice(bot: Bot, event: GroupMemberIncreaseNoticeEvent) = NotMatch

    open fun onGroupBanNotice(bot: Bot, event: GroupBanNoticeEvent) = NotMatch

    open fun onFriendAddNotice(bot: Bot, event: FriendAddNoticeEvent) = NotMatch

    open fun onGroupRecallNotice(bot: Bot, event: GroupRecallNoticeEvent) = NotMatch

    open fun onFriendRecallNotice(bot: Bot, event: FriendRecallNoticeEvent) = NotMatch

    open fun onFriendRequest(bot: Bot, event: FriendRequestEvent) = NotMatch

    open fun onGroupRequest(bot: Bot, event: GroupRequestEvent) = NotMatch

    open fun onGroupPokeNotice(bot: Bot, event: GroupPokeNoticeEvent) = NotMatch

    open fun onFriendPokeNotice(bot: Bot, event: FriendPokeNoticeEvent) = NotMatch

    open fun onGroupLuckyKingChangeNotice(bot: Bot, event: GroupLuckyKingChangeNoticeEvent) = NotMatch

    open fun onGroupHonorChangeNotice(bot: Bot, event: GroupHonorChangeNoticeEvent) = NotMatch

    open fun onGroupTitleUpdateNotice(bot: Bot, event: GroupTitleUpdateNoticeEvent) = NotMatch

    open fun onGroupCardUpdateNotice(bot: Bot, event: GroupCardUpdateNoticeEvent) = NotMatch

    open fun onOfflineFileNotice(bot: Bot, event: OfflineFileNoticeEvent) = NotMatch

    open fun onOtherClientStatusChangeNotice(bot: Bot, event: ClientStatusChangeNoticeEvent) = NotMatch

    open fun onEssenceNotice(bot: Bot, event: EssenceNoticeEvent) = NotMatch

    open fun onHeartbeatMeta(bot: Bot, event: HeartbeatMetaEvent) = NotMatch

    open fun onLifecycleMeta(bot: Bot, event: LifecycleMetaEvent) = NotMatch

    open fun onGuildMessage(bot: Bot, event: GuildMessageEvent) = NotMatch

    open fun onMessageReactionsUpdatedNotice(bot: Bot, event: MessageReactionsUpdatedNoticeEvent) = NotMatch

    open fun onChannelUpdatedNotice(bot: Bot, event: ChannelUpdatedNoticeEvent) = NotMatch

    open fun onChannelCreatedNotice(bot: Bot, event: ChannelCreatedNoticeEvent) = NotMatch

    open fun onChannelDestroyedNotice(bot: Bot, event: ChannelDestroyedNoticeEvent) = NotMatch

    companion object {
        const val MatchedAndBlock = 0
        const val NotMatch = 1
    }
}

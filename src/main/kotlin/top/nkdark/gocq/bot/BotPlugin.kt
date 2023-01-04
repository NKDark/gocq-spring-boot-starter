package top.nkdark.gocq.bot

import top.nkdark.gocq.proto.*

abstract class BotPlugin {
    /**
     * 收到私聊消息时调用此方法
     *
     * @param   bot     机器人对象
     * @param   event   事件内容
     * @return  消息是否处理完毕,
     *          `MatchedAndBlock`表示处理完毕不继续下一个插件处理,
     *          `Matched`表示处理完毕并继续下一个插件处理,
     *          `NotMatch`表示未处理并继续下一个插件处理
     */
    open fun onPrivateMessage(bot: Bot, event: PrivateMessageEvent) = NotMatch

    open fun onGroupMessage(bot: Bot, event: GroupMessageEvent) = NotMatch

    open fun onGroupUploadNotice(bot: Bot, event: FileUploadNoticeEvent) = NotMatch

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

    open fun onGroupCardUpdateNotice(bot: Bot, event: GroupCardUpdateNoticeEvent) = NotMatch

    open fun onReceivedOfflineFileNotice(bot: Bot, event: ReceivedOfflineFileNoticeEvent) = NotMatch

    open fun onOtherClientStatusChangeNotice(bot: Bot, event: OtherClientStatusChangeNoticeEvent) = NotMatch

    companion object {
        const val MatchedAndBlock = 0
        const val Matched = 1
        const val NotMatch = 2
    }
}

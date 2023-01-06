package top.nkdark.gocq.handler

import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.to
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import top.nkdark.gocq.boot.BotProperties
import top.nkdark.gocq.bot.Bot
import top.nkdark.gocq.bot.BotPlugin
import top.nkdark.gocq.proto.*
import top.nkdark.gocq.proto.guild.*

@Component
class EventHandler(private val applicationContext: ApplicationContext, private val botProperties: BotProperties) {

    private val log = LoggerFactory.getLogger(EventHandler::class.java)

    private fun <T> getPlugin(clazz: Class<T>): T? = try {
        applicationContext.getBean(clazz)
    } catch (_: Exception) {
        null
    }

    fun handle(bot: Bot, eventJson: JSONObject) {
        log.debug(eventJson.toJSONString())
        when (eventJson.getString("post_type")) {
            "message" -> handleMessage(bot, eventJson)
            "notice" -> handleNotice(bot, eventJson)
            "request" -> handleRequest(bot, eventJson)
            "meta_event" -> handleMeta(bot, eventJson)
        }
    }

    private fun handleMessage(bot: Bot, eventJson: JSONObject) {
        when (eventJson.getString("message_type")) {
            "private" -> {
                val event = eventJson.toJSONString().to<PrivateMessageEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onPrivateMessage(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "group" -> {
                val event = eventJson.toJSONString().to<GroupMessageEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupMessage(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "guild" -> {
                val event = eventJson.toJSONString().to<GuildMessageEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGuildMessage(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }
        }
    }

    private fun handleNotice(bot: Bot, eventJson: JSONObject) {
        when (eventJson.getString("notice_type")) {
            "group_upload" -> {
                val event = eventJson.toJSONString().to<GroupUploadNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupUploadNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "group_admin" -> {
                val event = eventJson.toJSONString().to<GroupAdminChangeNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupAdminChangeNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "group_decrease" -> {
                val event = eventJson.toJSONString().to<GroupMemberDecreaseNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupMemberDecreaseNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "group_increase" -> {
                val event = eventJson.toJSONString().to<GroupMemberIncreaseNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupMemberIncreaseNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "group_ban" -> {
                val event = eventJson.toJSONString().to<GroupBanNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupBanNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "friend_add" -> {
                val event = eventJson.toJSONString().to<FriendAddNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onFriendAddNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "group_recall" -> {
                val event = eventJson.toJSONString().to<GroupRecallNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupRecallNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "friend_recall" -> {
                val event = eventJson.toJSONString().to<FriendRecallNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onFriendRecallNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "group_card" -> {
                val event = eventJson.toJSONString().to<GroupCardUpdateNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupCardUpdateNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "offline_file" -> {
                val event = eventJson.toJSONString().to<OfflineFileNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onOfflineFileNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "client_status" -> {
                val event = eventJson.toJSONString().to<ClientStatusChangeNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onOtherClientStatusChangeNotice(
                            bot,
                            event
                        ) == BotPlugin.MatchedAndBlock
                    ) {
                        return
                    }
                }
            }

            "essence" -> {
                val event = eventJson.toJSONString().to<EssenceNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onEssenceNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "notify" -> handleNotify(bot, eventJson)

            "message_reactions_updated" -> {
                val event = eventJson.toJSONString().to<MessageReactionsUpdatedNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onMessageReactionsUpdatedNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "channel_updated" -> {
                val event = eventJson.toJSONString().to<ChannelUpdatedNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onChannelUpdatedNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "channel_created" -> {
                val event = eventJson.toJSONString().to<ChannelCreatedNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onChannelCreatedNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "channel_destroyed" -> {
                val event = eventJson.toJSONString().to<ChannelDestroyedNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onChannelDestroyedNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }
        }
    }

    private fun handleNotify(bot: Bot, eventJson: JSONObject) {
        when (eventJson.getString("sub_type")) {
            "honor" -> {
                val event = eventJson.toJSONString().to<GroupHonorChangeNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupHonorChangeNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "poke" -> handlePoke(bot, eventJson)

            "lucky_king" -> {
                val event = eventJson.toJSONString().to<GroupLuckyKingChangeNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupLuckyKingChangeNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "title" -> {
                val event = eventJson.toJSONString().to<GroupTitleUpdateNoticeEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupTitleUpdateNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }
        }
    }

    private fun handleRequest(bot: Bot, eventJson: JSONObject) {
        when (eventJson.getString("request_type")) {
            "friend" -> {
                val event = eventJson.toJSONString().to<FriendRequestEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onFriendRequest(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "group" -> {
                val event = eventJson.toJSONString().to<GroupRequestEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onGroupRequest(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }
        }
    }

    private fun handlePoke(bot: Bot, eventJson: JSONObject) {
        if (eventJson.containsKey("group_id")) {
            val event = eventJson.toJSONString().to<GroupPokeNoticeEvent>()
            botProperties.pluginList.forEach { pluginClass ->
                if (getPlugin(pluginClass)?.onGroupPokeNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                    return
                }
            }
        } else {
            val event = eventJson.toJSONString().to<FriendPokeNoticeEvent>()
            botProperties.pluginList.forEach { pluginClass ->
                if (getPlugin(pluginClass)?.onFriendPokeNotice(bot, event) == BotPlugin.MatchedAndBlock) {
                    return
                }
            }
        }
    }

    private fun handleMeta(bot: Bot, eventJson: JSONObject) {
        when (eventJson.getString("meta_event_type")) {
            "heartbeat" -> {
                val event = eventJson.toJSONString().to<HeartbeatMetaEvent>()
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onHeartbeatMeta(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }

            "lifecycle" -> {
                val event = eventJson.toJavaObject(LifecycleMetaEvent::class.java)
                botProperties.pluginList.forEach { pluginClass ->
                    if (getPlugin(pluginClass)?.onLifecycleMeta(bot, event) == BotPlugin.MatchedAndBlock) {
                        return
                    }
                }
            }
        }
    }
}

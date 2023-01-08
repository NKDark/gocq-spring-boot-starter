package com.example.bot.plugin

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import top.nkdark.gocq.bot.Bot
import top.nkdark.gocq.bot.BotPlugin
import top.nkdark.gocq.proto.GroupMessageEvent
import top.nkdark.gocq.proto.PrivateMessageEvent
import top.nkdark.gocq.proto.guild.GuildMessageEvent

@Component
class TestPlugin : BotPlugin() {

    /**
     * 日志工具
     */
    private val log = LoggerFactory.getLogger(TestPlugin::class.java)

    /**
     * 收到私聊消息时会调用这个方法
     *
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendPrivateMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return 是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    override fun onPrivateMessage(bot: Bot, event: PrivateMessageEvent): Int {
        bot.sendPrivateMsg(event.userId, event.message)
        return MatchedAndBlock
    }


    /**
     * 收到群消息时会调用这个方法
     *
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendGroupMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return 是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    override fun onGroupMessage(bot: Bot, event: GroupMessageEvent): Int {
        log.info(event.message)
        return NotMatch
    }


    /**
     * 收到频道消息时会调用这个方法
     *
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendGroupMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return 是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    override fun onGuildMessage(bot: Bot, event: GuildMessageEvent): Int {
        log.info(event.message)
        return NotMatch
    }
}
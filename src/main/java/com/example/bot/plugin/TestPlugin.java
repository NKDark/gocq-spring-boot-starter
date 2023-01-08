package com.example.bot.plugin;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import top.nkdark.gocq.bot.Bot;
import top.nkdark.gocq.bot.BotPlugin;
import top.nkdark.gocq.proto.GroupMessageEvent;
import top.nkdark.gocq.proto.PrivateMessageEvent;
import top.nkdark.gocq.proto.guild.GuildMessageEvent;

@Slf4j
@Component
public class TestPlugin extends BotPlugin {

    /**
     * 收到私聊消息时会调用这个方法
     *
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendPrivateMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return 是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    @Override
    public int onPrivateMessage(@NotNull Bot bot, @NotNull PrivateMessageEvent event) {
        // 获取 发送者QQ 和 消息内容
        long userId = event.getUserId();
        String msg = event.getMessage();
        // 控制台打印
        log.info(msg);
        // 将收到的消息复读
        bot.sendPrivateMsg(userId, msg, false);
        // 继续执行下一个插件
        return NotMatch;
    }

    /**
     * 收到群消息时会调用这个方法
     *
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendGroupMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return 是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        // 获取 消息内容 群号 发送者QQ
        String msg = event.getMessage();
        long groupId = event.getGroupId();
        long userId = event.getUserId();
        // 控制台打印日志
        log.info("from group " + groupId + " received " + userId + "'s message: " + msg);
        // 编辑回复内容
//        String respContent = CQCode.INSTANCE.at(114514) + "1919810";
        // 通过 bot 实例，调用api发送消息至群聊
//        bot.sendGroupMsg(groupId, respContent, false);
        // 不继续执行下一个插件
        return MatchedAndBlock;
    }

    /**
     * 收到频道消息时会调用这个方法
     *
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendGroupMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return 是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    @Override
    public int onGuildMessage(@NotNull Bot bot, @NotNull GuildMessageEvent event) {
        log.info(event.toString());
        return MatchedAndBlock;
    }
}

# gocq-spring-boot-starter

在下的群 [![QQ群](https://img.shields.io/static/v1?label=QQ%E7%BE%A4&message=793140364&color=blue)](https://jq.qq.com/?_wv=1027&k=gDfqoLIi)

又一个基于 [go-cqhttp](https://github.com/Mrs4s/go-cqhttp)、[SpringBoot](https://github.com/spring-projects/spring-boot)、反向websocket 的 QQ 机器人框架SDK

对[lz](https://github.com/lz1998)的项目进行了拙劣的模仿

lz的群 [![QQ群](https://img.shields.io/static/v1?label=QQ%E7%BE%A4&message=335783090&color=blue)](https://jq.qq.com/?_wv=1027&k=5BKAROL)

### 本项目基于 [SpringBoot 2.7.7](https://github.com/spring-projects/spring-boot/tree/v2.7.7) 版本开发

## 1. 插件开发
### 1.1 创建一个Spring boot项目 并且导入 [`Maven`](https://maven.apache.org) 依赖项
```xml
<dependency>
    <groupId>top.nkdark</groupId>
    <artifactId>gocq-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 1.2 编写插件

### 1.2.1 编写示例

#### [`Java`](https://www.java.com) 示例
```java
package org.example.bot;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.nkdark.gocq.bot.Bot;
import top.nkdark.gocq.bot.BotPlugin;
import top.nkdark.gocq.proto.GroupMessageEvent;
import top.nkdark.gocq.proto.PrivateMessageEvent;
import top.nkdark.gocq.util.CQCode;

/**
 * 示例插件
 * 1. 插件继承自 BotPlugin
 * 2. 添加 @Component 注解
 */
@Component
public class JavaTestPlugin extends BotPlugin {

    /**
     * 可选，日志工具
     * 也可使用 lombok 的 @Slf4j 注解
     */
    private final Logger log = LoggerFactory.getLogger(JavaTestPlugin.class);

    /**
     * 收到私聊消息时会调用这个方法
     * 
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendPrivateMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return  是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
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
     * @return  是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    @Override
    public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        // 获取 消息内容 群号 发送者QQ
        String msg = event.getMessage();
        long groupId = event.getGroupId();
        long userId = event.getUserId();
        // 控制台打印日志
        log.info(msg);
        // 编辑回复内容
        String respContent = CQCode.INSTANCE.at(114514) + "1919810";
        // 通过 bot 实例，调用api发送消息至群聊
        bot.sendGroupMsg(groupId, respContent, false);
        // 不继续执行下一个插件
        return MatchedAndBlock;
    }

    /**
     * 收到频道消息时会调用这个方法
     * 
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendGroupMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return  是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    @Override
    public int onGuildMessage(@NotNull Bot bot, @NotNull GuildMessageEvent event) {
        log.info(event.toString());
        return MatchedAndBlock;
    }
}
```

#### [`Kotlin`](https://kotlinlang.org/) 示例
```kotlin
package org.example.bot

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import top.nkdark.gocq.bot.Bot
import top.nkdark.gocq.bot.BotPlugin
import top.nkdark.gocq.proto.GroupMessageEvent
import top.nkdark.gocq.proto.PrivateMessageEvent
import top.nkdark.gocq.proto.guild.GuildMessageEvent
import top.nkdark.gocq.util.CQCode

/**
 * 示例插件
 * 1. 插件继承自 BotPlugin
 * 2. 添加 @Component 注解
 */
@Component
class TestPlugin : BotPlugin() {

    /**
     * 可选，日志工具
     * 也可使用 lombok 的 @Slf4j 注解
     */
    private val log = LoggerFactory.getLogger(TestPlugin::class.java)

    /**
     * 收到私聊消息时会调用这个方法
     * 
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendPrivateMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return  是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    override fun onPrivateMessage(bot: Bot, event: PrivateMessageEvent): Int {
        // 获取 发送者QQ 和 消息内容
        val userId = event.userId
        val msg = event.message
        // 将收到的消息复读
        bot.sendPrivateMsg(userId, msg)
        // 将日志打印至 debug
        log.debug("复读了一条来自 ${event.sender.nickname} 的消息")
        return NotMatch
    }
    
    /**
     * 收到群消息时会调用这个方法
     * 
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendGroupMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return  是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    override fun onGroupMessage(bot: Bot, event: GroupMessageEvent): Int {
        // 获取 消息内容 群号 发送者QQ
        val msg: String = event.message
        val groupId: Long = event.groupId
        val userId: Long = event.userId
        // 控制台打印日志
        log.info(msg)
        // 编辑回复内容
        val respContent = CQCode.at(114514) + "1919810"
        // 通过 bot 实例，调用api发送消息至群聊
        bot.sendGroupMsg(groupId, respContent, false)
        return MatchAndBlock
    }

    /**
     * 收到频道消息时会调用这个方法
     * 
     * @param bot   机器人对象，用于调用API，例如发送私聊消息 sendGroupMsg
     * @param event 事件对象，用于获取消息内容、群号、发送者QQ等
     * @return  是否继续调用下一个插件, `MatchedAndBlock` 表示不继续, `NotMatch` 表示继续
     */
    override fun onGuildMessage(bot: Bot, event: GuildMessageEvent): Int {
        log.info(event.toString())
        return MatchedAndBlock
    }
}
```
### 1.2.2 修改配置文件

修改 resource/application.yml
```yaml
server:
  port: 12345 # 端口号请根据情况自行安排

spring:
  cq:
    # 请将编写的插件全类名添加在这里
    # 在收到消息时会按顺序依次调用以下插件
    # 如果前面的插件返回 MatchedAndBlock 则不会继续调用后续插件
    # 如果前面的插件返回 NotMatch 则会继续调用后续插件
    plugin-list:
      - org.example.bot.TestPlugin
      - org.example.bot.JavaTestPlugin
```

## 1.3 打包部署
1. 使用 [`maven`](https://maven.apache.org) 打包应用
```shell
mvn clean package
```

2. 打包好的 jar 包将会出现在 ${项目路径}/target 目录下

## 1.4 运行程序
```shell
java -jar xxx.jar
```

# reference
> [pbbot-spring-boot-starter](https://github.com/ProtobufBot/pbbot-spring-boot-starter)
> 
> [Spring-CQ](https://github.com/lz1998/Spring-CQ/tree/jar)
@file:Suppress("unused", "NAME_SHADOWING")

package top.nkdark.gocq.util

import top.nkdark.gocq.EGiftType
import top.nkdark.gocq.EImageEffect
import top.nkdark.gocq.EImageSubType
import top.nkdark.gocq.EImageType

/**
 * 酷Q码工具类
 * https://docs.go-cqhttp.org/cqcode/
 */
object CQCode {
    @JvmStatic
    fun unescape(str: String): String {
        return str.replace("&#44;", ",")
            .replace("&#91;", "[")
            .replace("&#93;", "]")
            .replace("&amp;", "&")
    }

    @JvmStatic
    fun escape(str: String) =
        str.replace(",", "&#44;")
            .replace("[", "&#91;")
            .replace("]", "&#93;")
            .replace("&", "&amp;")

    /**
     * 系统表情
     *
     *  [ID对照表](https://github.com/kyubotics/coolq-http-api/wiki/%E8%A1%A8%E6%83%85-CQ-%E7%A0%81-ID-%E8%A1%A8)
     *
     * @param id 为≥0的数字
     * @return [CQ:face,id=14]（发送一个微笑的系统表情）
     */
    @JvmStatic
    fun face(id: Int) = "[CQ:face,id=$id]"

    /**
     * 语音
     *
     * @param file  音频文件名称
     * @param magic 发送时可选, 默认 0, 设置为 1 表示变声
     * @return [CQ:record,file={1},magic={2},cache={2},timeout={3}]
     */
    @JvmStatic
    fun record(file: String, magic: Int = 0) = "[CQ:record,file=${escape(file)},magic=$magic]"

    /**
     * 语音
     *
     * @param file    音频文件名称，音频存放在酷Q目录的data\record\下
     * @param magic   是否为变声，若该参数为true则显示变声标记。该参数可被忽略。
     * @param cache   只在通过网络 URL 发送时有效, 表示是否使用已缓存的文件, 默认 1
     * @param proxy   只在通过网络 URL 发送时有效, 表示是否通过代理下载文件 ( 需通过环境变量或配置文件配置代理 ) , 默认 1
     * @param timeout 下载操作超时(单位秒)
     * @return
     */
    @JvmStatic
    fun record(file: String, magic: Int = 0, cache: Int = 1, proxy: Int = 1, timeout: Int) =
        "[CQ:record,file=${escape(file)},magic=$magic,cache=$cache,proxy=$proxy,timeout=$timeout]"

    @JvmStatic
    fun video(file: String, cover: String, downloadThreadNum: Int = 1) =
        "[CQ:video,file=$file,cover=$cover,c=$downloadThreadNum]"


    @JvmStatic
    fun video(file: String, cover: String) = "[CQ:video,file=$file,cover=$cover]"


    @JvmStatic
    fun video(file: String) = "[CQ:video,file=$file]"

    /**
     * at某人
     *
     * @param qq 被@的群成员帐号
     * @return [CQ:at,qq={1}]
     */
    @JvmStatic
    fun at(qq: Long) = "[CQ:at,qq=$qq]"

    /**
     * at某人
     *
     * @param qq   被@的群成员帐号
     * @param name 当在群中找不到此QQ号的名称时才会生效
     */
    @JvmStatic
    fun at(qq: Long, name: String) = "[CQ:at,qq=$qq,name=$name]"


    /**
     * at全体成员
     */
    @JvmStatic
    fun atAll() = "[CQ:at,qq=all]"

    /**
     * 链接分享
     *
     * @param url     分享链接
     * @param title   分享的标题，建议12字以内
     * @return [CQ:share,url={1},title={2}]
     */
    @JvmStatic
    fun share(url: String, title: String) = "[CQ:share,url=${escape(url)},title=${escape(title)}]"

    /**
     * 链接分享
     *
     * @param url     分享链接
     * @param title   分享的标题，建议12字以内
     * @param content 分享的简介，建议30字以内。该参数可被忽略。
     * @return [CQ:share,url={1},title={2},content={3}]
     */
    @JvmStatic
    fun share(url: String, title: String, content: String) =
        "[CQ:share,url=${escape(url)},title=${escape(title)},content=${escape(content)}]"

    /**
     * 链接分享
     *
     * @param url     分享链接
     * @param title   分享的标题，建议12字以内
     * @param content 分享的简介，建议30字以内。该参数可被忽略。
     * @param image   分享的图片链接。若参数为空或被忽略，则显示默认图片
     * @return [CQ:share,url={1},title={2},content={3},image={4}]
     */
    @JvmStatic
    fun share(url: String, title: String, content: String, image: String) =
        "[CQ:share,url=${escape(url)},title=${escape(title)},content=${escape(content)},image=${escape(image)}]"

    /**
     * 音乐
     *
     * @param type  音乐平台类型，目前支持 `qq`、`163`、`xm` 分别表示使用 QQ 音乐、网易云音乐、虾米音乐
     * @param id    对应音乐平台的数字音乐id
     * @return [CQ:music,type={1},id={2},style={3}]
     */
    @JvmStatic
    fun music(type: String, id: Int) = "[CQ:music,type=${escape(type)},id=$id]"

    /**
     * 音乐自定义分享
     *
     * @param url     分享链接，即点击分享后进入的音乐页面（如歌曲介绍页）
     * @param audio   音频链接（如mp3链接）
     * @param title   音乐的标题，建议12字以内
     * @param content 音乐的简介，建议30字以内。该参数可被忽略
     * @param image   音乐的封面图片链接。若参数为空或被忽略，则显示默认图片
     * @return [CQ:music,type=custom,url={1},audio={2},title={3},content={4},image={5}]
     */
    @JvmStatic
    fun customMusic(url: String, audio: String, title: String, content: String, image: String) =
        "[CQ:music,type=custom,url=${escape(url)},audio=${escape(audio)},title=${escape(title)}," +
                "content=${escape(content)},image=${escape(image)}]"

    /**
     * 图片
     *
     * @param file 图片文件名称
     * @return [CQ:image,file={1}]
     */
    @JvmStatic
    fun image(file: String) = "[CQ:image,file=${escape(file)}]"

    /**
     * 自定义图片
     *
     * 图片最大不能超过30MB
     *
     * PNG格式不会被压缩, JPG可能不会二次压缩, GIF非动图转成PNG
     *
     * GIF动图原样发送(总帧数最大300张, 超过无法发出, 无论循不循环)
     *
     * @param file    图片文件名称，图片存放在酷Q目录的data\image\下
     * @param cache   是否缓存
     */
    @JvmStatic
    fun image(
        file: String,
        type: EImageType,
        subType: EImageSubType?,
        url: String,
        cache: Boolean,
        imageEffect: EImageEffect,
        c: Int = 1
    ): String {
        val cache = if (cache) 1 else 0
        return when (type) {
            EImageType.Plain -> "[CQ:image,file=${escape(file)}${subType?.let { ",subType=$subType" }},url=$url,cache=$cache,id=$imageEffect,c=$c]"
            else -> "[CQ:image,file=${escape(file)},type=$type${subType?.let { ",subType=$subType" }},url=$url,cache=$cache,id=$imageEffect,c=$c]"
        }
    }

    /**
     * 回复
     *
     * @param id    回复时所引用的消息id, 必须为本群消息.
     */
    @JvmStatic
    fun reply(id: Int) = "[CQ:reply,id=$id]"

    /**
     * 自定义回复
     *
     * @param text  自定义回复的信息
     * @param qq    自定义回复时的自定义QQ
     * @param time  自定义回复时的时间, 格式为Unix时间
     * @param seq   起始消息序号, 可通过 get_msg 获得
     */
    @JvmStatic
    fun reply(text: String, qq: Long, time: Long, seq: Long) = "[CQ:reply,text=$text,qq=$qq,time=$time,seq=$seq]"

    /**
     * 戳一戳（仅限群聊）
     *
     * 无法撤回
     * 返回的 message_id 恒为 0
     *
     * @param qq    需要戳的成员
     */
    @JvmStatic
    fun poke(qq: Long) = "[CQ:poke,qq=$qq]"

    /**
     * 礼物
     *
     * 仅支持免费礼物
     * 无法撤回
     * 返回的 message_id 恒为 0
     */
    @JvmStatic
    fun gift(qq: Long, id: EGiftType) = "[CQ:gift,qq=$qq,id=$id]"

    /**
     * 合并转发消息节点
     */
    @JvmStatic
    fun node(id: Int) = "[CQ:node,id=$id]"

    /**
     * 自定义合并转发消息节点
     * todo 消息构建方法
     */
    @JvmStatic
    fun node(name: String, uin: Long, content: String, seq: String) =
        "[CQ:node,name=$name,uin=$uin,content=$content,seq=$seq]"

    /**
     * XML 消息
     *
     * @param data  xml内容, xml中的value部分, 记得实体化处理
     */
    @JvmStatic
    fun xml(data: String) = "[CQ:xml,data=$data]"

    /**
     * JSON 消息
     *
     * @param data  json内容
     */
    @JvmStatic
    fun json(data: String) = "[CQ:json,data=${escape(data)}]"

    /**
     * JSON 消息
     *
     * @param data  json内容
     * @param resId 默认不填为0, 走小程序通道, 填了走富文本通道发送
     */
    @JvmStatic
    fun json(data: String, resId: Int) = "[CQ:json,data=${escape(data)},resid=$resId]"

    /**
     * 装逼大图
     */
    @JvmStatic
    fun cardImage(file: String) = "[CQ:cardimage,file=$file]"

    /**
     * 装逼大图
     *
     * @param file
     */
    @JvmStatic
    fun cardImage(
        file: String,
        minWidth: Long = 400,
        minHeight: Long = 400,
        maxWidth: Long = 500,
        maxHeight: Long = 1000,
        source: String?,
        icon: String?
    ) =
        "[CQ:cardimage,file=$file,minwidth=$minWidth,minheight=$minHeight,maxwidth=$maxWidth,maxheight=$maxHeight" +
                "${source?.let { ",source=$it" }}${icon?.let { ",icon=$it" }}]"

}
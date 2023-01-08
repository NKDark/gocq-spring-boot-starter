@file:Suppress("unused")

package top.nkdark.gocq

val TempSource = mapOf(
    0 to "群聊",
    1 to "QQ咨询",
    2 to "查找",
    3 to "QQ电影",
    4 to "热聊",
    6 to "验证消息",
    7 to "多人聊天",
    8 to "约会",
    9 to "通讯录",
)

fun getTempSource(type: Int) = TempSource[type]

enum class EMessageType(private val type: String) {
    Private("private"),
    Group("group"),
    ;

    override fun toString() = type
}

enum class EGroupRequestType(private val type: String) {
    Add("add"),
    Invite("invite"),
    ;

    override fun toString() = type
}

enum class EGroupHonorType(private val type: String) {
    Talkative("talkative"),
    Performer("performer"),
    Legend("legend"),
    StrongNewbie("strong_newbie"),
    Emotion("emotion"),
    ;

    override fun toString() = type
}

enum class EImageType(private val value: String) {
    Flash("flash"),
    Show("show"),
    Plain("plain"),
    ;

    override fun toString() = value
}

enum class EImageEffect(private val id: Int) {
    /**
     * 普通
     */
    Normal(40000),

    /**
     * 幻影
     */
    Phantom(40001),

    /**
     * 抖动
     */
    Shake(40002),

    /**
     * 生日
     */
    BirthDay(40003),

    /**
     * 爱你
     */
    LoveYou(40004),

    /**
     * 征友
     */
    SeekFriends(40005)
    ;

    override fun toString() = "$id"
}

enum class EImageSubType(private val value: Byte) {
    /**
     * 正常图片
     */
    Normal(0),

    /**
     * 表情包, 在客户端会被分类到表情包图片并缩放显示
     */
    Meme(1),

    /**
     * 热图
     */
    Hot(2),

    /**
     * 斗图
     */
    Battle(3),

    /**
     * 智图?
     */
    Wise(4),

    /**
     * 贴图
     */
    Sticker(7),

    /**
     * 自拍
     */
    Selfie(8),

    /**
     * 贴图广告?
     */
    SelfieAd(9),

    /**
     * 有待测试
     */
    Unknown(10),

    /**
     * 热搜图
     */
    HotSearch(13),
    ;

    override fun toString() = "$value"
}

enum class EGiftType(private val id: Byte) {
    /**
     * 甜 Wink
     */
    Wink(0),

    /**
     * 快乐肥宅水
     */
    Cola(1),

    /**
     * 幸运手链
     */
    LuckyBracelet(2),

    /**
     * 卡布奇诺
     */
    Cappuccino(3),

    /**
     * 猫咪手表
     */
    KittyWatch(4),

    /**
     * 绒绒手套
     */
    FluffGloves(5),

    /**
     * 彩虹糖果
     */
    RainbowCandy(6),

    /**
     * 坚强
     */
    Strong(7),

    /**
     * 告白话筒
     */
    Mic(8),

    /**
     * 牵你的手
     */
    HandInHand(9),

    /**
     * 可爱猫咪
     */
    CuteKitty(10),

    /**
     * 神秘面具
     */
    SecretMask(11),

    /**
     * 我超忙的
     */
    Busy(12),

    /**
     * 爱心口罩
     */
    LoveMask(13),
    ;

    override fun toString() = "$id"
}

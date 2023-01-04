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

fun getTempSource(type: Int): String? {
    return TempSource[type]
}
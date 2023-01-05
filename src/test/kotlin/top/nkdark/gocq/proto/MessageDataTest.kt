package top.nkdark.gocq.proto

import com.alibaba.fastjson2.to
import org.junit.jupiter.api.Test

class MessageDataTest {
    @Test
    fun testDeRetData() {
        val str = """
            {
                "group": true,
                "group_id": 1,
                "message_id": 2,
                "real_id": 3,
                "message_type": "group",
                "sender": {
                    "nickname": "田所浩二",
                    "user_id": 114514
                },
                "time": 4,
                "message": "struct currently unknown",
                "raw_message": "struct currently unknown"
            }
        """.trimIndent()
        val messageData = str.to<MessageData>()
        println(messageData)
    }
}
package top.nkdark.gocq.proto

import com.alibaba.fastjson2.to
import org.junit.jupiter.api.Test

class MessageEventTest {

    @Test
    fun test_deMessageEvent() {
        val str = """
            {
                'time': 1,
                'self_id': 0,
                'post_type': 'message',
                'message_type': 'private',
                'sub_type': 'group',
                'message_id': 2,
                'user_id': 1,
                'group_id': 6,
                'message': 4,
                'raw_message': 'raw_message',
                'font': 0,
                'sender': {
                              'user_id': 2,
                              'nickname': 'nick',
                              'sex': 'male',
                              'age': 3,
                              'card': 'card',
                              'area': '?'
                          }
            }
            """.trimIndent()
        val data = str.to<GroupMessageEvent>()
        println(data)
    }
}
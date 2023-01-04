package top.nkdark.gocq.proto

import org.junit.jupiter.api.Test

class MessageTypeTest {
    @Test
    fun test_deMessageType() {
        val str = "{'message_type': 'private'}"
        val mt = MessageType("private")
        println(mt)
    }
}
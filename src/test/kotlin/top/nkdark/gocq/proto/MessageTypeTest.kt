package top.nkdark.gocq.proto

import com.alibaba.fastjson2.toJSONString
import org.junit.jupiter.api.Test

class MessageTypeTest {
    @Test
    fun test_deMessageType() {
        val mt = MessageType("private")
        val mtJsonStr = mt.toJSONString()
        assert("private" == mt.toString())
        assert("{}" == mtJsonStr)
    }
}
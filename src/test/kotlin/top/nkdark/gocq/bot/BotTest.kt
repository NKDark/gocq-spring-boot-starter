package top.nkdark.gocq.bot

import com.alibaba.fastjson2.JSONObject
import org.junit.jupiter.api.Test

class BotTest {

    @Test
    fun testHeaderParse() {
        val reduce = mapOf("User-Agent" to "some ua", "Referer" to "https://www.baidu.com")
            .map { "${it.key}=${it.value}" }
            .reduce { self, that -> "$self\r\n$that" }
        val str = "User-Agent=some ua\r\nReferer=https://www.baidu.com"
        assert(reduce == str)
    }

    @Test
    fun testFastJsonParse() {
        val jsonStr = """
            {
                "status": "",
                "retcode": 0,
                "data": null
            }
        """.trimIndent()
        val parse = JSONObject.parse(jsonStr)
        val str = """{"status":"","retcode":0}"""
        assert(str == parse.toString())
    }

}
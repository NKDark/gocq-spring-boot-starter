package top.nkdark.gocq

import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.to
import org.junit.jupiter.api.Test
import top.nkdark.gocq.proto.ApiData

class ApiDataTest {

    @Test
    fun test_deApiData() {
        val str = "{'status': 'status_content', 'retcode': 0, 'data': 'test_data'}"
        val data = str.to<ApiData<Any>>()
        println(data)
    }

    @Test
    fun testKtN() {
        val str1: String? = null
        val str2 = "114514"
        val json = JSONObject()
        json["str1"] = str1
        json["str2"] = str2
        assert("""{"str2":"114514"}""" == json.toString())
    }

}

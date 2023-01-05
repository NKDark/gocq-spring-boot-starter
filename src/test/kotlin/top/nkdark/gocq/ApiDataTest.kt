package top.nkdark.gocq

import org.junit.jupiter.api.Test
import com.alibaba.fastjson2.*
import top.nkdark.gocq.proto.ApiData

class ApiDataTest {

    @Test
    fun test_deApiData() {
        val str = "{'status': 'status_content', 'retcode': 0, 'data': 'test_data'}"
        val data = str.to<ApiData<Any>>()
        println(data)
    }

}

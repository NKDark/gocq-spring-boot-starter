package top.nkdark.gocq.proto

import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.annotation.JSONField

data class ApiRawData(
    @JSONField(name = "status")
    val status: String,

    @JSONField(name = "retcode")
    val retcode: Int,

    @JSONField(name = "data")
    val data: JSONObject,
)

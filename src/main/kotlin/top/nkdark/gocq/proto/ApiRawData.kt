package top.nkdark.gocq.proto

import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.annotation.JSONField

data class ApiRawData(
    @JSONField(name = "status")
    private val status: String,

    @JSONField(name = "retcode")
    private val retcode: Int,

    @JSONField(name = "data")
    private val data: JSONObject,
)

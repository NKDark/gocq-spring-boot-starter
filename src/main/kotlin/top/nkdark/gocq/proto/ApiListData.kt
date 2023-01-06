package top.nkdark.gocq.proto

import com.alibaba.fastjson2.annotation.JSONField

data class ApiListData<T>(
    @JSONField(name = "status")
    val status: String,

    @JSONField(name = "retcode")
    val retcode: Int,

    @JSONField(name = "data")
    val data: List<T>,
)
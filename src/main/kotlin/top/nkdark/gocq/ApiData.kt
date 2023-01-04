package top.nkdark.gocq

import com.alibaba.fastjson2.annotation.JSONField

data class ApiData<T>(
    @JSONField(name = "status")
    private val status: String,

    @JSONField(name = "retcode")
    private val retcode: Int,

    @JSONField(name = "data")
    private val data: T,
)
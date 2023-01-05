package top.nkdark.gocq.bot

import com.alibaba.fastjson2.JSONObject

interface IApiRequest {
    fun getEndpoint(): String

    fun getParams(): JSONObject?
}

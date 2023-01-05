package top.nkdark.gocq.proto

import com.alibaba.fastjson2.annotation.JSONField


data class HeartbeatMetaEvent(
    @JSONField(name = "interval")
    val interval: Int,
    @JSONField(name = "meta_event_type")
    val metaEventType: String,
    @JSONField(name = "post_type")
    val postType: String,
    @JSONField(name = "self_id")
    val selfId: Long,
    @JSONField(name = "status")
    val status: StatusData,
    @JSONField(name = "time")
    val time: Long,
)

data class LifecycleMetaEvent(
    @JSONField(name = "meta_event_type")
    val metaEventType: String,
    @JSONField(name = "post_type")
    val postType: String,
    @JSONField(name = "self_id")
    val selfId: Int,
    @JSONField(name = "sub_type")
    val subType: String,
    @JSONField(name = "time")
    val time: Int,
)
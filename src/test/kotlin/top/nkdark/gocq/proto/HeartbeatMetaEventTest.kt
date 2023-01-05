package top.nkdark.gocq.proto

import com.alibaba.fastjson2.JSONObject
import com.alibaba.fastjson2.to
import org.junit.jupiter.api.Test

class HeartbeatMetaEventTest {
    @Test
    fun testDeHeartbeatMeta() {
        val str =
            "{\"post_type\":\"meta_event\",\"meta_event_type\":\"heartbeat\",\"time\":1672904775,\"self_id\":2064973960,\"status\":{\"app_enabled\":true,\"app_good\":true,\"app_initialized\":true,\"good\":true,\"online\":true,\"stat\":{\"packet_received\":95,\"packet_sent\":84,\"packet_lost\":0,\"message_received\":2,\"message_sent\":0,\"disconnect_times\":0,\"lost_times\":0,\"last_message_time\":1672903463}},\"interval\":5000}"
        val jsonObject = JSONObject.parse(str)
        val heartbeatMetaEvent = jsonObject.toJSONString().to<HeartbeatMetaEvent>()
//        val heartbeatMetaEvent = str.to<HeartbeatMetaEvent>()
        println(heartbeatMetaEvent)
    }
}
package top.nkdark.gocq.proto;

import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

class MessageDataJTest {

    @Test
    public void testDeRetData() {
        String str = "{\"group\":false,\"message\":\"struct currently unknown\",\"message_id\":2,\"message_type\":\"private\",\"raw_message\":\"struct currently unknown\",\"real_id\":3,\"sender\":{\"nickname\":\"田所浩二\",\"user_id\":114514},\"time\":4}";
        MessageData messageData = JSONObject.parseObject(str, MessageData.class);
        System.out.println(messageData);
    }
}
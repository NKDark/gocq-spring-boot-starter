package top.nkdark.gocq.proto.message;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import top.nkdark.gocq.proto.Event;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageEvent extends Event {

    @JSONField(name = "message_type")
    private String messageType;

    @JSONField(name = "user_id")
    private Long userId;

    @JSONField(name = "message")
    private String message;

    @JSONField(name = "raw_message")
    private String rawMessage;

    @JSONField(name = "font")
    private Integer font;

}

package top.nkdark.gocq.proto.common;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuildMessageId {
    @JSONField(name = "message_id")
    private String messageId;
}

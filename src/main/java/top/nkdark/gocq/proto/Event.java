package top.nkdark.gocq.proto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @JSONField(name = "post_type")
    private String postType;

    @JSONField(name = "time")
    private Long time;

    @JSONField(name = "self_id")
    private Long selfId;
}

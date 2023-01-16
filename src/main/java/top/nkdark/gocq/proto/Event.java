package top.nkdark.gocq.proto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    /**
     * 上报类型
     */
    @JSONField(name = "post_type")
    private String postType;

    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time")
    private Long time;

    /**
     * 收到事件的机器人 QQ 号
     */
    @JSONField(name = "self_id")
    private Long selfId;
}

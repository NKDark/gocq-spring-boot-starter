package top.nkdark.gocq.proto.notice;

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
public class NoticeEvent extends Event {
    /**
     * 通知类型
     */
    @JSONField(name = "notice_type")
    private String noticeType;

    @JSONField(name = "user_id")
    private Long userId;
}

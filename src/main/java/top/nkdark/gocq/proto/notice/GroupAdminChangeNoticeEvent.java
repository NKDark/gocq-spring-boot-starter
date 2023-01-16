package top.nkdark.gocq.proto.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 群管理员变动事件
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupAdminChangeNoticeEvent extends NoticeEvent {
    /**
     * set、unset
     * 事件子类型, 分别表示设置和取消管理
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 管理员 QQ 号
     */
    @JSONField(name = "user_id")
    private Long userId;
}

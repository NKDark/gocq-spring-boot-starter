package top.nkdark.gocq.proto.notice;


import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 群成员减少事件
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupMemberDecreaseNoticeEvent extends NoticeEvent {
    /**
     * 事件子类型, 分别表示主动退群、成员被踢、登录号被踢
     * <p>
     * 可能的值: `leave`, `kick`, `kick_me`
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 操作者 QQ 号 ( 如果是主动退群, 则和 user_id 相同 )
     */
    @JSONField(name = "operator_id")
    private Long operatorId;

    /**
     * 离开者 QQ 号
     */
    @JSONField(name = "user_id")
    private Long userId;
}

package top.nkdark.gocq.proto.message;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrivateMessageEvent extends MessageEvent {
    /**
     * 消息 ID
     */
    @JSONField(name = "message_id")
    private Integer messageId;

    /**
     * 消息子类型, 如果是好友则是 friend, 如果是群临时会话则是 group, 如果是在群中自身发送则是 group_self
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 发送人信息
     */
    @JSONField(name = "sender")
    private Sender sender;

    /**
     * 临时会话来源
     */
    @JSONField(name = "temp_source")
    private Integer tempSource;

    /**
     * sender信息
     */
    @Data
    public static class Sender {

        /**
         * 当 subType 值为 group 时，表示本次私聊事件为临时会话，此时 groupId 为来源 QQ 群
         */
        @JSONField(name = "group_id")
        private Long groupId;

        @JSONField(name = "user_id")
        private Long userId;

        @JSONField(name = "nickname")
        private String nickname;

        @JSONField(name = "sex")
        private String sex;

        @JSONField(name = "age")
        private Integer age;
    }
}

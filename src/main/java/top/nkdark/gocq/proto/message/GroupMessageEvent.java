package top.nkdark.gocq.proto.message;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import top.nkdark.gocq.proto.common.Anonymous;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupMessageEvent extends MessageEvent {
    @JSONField(name = "message_id")
    private Integer messageId;

    @JSONField(name = "sub_type")
    private String subType;

    @JSONField(name = "group_id")
    private Long groupId;

    @JSONField(name = "anonymous")
    private Anonymous anonymous;

    @JSONField(name = "sender")
    private Sender sender;

    /**
     * sender信息
     */
    @Data
    public static class Sender {

        @JSONField(name = "user_id")
        private String userId;

        @JSONField(name = "nickname")
        private String nickname;

        @JSONField(name = "card")
        private String card;

        @JSONField(name = "sex")
        private String sex;

        @JSONField(name = "age")
        private Integer age;

        @JSONField(name = "area")
        private String area;

        @JSONField(name = "level")
        private String level;

        @JSONField(name = "role")
        private String role;

        @JSONField(name = "title")
        private String title;
    }
}

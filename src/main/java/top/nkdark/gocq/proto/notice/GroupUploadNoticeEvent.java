package top.nkdark.gocq.proto.notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 群文件上传事件
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupUploadNoticeEvent extends NoticeEvent {
    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 文件信息
     */
    @JSONField(name = "file")
    private File file;

    /**
     * 文件实体
     */
    @Data
    public static class File {

        /**
         * 文件 ID
         */
        @JSONField(name = "id")
        private String id;

        /**
         * 文件名
         */
        @JSONField(name = "name")
        private String name;

        /**
         * 文件大小
         */
        @JSONField(name = "size")
        private Long size;

        /**
         * busid ( 目前不清楚有什么作用 )
         */
        @JSONField(name = "busid")
        private Long busid;
    }
}

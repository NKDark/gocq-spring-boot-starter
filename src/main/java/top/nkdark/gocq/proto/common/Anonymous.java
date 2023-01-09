package top.nkdark.gocq.proto.common;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Anonymous {

    @JSONField(name = "id")
    private Long id;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "flag")
    private String flag;
}

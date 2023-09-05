package cn.oo.demo.mapstruct.model.domain.multisource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    /** 姓名 */
    private String name;

    /** 描述 */
    private String description;
}

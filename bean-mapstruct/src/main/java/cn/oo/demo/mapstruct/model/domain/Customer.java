package cn.oo.demo.mapstruct.model.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    /** 客户id */
    private Long id;

    /** 客户姓名 */
    private String name;
}

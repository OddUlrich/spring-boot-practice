package cn.oo.demo.orika.model;

import lombok.Data;

@Data
public class MemberInfoVO {

    private Long id;

    private String name;
    private Integer age;
    private String email;

    private String identity;
    private String group;

}

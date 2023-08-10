package cn.oo.demo.orika.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Data
@FieldNameConstants
public class PersonSrcInfo {

    private Long id;

    private String name;
    private Integer age;
    private LocalDate birth;
    private String email;

    private String removeVal;
}

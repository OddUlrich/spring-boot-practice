package cn.oo.demo.orika.model;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Data
@FieldNameConstants
public class PersonDesInfo {
    private Long id;

    private String personName;
    private Integer age;
    private LocalDate dateOfBirth;
    private String emailAddress;

    private String removeVal;
}

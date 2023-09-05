package cn.oo.demo.mapstruct.model.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {

    /** 姓名 */
    private String name;

    /** 性别 */
    private String gender;
}

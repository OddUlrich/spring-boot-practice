package cn.oo.demo.mapstruct.model.domain.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    /** 姓名 */
    private String name;

}

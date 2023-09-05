package cn.oo.demo.mapstruct.model.domain.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Engine {

    /** 马力 */
    private String horsePower;

    /** 燃油体积 */
    private Double fuel;

}

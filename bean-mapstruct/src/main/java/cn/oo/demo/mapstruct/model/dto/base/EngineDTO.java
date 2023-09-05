package cn.oo.demo.mapstruct.model.dto.base;

import lombok.Builder;
import lombok.Data;

@Data
public class EngineDTO {

    /** 马力 */
    private String horsePower;

    /** 燃油体积 */
    private Double fuel;

}

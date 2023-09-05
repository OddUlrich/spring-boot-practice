package cn.oo.demo.mapstruct.model.dto.multisource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryAddressDTO {

    /** 房间号 */
    private String houseNumber;

    /** 描述 */
    private String description;
}

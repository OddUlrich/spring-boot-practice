package cn.oo.demo.mapstruct.model.domain.multisource;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    /** 房间号 */
    private String houseNo;
}

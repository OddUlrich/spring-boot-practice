package cn.oo.demo.mapstruct.model.dto.base;

import lombok.Data;

import java.util.List;

@Data
public class CarDTO {

    /** 制造商 */
    private String manufacturer;

    /** 座椅数量 */
    private Integer seatCount;

    /** 司机 */
    private DriverDTO driver;

    /** 乘客 */
    private PassengerDTO passenger;

    /** 价格 */
    private Integer price;

    /** 种类 */
    private String category;

    /** 引擎 */
    private EngineDTO engine;

    /** 特点 */
    private List<String> features;
}

package cn.oo.demo.mapstruct.model.domain.base;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Car {

    /** 制造商 */
    private String make;

    /** 座椅数量 */
    private Integer numberOfSeats;

    /** 司机 */
    private Driver driver;

    /** 乘客 */
    private Passenger passenger;

    /** 价格 */
    private Integer price;

    /** 种类 */
    private String category;

    /** 引擎 */
    private Engine engine;

    /** 特点 */
    private List<String> features;
}

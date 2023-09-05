package cn.oo.demo.mapstruct.model.struct;

import cn.oo.demo.mapstruct.model.domain.base.Car;
import cn.oo.demo.mapstruct.model.domain.base.Driver;
import cn.oo.demo.mapstruct.model.domain.base.Passenger;
import cn.oo.demo.mapstruct.model.dto.base.CarDTO;
import cn.oo.demo.mapstruct.model.dto.base.DriverDTO;
import cn.oo.demo.mapstruct.model.dto.base.PassengerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * 基础映射，可指定不同字段名的映射，以及自定义个别字段特殊的映射逻辑
 */
@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "manufacturer", source = "make")
    @Mapping(target = "seatCount", source = "numberOfSeats")
    CarDTO carToCarDTO(Car car);

    @Mapping(target = "fullName", source = "name")
    DriverDTO driverToDriverDTO(Driver driver);


    /**
     * 定制特殊逻辑映射的default方法，MapStruct在生成实现代码时会根据参数与返回类型进行匹配
     *
     * @param passenger 乘客实例
     * @return 乘客实例DTO
     */
    default PassengerDTO passengerTOPassengerDTO(Passenger passenger) {
        if (passenger == null) {
            return null;
        }

        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setName(passenger.getName());
        if (Integer.valueOf(0).equals(passenger.getGender())){
            passengerDTO.setGender("male");
        } else if (Integer.valueOf(1).equals(passenger.getGender())){
            passengerDTO.setGender("female");
        } else {
            passengerDTO.setGender("unknown");
        }

        return passengerDTO;
    }

    /**
     * 更新已实例化实体的成员变量，接收赋值的实例对象由注解 {@link MappingTarget} 指定
     *
     * @param carDTO
     * @param car
     */
    void updateCarFromCarDTO(CarDTO carDTO, @MappingTarget Car car);
}

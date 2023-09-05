package cn.oo.demo.mapstruct;

import cn.oo.demo.mapstruct.model.domain.base.Car;
import cn.oo.demo.mapstruct.model.domain.base.Driver;
import cn.oo.demo.mapstruct.model.domain.base.Engine;
import cn.oo.demo.mapstruct.model.domain.base.Passenger;
import cn.oo.demo.mapstruct.model.dto.base.CarDTO;
import cn.oo.demo.mapstruct.model.dto.base.DriverDTO;
import cn.oo.demo.mapstruct.model.dto.base.EngineDTO;
import cn.oo.demo.mapstruct.model.dto.base.PassengerDTO;
import cn.oo.demo.mapstruct.model.struct.CarMapper;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class BaseMappingTest {

    @Test
    void testCarMapping() {
        Car car = initCar();
        CarDTO carDTO = CarMapper.INSTANCE.carToCarDTO(car);
        assertCar2CarDTO(car, carDTO);
    }

    private Car initCar() {
        return Car.builder()
                .make("BYD")
                .numberOfSeats(7)
                .driver(Driver.builder().name("John").build())
                .passenger(Passenger.builder().name("Maggie").gender(1).build())
                .price(200000)
                .category("Ford")
                .engine(Engine.builder().horsePower("800cc").fuel(200.0).build())
                .features(Arrays.asList("spacial", "discount"))
                .build();
    }

    private void assertCar2CarDTO(Car car, CarDTO carDTO) {
        assertEquals(car.getMake(), carDTO.getManufacturer());
        assertEquals(car.getNumberOfSeats(), carDTO.getSeatCount());
        assertEquals(car.getPrice(), carDTO.getPrice());
        assertEquals(car.getCategory(), carDTO.getCategory());

        assertDriver2DriverDTO(car.getDriver(), carDTO.getDriver());
        assertPassenger2PassengerDTO(car.getPassenger(), carDTO.getPassenger());
        assertEngine2EngineDTO(car.getEngine(), carDTO.getEngine());

        assertEquals(car.getFeatures().size(), carDTO.getFeatures().size());
        assertEquals(car.getFeatures().get(0), carDTO.getFeatures().get(0));
        assertEquals(car.getFeatures().get(1), carDTO.getFeatures().get(1));

    }

    private void assertDriver2DriverDTO(Driver driver, DriverDTO driverDTO) {
        assertEquals(driver.getName(), driverDTO.getFullName());
    }
    private void assertPassenger2PassengerDTO(Passenger passenger, PassengerDTO passengerDTO) {
        assertEquals(passenger.getName(), passengerDTO.getName());
        assertEquals(passenger.getGender().intValue(), 1);
        assertEquals("female", passengerDTO.getGender());
    }

    private void assertEngine2EngineDTO(Engine engine, EngineDTO engineDTO) {
        assertEquals(engine.getFuel(), engineDTO.getFuel());
        assertEquals(engine.getHorsePower(), engineDTO.getHorsePower());
    }

}
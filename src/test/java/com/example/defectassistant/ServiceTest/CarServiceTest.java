package com.example.defectassistant.ServiceTest;

import com.example.defectassistant.pojo.Car;
import com.example.defectassistant.pojo.HealthSituation;
import com.example.defectassistant.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class CarServiceTest {

    @Resource
    CarService carService;

    @Test
    public void testFind(){
        System.out.println(carService.findByCarId(1));
    }

    @Test
    public void testCheckHealthSituation(){
        Car car = new Car();
        car.setId(1);
        car.setUserId(1);
        car.setWheelPressure(2.1f);
        car.setEngineTemperature(85);
        car.setRefrigerantTTemperature(90);
        car.setAirBagPressure(0);
        car.setWheelRev(750);
        car.setTensorReponse(true);
        HealthSituation healthSituation = carService.checkHealthSituation(car);
        System.out.println(healthSituation);
    }
}

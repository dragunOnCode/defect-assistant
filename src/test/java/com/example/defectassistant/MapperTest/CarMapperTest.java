package com.example.defectassistant.MapperTest;

import com.example.defectassistant.mapper.CarMapper;
import com.example.defectassistant.pojo.Car;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class CarMapperTest {

    @Resource
    private CarMapper carMapper;

    @Test
    public void testSelect(){
        Car car = carMapper.selectByCarId(1);
        System.out.println(car);
    }

    @Test
    public void testInsert(){
        Car car = new Car();
        car.setUserId(2);
        car.setWheelPressure(2.3f);
        car.setEngineTemperature(80);
        car.setRefrigerantTTemperature(85);
        car.setAirBagPressure(0);
        car.setWheelRev(700);
        car.setTensorReponse(true);
        System.out.println(carMapper.insert(car));
    }

    @Test
    public void testUpdate(){
        Car car = new Car();
        car.setId(2);
        car.setUserId(2);
        car.setWheelPressure(2.5f);
        car.setEngineTemperature(80);
        car.setRefrigerantTTemperature(85);
        car.setAirBagPressure(0);
        car.setWheelRev(700);
        car.setTensorReponse(true);
        System.out.println(carMapper.update(car));
    }
}

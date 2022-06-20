package com.example.defectassistant.controller;

import com.example.defectassistant.pojo.Car;
import com.example.defectassistant.pojo.component.Result;
import com.example.defectassistant.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/car")
public class CarController {

    @Resource
    CarService carService;

    @GetMapping("/check/{carId}")
    public Result check(@PathVariable int carId){
        Car car = carService.findByCarId(carId);
        if(car == null){
            return Result.BAD().build();
        }else{
            return Result.OK().data(car).build();
        }
    }
}

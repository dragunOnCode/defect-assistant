package com.example.defectassistant.service.impl;

import com.example.defectassistant.mapper.CarMapper;
import com.example.defectassistant.pojo.Car;
import com.example.defectassistant.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CarServiceImpl implements CarService{

    @Resource
    CarMapper carMapper;


    @Override
    public Car findByCarId(int carId) {
        return carMapper.selectByCarId(carId);
    }

    @Override
    public int insert(Car car) {
        return carMapper.insert(car);
    }

    @Override
    public int update(Car car) {
        return carMapper.update(car);
    }
}

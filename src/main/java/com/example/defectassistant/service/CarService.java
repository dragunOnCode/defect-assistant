package com.example.defectassistant.service;

import com.example.defectassistant.pojo.Car;

public interface CarService {

    Car findByCarId(int carId);

    int insert(Car car);

    int update(Car car);
}

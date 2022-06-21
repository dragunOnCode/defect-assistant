package com.example.defectassistant.service;

import com.example.defectassistant.pojo.Car;
import com.example.defectassistant.pojo.HealthSituation;

public interface CarService {

    Car findByCarId(int carId);

    int insert(Car car);

    int update(Car car);

    HealthSituation checkHealthSituation(Car car);

    int checkWheelPressure(Car car);

    int checkEngineTemperature(Car car);

    int checkRefrigerantTTemperature(Car car);

    int checkAirBagPressure(Car car);

    int checkWheelRev(Car car);

    int checkTensorReponse(Car car);
}

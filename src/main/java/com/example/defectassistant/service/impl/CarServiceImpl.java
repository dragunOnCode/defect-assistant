package com.example.defectassistant.service.impl;

import com.example.defectassistant.mapper.CarMapper;
import com.example.defectassistant.mapper.DefectMapper;
import com.example.defectassistant.mapper.ExceptionMapper;
import com.example.defectassistant.pojo.Car;
import com.example.defectassistant.pojo.Defect;
import com.example.defectassistant.pojo.Exception;
import com.example.defectassistant.pojo.HealthSituation;
import com.example.defectassistant.service.CarService;
import com.example.defectassistant.service.ExceptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService{

    @Resource
    CarMapper carMapper;

    @Resource
    DefectMapper defectMapper;

    @Resource
    ExceptionMapper exceptionMapper;

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

    @Override
    //0健康，1异常，2严重
    public HealthSituation checkHealthSituation(Car car) {
        HealthSituation healthSituation = new HealthSituation(0, new HashSet<Exception>());
        update(car);
        int i1 = checkWheelPressure(car);
        int i2 = checkEngineTemperature(car);
        int i3 = checkRefrigerantTTemperature(car);
        int i4 = checkAirBagPressure(car);
        int i5 = checkWheelRev(car);
        int i6 = checkTensorReponse(car);
        if(i1 == 0 && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0){
            healthSituation.setCode(0);
        }else if(i1 == 2 || i2 == 2 || i3 == 2 || i4 == 2 || i5 == 2 || i6 == 2){
            healthSituation.setCode(2);
        }else{
            healthSituation.setCode(1);
        }
        List<Integer> exceptionIds = defectMapper.selectByCarId(car.getId());
        for(Integer exceptionid : exceptionIds){
            healthSituation.getExceptions().add(exceptionMapper.selectById(exceptionid));
        }
        return healthSituation;
    }

    @Override
    //2.3-2.5正常——返回0
    //2.0-2.3或2.5-2.8偏低/偏高——返回1
    //低于2.0或高于2.8严重故障——返回2
    public int checkWheelPressure(Car car) {
        float wheelPressure = car.getWheelPressure();
        Defect defect = new Defect();
        defect.setCarId(car.getId());
        if(wheelPressure >= 2.3 && wheelPressure <= 2.5){
            return 0;
        }else if(wheelPressure < 2.3 && wheelPressure >= 2.0){
            defect.setExceptionId(1);
            defectMapper.insert(defect);
            //healthSituation.getExceptions().add(exceptionMapper.selectById(1));
            //healthSituation.setCode(healthSituation.getCode() < 1 ? 1 : 0);
            return 1;
        }else if (wheelPressure > 2.5 && wheelPressure <=2.8){
            defect.setExceptionId(2);
            defectMapper.insert(defect);
            //healthSituation.getExceptions().add(exceptionMapper.selectById(2));
            return 1;
        } else{
            defect.setExceptionId(3);
            defectMapper.insert(defect);
            //healthSituation.getExceptions().add(exceptionMapper.selectById(3));
            return 2;
        }
    }

    @Override
    //80-90正常——返回0
    //70-80或90-95偏低/偏高——返回1
    //低于70或高于95严重故障——返回2
    public int checkEngineTemperature(Car car) {
        float engineTemperature = car.getEngineTemperature();
        Defect defect = new Defect();
        defect.setCarId(car.getId());
        if(engineTemperature >= 80 && engineTemperature <= 90){
            return 0;
        }else if(engineTemperature >= 70 && engineTemperature < 80){
            defect.setExceptionId(4);
            defectMapper.insert(defect);
            return 1;
        }else if(engineTemperature > 90 && engineTemperature <= 95){
            defect.setExceptionId(14);
            defectMapper.insert(defect);
            return 1;
        }else{
            defect.setExceptionId(6);
            defectMapper.insert(defect);
            return 2;
        }
    }

    @Override
    //85-95正常——返回0
    //75-85偏低——返回1
    //低于75或高于95严重故障——返回2
    public int checkRefrigerantTTemperature(Car car) {
        float refrigerantTTemperature = car.getRefrigerantTTemperature();
        Defect defect = new Defect();
        defect.setCarId(car.getId());
        if(refrigerantTTemperature >= 85 && refrigerantTTemperature <= 95){
            return 0;
        }else if(refrigerantTTemperature >= 75 && refrigerantTTemperature < 85){
            defect.setExceptionId(7);
            defectMapper.insert(defect);
            return 1;
        }else{
            defect.setExceptionId(8);
            defectMapper.insert(defect);
            return 2;
        }
    }

    @Override
    //0正常——返回0
    //大于0异常——返回2
    public int checkAirBagPressure(Car car) {
        float airBagPressure = car.getAirBagPressure();
        Defect defect = new Defect();
        defect.setCarId(car.getId());
        if(airBagPressure == 0){
            return 0;
        }else{
            defect.setExceptionId(9);
            defectMapper.insert(defect);
            return 2;
        }
    }

    @Override
    //700-800正常——返回0
    //650-700或800-850偏低/偏高——返回1
    //低于650或高于850严重故障——返回2
    public int checkWheelRev(Car car) {
        float wheelRev = car.getWheelRev();
        Defect defect = new Defect();
        defect.setCarId(car.getId());
        if(wheelRev >= 700 && wheelRev <= 800){
            return 0;
        }else if(wheelRev >= 650 && wheelRev <= 700){
            defect.setExceptionId(10);
            defectMapper.insert(defect);
            return 1;
        }else if(wheelRev > 800 && wheelRev <= 850){
            defect.setExceptionId(11);
            defectMapper.insert(defect);
            return 1;
        }else{
            defect.setExceptionId(12);
            defectMapper.insert(defect);
            return 2;
        }
    }

    @Override
    //false不响应
    //true响应
    public int checkTensorReponse(Car car) {
        Boolean tensorReponse = car.getTensorReponse();
        Defect defect = new Defect();
        defect.setCarId(car.getId());
        if(tensorReponse){
            return 0;
        }else{
            defect.setExceptionId(13);
            defectMapper.insert(defect);
            return 1;
        }
    }
}

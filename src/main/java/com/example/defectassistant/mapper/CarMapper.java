package com.example.defectassistant.mapper;

import com.example.defectassistant.pojo.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CarMapper {

    @Select("select * from car where id = #{carId}")
    Car selectByCarId(int carId);

    @Insert("insert into car " +
            "(userId, wheelPressure, engineTemperature, refrigerantTTemperature, airBagPressure, wheelRev, tensorReponse) values" +
            "(#{userId}, #{wheelPressure}, #{engineTemperature}, #{refrigerantTTemperature}, #{airBagPressure}, #{wheelRev}, #{tensorReponse})")
    int insert(Car car);

    @Update("update car set " +
            "userId = #{userId}, wheelPressure = #{wheelPressure}, engineTemperature = #{engineTemperature}, " +
            "refrigerantTTemperature = #{refrigerantTTemperature}, airBagPressure = #{airBagPressure}, " +
            "wheelRev = #{wheelRev}, tensorReponse = #{tensorReponse} where carId = #{carId}")
    int update(Car car);
}

package com.example.defectassistant.mapper;

import com.example.defectassistant.pojo.Defect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DefectMapper {

    @Insert("insert into defect(carId, exceptionId) values (#{carId}, #{exceptionId})")
    int insert(Defect defect);

//    @Results({
//            @Result(id = true,property = "id", column = "id"),
//            @Result(column = "carId", property = "carId"),
//            @Result(column = "exceptionId", property = "exceptionId")
//    })
    @Select("select exceptionId from defect where carId = #{carId}")
    List<Integer> selectByCarId(int carId);

    @Delete("delete from defect where carId = #{carId} limit 300")
    int deleteByCarId(int carId);

    @Select("select count(*) from defect where carId = #{carId}")
    int countByCarId(int carId);

}

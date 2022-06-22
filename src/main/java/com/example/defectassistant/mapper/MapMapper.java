package com.example.defectassistant.mapper;

import com.example.defectassistant.pojo.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MapMapper {

    @Select("select * from map")
    List<Map> selectAll();

}

package com.example.defectassistant.mapper;

import com.example.defectassistant.pojo.Maintenance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MaintenanceMapper {

    @Select("select * from maintenance")
    List<Maintenance> selectAll();

}

package com.example.defectassistant.mapper;

import com.example.defectassistant.pojo.Exception;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface ExceptionMapper {

    @Select("select * from exception where id = #{id}")
    Exception selectById(int id);

}

package com.example.defectassistant.mapper;

import com.example.defectassistant.pojo.Solution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SolutionMapper {

    @Select("select * from solution where exceptionId = #{exceptionId}")
    Solution selectByExceptionId(int exceptionId);

}

package com.example.defectassistant.MapperTest;

import com.example.defectassistant.mapper.DefectMapper;
import com.example.defectassistant.mapper.SolutionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SolutionMapperTest {

    @Resource
    SolutionMapper solutionMapper;

    @Resource
    DefectMapper defectMapper;

    @Test
    public void testSelect(){
        System.out.println(solutionMapper.selectByExceptionId(1));
        System.out.println(solutionMapper.selectByExceptionId(2));
    }

    @Test
    public void testSelect2(){
        List<Integer> exceptionIds = defectMapper.selectByCarId(2);
        for(Integer i: exceptionIds){
            System.out.println(solutionMapper.selectByExceptionId(i));
        }
    }

}

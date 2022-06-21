package com.example.defectassistant.MapperTest;

import com.example.defectassistant.mapper.DefectMapper;
import com.example.defectassistant.mapper.ExceptionMapper;
import com.example.defectassistant.pojo.Defect;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class DefectMapperTest {

    @Resource
    DefectMapper defectMapper;

    @Resource
    ExceptionMapper exceptionMapper;

    @Test
    public void testSelect(){
        System.out.println(defectMapper.selectByCarId(2));
    }

    @Test
    public void testSelect2(){
        List<Integer> exceptionIds = defectMapper.selectByCarId(2);
        for(Integer i: exceptionIds){
            System.out.println(exceptionMapper.selectById(i));
        }
    }

    @Test
    public void testInsert(){
        Defect defect = new Defect();
        defect.setCarId(1);
        defect.setExceptionId(3);
        defectMapper.insert(defect);
    }
}

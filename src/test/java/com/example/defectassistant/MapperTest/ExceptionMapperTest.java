package com.example.defectassistant.MapperTest;

import com.example.defectassistant.mapper.ExceptionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ExceptionMapperTest {

    @Resource
    ExceptionMapper exceptionMapper;

    @Test
    public void testSelect(){
        System.out.println(exceptionMapper.selectById(1));
        System.out.println(exceptionMapper.selectById(2));
    }

}

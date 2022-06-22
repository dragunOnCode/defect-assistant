package com.example.defectassistant.MapperTest;

import com.example.defectassistant.mapper.MapMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MapMapperTest {

    @Resource
    MapMapper mapMapper;

    @Test
    public void testSelectAll(){
        System.out.println(mapMapper.selectAll());
    }
}

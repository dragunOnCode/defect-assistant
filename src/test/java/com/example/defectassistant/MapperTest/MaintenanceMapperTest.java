package com.example.defectassistant.MapperTest;

import com.example.defectassistant.mapper.MaintenanceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class MaintenanceMapperTest {

    @Resource
    MaintenanceMapper maintenanceMapper;

    @Test
    public void testSelectAll(){
        System.out.println(maintenanceMapper.selectAll());
    }

}

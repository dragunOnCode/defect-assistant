package com.example.defectassistant.service.impl;

import com.example.defectassistant.mapper.MapMapper;
import com.example.defectassistant.pojo.Map;
import com.example.defectassistant.service.MapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MapServiceImpl implements MapService{

    @Resource
    MapMapper mapMapper;

    @Override
    public List<Map> findAllStore() {
        return mapMapper.selectAll();
    }
}

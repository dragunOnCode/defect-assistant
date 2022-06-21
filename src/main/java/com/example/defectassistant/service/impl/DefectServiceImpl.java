package com.example.defectassistant.service.impl;

import com.example.defectassistant.mapper.DefectMapper;
import com.example.defectassistant.pojo.Defect;
import com.example.defectassistant.service.DefectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefectServiceImpl implements DefectService {

    @Resource
    DefectMapper defectMapper;

    @Override
    public int insert(Defect defect) {
        return defectMapper.insert(defect);
    }

    @Override
    public List<Integer> findbyCarId(int carId) {
        return defectMapper.selectByCarId(carId);
    }

    @Override
    public int deleteByCarId(int carId) {
        return defectMapper.deleteByCarId(carId);
    }

    @Override
    public int countByCarId(int carId) {
        return defectMapper.countByCarId(carId);
    }
}

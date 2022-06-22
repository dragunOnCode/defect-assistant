package com.example.defectassistant.service.impl;

import com.example.defectassistant.mapper.MaintenanceMapper;
import com.example.defectassistant.pojo.Maintenance;
import com.example.defectassistant.service.MaintenanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService{

    @Resource
    MaintenanceMapper maintenanceMapper;

    @Override
    public List<Maintenance> findAllMaintenancer() {
        return maintenanceMapper.selectAll();
    }
}

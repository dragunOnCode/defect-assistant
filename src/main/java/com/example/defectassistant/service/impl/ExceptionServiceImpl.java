package com.example.defectassistant.service.impl;

import com.example.defectassistant.mapper.ExceptionMapper;
import com.example.defectassistant.pojo.Exception;
import com.example.defectassistant.service.ExceptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExceptionServiceImpl implements ExceptionService{

    @Resource
    ExceptionMapper exceptionMapper;

    @Override
    public Exception findById(int id) {
        return exceptionMapper.selectById(id);
    }
}

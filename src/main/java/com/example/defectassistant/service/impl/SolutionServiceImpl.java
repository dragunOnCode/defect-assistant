package com.example.defectassistant.service.impl;

import com.example.defectassistant.mapper.SolutionMapper;
import com.example.defectassistant.pojo.Solution;
import com.example.defectassistant.service.SolutionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SolutionServiceImpl implements SolutionService{

    @Resource
    SolutionMapper solutionMapper;

    @Override
    public Solution findByExceptionId(int exceptionId) {
        return solutionMapper.selectByExceptionId(exceptionId);
    }
}

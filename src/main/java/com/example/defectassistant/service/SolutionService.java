package com.example.defectassistant.service;

import com.example.defectassistant.pojo.Solution;

public interface SolutionService {

    Solution findByExceptionId(int exceptionId);

}

package com.example.defectassistant.service;

import com.example.defectassistant.pojo.Defect;

import java.util.List;

public interface DefectService {

    int insert(Defect defect);

    List<Integer> findbyCarId(int carId);

}

package com.example.defectassistant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Defect {

    private int id;

    private int carId;

    private int exceptionId;

}

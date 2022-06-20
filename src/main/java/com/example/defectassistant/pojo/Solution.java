package com.example.defectassistant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {

    private int id;

    private int exceptionId;

    private String desc;

}

package com.example.defectassistant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    private int id;

    private String name;

    private String phoneNumber;

    private double star;

    private String desc;
}

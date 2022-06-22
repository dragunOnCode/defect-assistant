package com.example.defectassistant.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Map {

    private int id;

    private String name;

    private String address;

    private double longitude;

    private double latitude;

}

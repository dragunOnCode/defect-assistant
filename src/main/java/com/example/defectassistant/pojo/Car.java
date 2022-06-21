package com.example.defectassistant.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NonNull
public class Car {

    private int id;

    private int userId;

    private float wheelPressure;

    private float engineTemperature;

    private float refrigerantTTemperature;

    private float airBagPressure;

    private float wheelRev;

    private Boolean tensorReponse = true;

}

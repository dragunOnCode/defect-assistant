package com.example.defectassistant.controller;

import com.example.defectassistant.pojo.component.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/defect")
public class DefectController {

    @GetMapping("/notoken")
    public Result hello1(){
        return Result.OK().msg("No Token Get it").build();
    }

    @GetMapping("/token")
    public Result hello2(){
        return Result.OK().msg("Token Get it").build();
    }

}

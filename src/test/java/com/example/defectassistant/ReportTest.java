package com.example.defectassistant;

import com.example.defectassistant.pojo.Exception;
import com.example.defectassistant.pojo.component.Result;
import com.example.defectassistant.service.DefectService;
import com.example.defectassistant.service.ExceptionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ReportTest {

    @Resource
    DefectService defectService;

    @Resource
    ExceptionService exceptionService;

    @Test
    public void testReport(){
        System.out.println(getDefect(2));
//        List<Integer> exceptionIds = defectService.findbyCarId(2);
//        List<Exception> exceptions = new ArrayList<>();
//        for(Integer id : exceptionIds){
//            Exception exception = exceptionService.findById(id);
//            exceptions.add(exception);
//        }
//        for(Exception e : exceptions){
//            System.out.println(e);
//        }
    }

    public Result getDefect(int carId){
        List<Integer> exceptionIds = defectService.findbyCarId(carId);
        if(exceptionIds == null){
            return Result.OK().msg("No exceptions").build();
        }else{
            List<Exception> exceptions = new ArrayList<>();
            for(Integer id : exceptionIds){
                Exception exception = exceptionService.findById(id);
                exceptions.add(exception);
            }
            return Result.OK().msg("Here are exceptions").data(exceptions).build();
        }
    }
}

package com.example.defectassistant.controller;

import com.example.defectassistant.pojo.*;
import com.example.defectassistant.pojo.Exception;
import com.example.defectassistant.pojo.component.Result;
import com.example.defectassistant.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/defect")
public class DefectController {

    @Resource
    DefectService defectService;

    @Resource
    ExceptionService exceptionService;

    @Resource
    SolutionService solutionService;

    @Resource
    CarService carService;

    @Resource
    MapService mapService;

    @Resource
    MaintenanceService maintenanceService;

    @GetMapping("/notoken")
    public Result hello1(){
        return Result.OK().msg("No Token Get it").build();
    }

    @GetMapping("/token")
    public Result hello2(){
        return Result.OK().msg("Token Get it").build();
    }

    @GetMapping("/report/{carId}")
    public Result getDefect(@PathVariable int carId){
        List<Integer> exceptionIds = defectService.findbyCarId(carId);
        if(exceptionIds == null){
            return Result.OK().msg("No exceptions").build();
        }else{
            Set<Exception> exceptions = new HashSet<Exception>();
            for(Integer id : exceptionIds){
                //Exception exception = exceptionService.findById(id);
                exceptions.add(exceptionService.findById(id));
            }
            return Result.OK().msg("Here are exceptions").data(exceptions).build();
        }
    }

    @GetMapping("/handle/{carId}/{exceptionId}/{handleId}")
    public Result getHandle(@PathVariable int carId, @PathVariable int exceptionId, @PathVariable int handleId){
        switch (handleId){
            //获取自救方案
            case 1:
                return Result.OK().data("进行自救").build();
            //获取保险流程
            case 2:
                return Result.OK().data("保险流程").build();
            //前往维修厂
            case 3:
                List<Map> maps = mapService.findAllStore();
                return Result.OK().data("前往维修厂").data(maps).build();
            //预约上门
            case 4:
                List<Maintenance> maintenances = maintenanceService.findAllMaintenancer();
                return Result.OK().data("预约上门").data(maintenances).build();
            //自行解决
            default:
                //获取具体某一故障的解决方法
                if(exceptionId != 0){
                    List<Solution> solutions = new ArrayList<>();
                    Solution solution = solutionService.findByExceptionId(exceptionId);
                    solutions.add(solution);
                    return Result.OK().data(solutions).build();
                }else{
                    //获取所有故障的解决方法
                    List<Integer> exceptionIds = defectService.findbyCarId(carId);
                    if(exceptionIds == null){
                        return Result.OK().msg("No exception no solution").build();
                    }else{
                        Set<Solution> solutions = new HashSet<Solution>();
                        for(Integer id : exceptionIds){
//                            Solution solution = solutionService.findByExceptionId(id);
//                            solutions.add(solution);
                            solutions.add(solutionService.findByExceptionId(id));
                        }
                        return Result.OK().msg("Here are Solutions").data(solutions).build();
                    }
                }
        }
    }

    @PostMapping("/upload")
    public Result upload(@RequestBody Car car){
        if(defectService.countByCarId(car.getId()) > 300){
            defectService.deleteByCarId(car.getId());
        }
        HealthSituation healthSituation = carService.checkHealthSituation(car);
        return Result.OK().msg("故障情况如下").data(healthSituation).build();
    }

}

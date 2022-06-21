package com.example.defectassistant;

import com.example.defectassistant.pojo.Solution;
import com.example.defectassistant.pojo.component.Result;
import com.example.defectassistant.service.DefectService;
import com.example.defectassistant.service.SolutionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HandleTest {

    @Resource
    SolutionService solutionService;

    @Resource
    DefectService defectService;

    @Test
    public void testHandle(){
        System.out.println(testSelfHandle(2, 1, 5));
    }

    public Result testSelfHandle(int carId, int exceptionId, int handleId){
        switch (handleId){
            //获取自救方案
            case 1:
                return null;
            //获取保险流程
            case 2:
                return null;
            //前往维修厂
            case 3:
                return null;
            //预约上门
            case 4:
                return null;
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
                        List<Solution> solutions = new ArrayList<>();
                        for(Integer id : exceptionIds){
                            Solution solution = solutionService.findByExceptionId(id);
                            solutions.add(solution);
                        }
                        return Result.OK().msg("Here are Solutions").data(solutions).build();
                    }
                }
        }
    }

}

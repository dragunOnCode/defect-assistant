package com.example.defectassistant.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.example.defectassistant.pojo.User;
import com.example.defectassistant.pojo.component.Result;
import com.example.defectassistant.pojo.vo.LoginVO;
import com.example.defectassistant.service.AuthService;
import com.example.defectassistant.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Resource
    private AuthService authService;

    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    public Result login(@RequestBody LoginVO loginVO) {
        //System.out.println("-----LOGIN-----");
        SaTokenInfo saTokenInfo = authService.login(loginVO.getUsername(), loginVO.getPassword());
        if (saTokenInfo == null) {
            return Result.BAD().msg("用户名或密码错误").build();
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", saTokenInfo.getTokenValue());
        tokenMap.put("tokenHead", saTokenInfo.getTokenName());
        return Result.OK().data(tokenMap).build();
    }

    @PostMapping(value = "/register")
    public Result register(@RequestBody User user) {
        try {
            String hashed = BCrypt.hashpw("123456", BCrypt.gensalt());
            System.out.println(hashed);
            user.setPassword(hashed);
            userService.insertUser(user);

            return Result.OK().msg("Register Done").build();
        }catch (Exception e){
            Throwable cause = e.getCause();
            if (cause instanceof SQLIntegrityConstraintViolationException){
                String errMsg = (cause).getMessage();
                return Result.BAD().msg("账号已存在").build();
            }
            return Result.BAD().msg("创建失败").build();
        }

    }
}

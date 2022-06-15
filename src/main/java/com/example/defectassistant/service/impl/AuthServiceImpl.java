package com.example.defectassistant.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.example.defectassistant.mapper.UserMapper;
import com.example.defectassistant.pojo.dto.UserDTO;
import com.example.defectassistant.service.AuthService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserMapper userMapper;

    // 原本是写死在内存的方式
    // 现在改成从数据库查找user
    public UserDTO loadUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public SaTokenInfo login(String username, String password) {
        UserDTO user = loadUserByUsername(username);
        if (user == null) {
            return null;
        }

        if (BCrypt.checkpw(password, user.getPassword())) {
            return null;
        }

        String role = userMapper.selectUserRoleById(user.getId());
        user.setRole(role);

        // 密码校验成功后登录，一行代码实现登录
        StpUtil.login(user.getId());
        // 将用户信息存储到Session中
        StpUtil.getSession().set("userInfo",user);
        // 获取当前登录用户Token信息
        SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
        return saTokenInfo;
    }
}

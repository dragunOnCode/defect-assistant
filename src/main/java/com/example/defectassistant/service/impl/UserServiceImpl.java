package com.example.defectassistant.service.impl;

import com.example.defectassistant.mapper.UserMapper;
import com.example.defectassistant.pojo.User;
import com.example.defectassistant.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User selectUser(Integer id) {
        return userMapper.selectUser(id);
    }

    @Override
    public int updatePassword(User user) {
        return userMapper.updateUserWithPassword(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int assignRoleToUser(Integer uid, Integer rid) {
        return userMapper.insertUserRole(uid, rid);
    }

    @Override
    public int updateRoleToUser(Integer uid, Integer rid) {
        return userMapper.updateUserRole(uid, rid);
    }
}

package com.example.defectassistant.service;

import com.example.defectassistant.pojo.User;

public interface UserService {
    int insertUser(User user);

    User selectUser(Integer id);

    int updatePassword(User user);

    int deleteUser(Integer id);

    int assignRoleToUser(Integer uid, Integer rid);

    int updateRoleToUser(Integer uid, Integer rid);
}
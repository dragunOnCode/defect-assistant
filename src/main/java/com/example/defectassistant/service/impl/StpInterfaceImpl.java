package com.example.defectassistant.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.example.defectassistant.pojo.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Override
    public List<String> getPermissionList(Object o, String s) {
        UserDTO user = (UserDTO) StpUtil.getSession().get("userInfo");
        return user.getPermissionList();
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        UserDTO user = (UserDTO) StpUtil.getSession().get("userInfo");
        List<String> roles = new ArrayList<>();
        roles.add(user.getRole());
        return roles;
    }
}
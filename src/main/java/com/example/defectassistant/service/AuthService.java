package com.example.defectassistant.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.example.defectassistant.pojo.dto.UserDTO;

public interface AuthService {

    SaTokenInfo login(String username, String password);

    UserDTO loadUserByUsername(String username);
}

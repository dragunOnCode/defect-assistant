package com.example.defectassistant.pojo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private int id;

    private String username;

    private String password;

    private String role;

    private int credit;

    private List<String> permissionList;

    public UserDTO(int id, String username, String password, int credit) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.credit = credit;
    }
}

package com.example.defectassistant.mapper;

import com.example.defectassistant.pojo.User;
import com.example.defectassistant.pojo.dto.UserDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    UserDTO selectByUsername(String username);

    @Select("SELECT role_name FROM role LEFT JOIN user_role ON role.id = user_role.rid WHERE uid = #{uid};")
    String selectUserRoleById(Integer uid);

    @Insert("insert into user (username, password, credit) values (#{username}, #{password}, #{credit})")
    int insertUser(User user);

    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "credit", property = "credit"),
    })
    @Select("select * from user where id = #{id}")
    User selectUser(Integer id);

    @Delete("delete from user where id = #{id}")
    int deleteUser(Integer id);

    @Update("update user set password = #{password} where id = #{id}")
    int updateUserWithPassword(User user);

    //@Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user_role (uid, rid) values (#{uid}, #{rid})")
    int insertUserRole(Integer uid, Integer rid);

    @Update("update user_role set rid = #{rid} where uid = #{uid}")
    int updateUserRole(Integer uid, Integer rid);
}

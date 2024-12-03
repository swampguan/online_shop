package com.guanze.mapper;

import com.guanze.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<user> selectByCondition(@Param("username") String username, @Param("password") String password);

    int add(user user_);

    user selectById(@Param("user_id")int id);

    List<user> selectAll();
}

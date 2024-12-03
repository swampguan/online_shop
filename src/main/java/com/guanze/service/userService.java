package com.guanze.service;

import com.guanze.mapper.UserMapper;
import com.guanze.pojo.user;
import com.guanze.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class userService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public user Register(String username,String password, String email)
    {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper usersMapper = sqlSession.getMapper(UserMapper.class);
        int id = 0;
        user users=new user();
        users.setUser_name(username);
        users.setPassword(password);
        users.setEmail(email);
        try {
            usersMapper.add(users);
            sqlSession.close();
            id= users.getUser_id();
            return users;
        }catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }



    }

    public  user login(String username, String password){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper usersMapper = sqlSession.getMapper(UserMapper.class);
        List<user> usersList= usersMapper.selectByCondition(username,password);
        sqlSession.close();

        if(usersList.isEmpty())
            return null;
        else return usersList.get(0);
    }
}

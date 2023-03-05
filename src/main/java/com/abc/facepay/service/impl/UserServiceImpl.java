package com.abc.facepay.service.impl;

import com.abc.facepay.constant.FlagConstant;
import com.abc.facepay.mapper.UserMapper;
import com.abc.facepay.pojo.User;
import com.abc.facepay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String add(User user) {
        try{
            userMapper.insertUser(user);
        }catch (Exception e){

            System.out.println(e.getMessage());
            return FlagConstant.FAIL_FLAG;
        }

        return FlagConstant.SUCCESS_FLAG;
    }

    @Override
    public List<User> findAllUser() {
        List<User> allUser = userMapper.findAllUser();

        return allUser;
    }

    @Override
    public int deleteByIds(String ids) {
        int res = userMapper.deleteByIds(ids);
        System.out.println("res========="+res);
        return res;
    }

    @Override
    public int updateUserById(User user) {
        int num = userMapper.updateUserById(user);
        return num;
    }

    @Override
    public User findById(String uid) {
        User user = userMapper.findById(uid);
        return user;
    }
}

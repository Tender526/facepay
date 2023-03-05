package com.abc.facepay.service;

import com.abc.facepay.pojo.User;

import java.util.List;

public interface UserService {

    String add(User user);

    List<User> findAllUser();

    int deleteByIds(String ids);

    int updateUserById(User user);

    User findById(String uid);
}

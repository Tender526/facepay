package com.abc.facepay.mapper;

import com.abc.facepay.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    /**
     * 新增用户
     * @param user
     */
    void insertUser(User user);

    List<User> findAllUser();

    int deleteByIds(String ids);

    int updateUserById(User user);

    User findById(String uid);
}

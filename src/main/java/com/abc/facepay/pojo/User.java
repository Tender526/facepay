package com.abc.facepay.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("tab_user")
public class User {
//    @TableId(type = IdType.INPUT)
    private String uid;
    private String username;
    private String password;
    private String telephone;
    private String nickname;
    private String sex;
    private Date birthday;
    private String email;
    private String pic;
    private String face_token;
}

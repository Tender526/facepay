package com.abc.facepay.controller;

import com.abc.facepay.constant.FlagConstant;
import com.abc.facepay.pojo.User;
import com.abc.facepay.service.UserService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 1. GET（SELECT）：从服务器取出资源（一项或多项）；
 * 2. POST（CREATE）：在服务器新建一个资源；
 * 3. PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）；
 * 4. PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）；
 * 5. DELETE（DELETE）：从服务器删除资源；
 * 6. HEAD：获取资源的元数据；
 * 7. OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的。
 */

@RestController
@RequestMapping("user")
public class UserController {

    private static String listpage = "redirect:/user/findAllUser";

    @Autowired
    private UserService userservice;

    @GetMapping("findAllUser")
    public ModelAndView findAllUser(){
        ModelAndView mv = new ModelAndView("user/userlist");

        List<User> userlist = userservice.findAllUser();
        mv.addObject("userlist",userlist);
        return mv;
    }

    @GetMapping("toAddPage")
    public ModelAndView toAddPage(){
        return new ModelAndView("user/addUser");
    }

    @PostMapping("add")
    public ModelAndView add(@RequestParam Map<String,Object> params){
        ModelAndView mv = new ModelAndView(listpage);

        UUID userid = UUID.randomUUID();
        UUID face_token = UUID.randomUUID();
        User user = new User();
        user.setUid(userid.toString());
        user.setFace_token(face_token.toString());
        user.setBirthday(new Date());
        user.setEmail(params.get("email")+"".toString());
        user.setNickname(params.get("nickname")+"".toString());
        user.setPassword(params.get("password")+"".toString());
        user.setUsername(params.get("username")+"".toString());

        if(StringUtils.isNullOrEmpty(user.getUsername())){
            return mv.addObject("res",FlagConstant.FAIL_FLAG);
        }
        String num = userservice.add(user);
        return mv.addObject("res",num);
    }


    @RequestMapping("delete")
    public ModelAndView delete(String uid){
        String res = FlagConstant.FAIL_FLAG;
        ModelAndView mv = new ModelAndView(listpage);
        if(StringUtils.isNullOrEmpty(uid)){
            return mv.addObject("res",res);
        }

        int num = userservice.deleteByIds(uid);
        if(num>0){
            res = FlagConstant.SUCCESS_FLAG;

        }

        return mv.addObject("res",res);
    }

    @GetMapping("toEditPage")
    public ModelAndView toEditPage(@RequestParam String uid){

        ModelAndView mv = new ModelAndView("user/updateUser");
        if(StringUtils.isNullOrEmpty(uid)){
            return mv.addObject(FlagConstant.FAIL_FLAG);
        }

        User user = userservice.findById(uid);

        System.out.println(user);
        mv.addObject("user",user);
        return mv;
    }


    @RequestMapping("update")
    public ModelAndView update(@RequestParam Map<String,Object> params){
        User user = new User();
        user.setUid(params.get("uid")+"".toString());
        user.setBirthday(new Date());
        user.setEmail(params.get("email")+"".toString());
        user.setNickname(params.get("nickname")+"".toString());
        user.setPassword(params.get("password")+"".toString());
        user.setUsername(params.get("username")+"".toString());

        ModelAndView mv = new ModelAndView(listpage);

        if(StringUtils.isNullOrEmpty(user.getUsername())){
            return mv.addObject(FlagConstant.FAIL_FLAG);
        }

        int num = userservice.updateUserById(user);

        if(num <= 0){
            return mv.addObject(FlagConstant.FAIL_FLAG);
        }

        return mv;
    }


}

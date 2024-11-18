package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.userReg;
import com.example.tedemo.pojo.user_info;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface UserService {
    //根据用户名查询用户
    user_info findByUserName(String username);
    //注册
    void register(String username, String password);

    void update(user_info u);

    void updatePwd(String rePassWord);

    List<user_info> userAll();

    void registerNew(userReg u);
}

package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.UserMapper;
import com.example.tedemo.pojo.userReg;
import com.example.tedemo.pojo.user_info;
import com.example.tedemo.service.impl.UserService;
import com.example.tedemo.utils.Md5Util;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public user_info findByUserName(String username) {
        user_info u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        String md5Password = Md5Util.getMD5String(password);
        userMapper.add(username,md5Password);

    }

    @Override
    public void update(user_info u) {
        u.setUpdate_time(LocalDateTime.now());
        userMapper.update(u);
    }

    @Override
    public void updatePwd(String rePassWord) {
        String rePassword = Md5Util.getMD5String(rePassWord);
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(rePassword,id);
    }

    @Override
    public List<user_info> userAll() {
        List<user_info> data = userMapper.addAll();
        return data;
    }

    @Override
    public void registerNew(userReg u) {
         u.setPassword(Md5Util.getMD5String(u.getPassword()));
         u.setPower("普通用户");
         userMapper.addNew(u);


    }
}

package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.PowerMapper;
import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.itmeList;
import com.example.tedemo.pojo.powerList;
import com.example.tedemo.pojo.user_info;
import com.example.tedemo.service.impl.PowerService;
import com.example.tedemo.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class powerServiceImpl implements PowerService {
    @Autowired
    private PowerMapper powerMapper;
    //更新权限
    @Override
    public void add(user_info u) {
        u.setUpdate_time(LocalDateTime.now());
        powerMapper.updatePower(u);

    }

    @Override
    public List<powerList> CategoryList() {
        List<powerList> p = powerMapper.selectPowerCatList();
        return p;
    }

    @Override
    public PageBean<user_info> PowerListNew(Integer pageNum, Integer pageSize, String power, String role) {
        PageBean<user_info> pb = new PageBean<>();
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        String powerName = (String) map.get("power");
        if (powerName.equals("管理员")){
            PageHelper.startPage(pageNum,pageSize);
            List<user_info> as = powerMapper.selectPowerUserFun( power,role);
            Page<user_info> p = (Page<user_info>) as;
            pb.setTotal(p.getTotal());
            pb.setItems(p.getResult());
            return pb;

        }
        return null;
    }

    @Override
    public void findByidDelete(Integer id) {
        powerMapper.deleteUser(id);
    }
}

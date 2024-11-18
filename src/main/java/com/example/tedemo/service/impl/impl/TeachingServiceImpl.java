package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.TeachingMapper;
import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.SocialWork;
import com.example.tedemo.pojo.Teaching;
import com.example.tedemo.service.impl.TeachingService;
import com.example.tedemo.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TeachingServiceImpl implements TeachingService {
    @Autowired
    private TeachingMapper teachingMapper;
    @Override
    public void addteachFun(Teaching teach) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");
        teach.setCreate_time(LocalDateTime.now());
        teach.setUpdate_time(LocalDateTime.now());
        teach.setState("未审核");
        teach.setUsername(userName);
        teachingMapper.addteach(teach);
    }

    @Override
    public void Putteach(Teaching teach) {
        teach.setUpdate_time(LocalDateTime.now());
        teach.setState("未审核");
        teachingMapper.PutteachFun(teach);

    }

    @Override
    public void PutteachPop(Teaching teach) {
        teach.setUpdate_time(LocalDateTime.now());
        teachingMapper.putteachPopFun(teach);


    }

    @Override
    public void deletetTeachFun(Integer id) {
        teachingMapper.deleteteach(id);

    }

    @Override
    public PageBean<Teaching> teachListFun(Integer pageNum, Integer pageSize, String state) {
        PageBean<Teaching> pb = new PageBean<>();
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        String power = (String) map.get("power");
        if (power.equals("管理员")){
            PageHelper.startPage(pageNum,pageSize);
            List<Teaching> as = teachingMapper.Adminteachlist(state);
            Page<Teaching> p = (Page<Teaching>) as;
            pb.setTotal(p.getTotal());
            pb.setItems(p.getResult());
            return pb;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<Teaching> as = teachingMapper.teachlist(username,state);
        Page<Teaching> p = (Page<Teaching>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
    }


package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.ResearchMapper;
import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.Research;

import com.example.tedemo.service.impl.ResearchService;
import com.example.tedemo.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ResearchServiceImpl implements ResearchService {
    @Autowired
    private ResearchMapper researchMapper;
    @Override
    public void addResFun(Research res) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");
        res.setCreate_time(LocalDateTime.now());
        res.setUpdate_time(LocalDateTime.now());
        res.setStatus("未审核");
        res.setUsername(userName);
        researchMapper.addRes(res);
    }

    @Override
    public void PutRes(Research res) {
        res.setUpdate_time(LocalDateTime.now());
        res.setStatus("未审核");
        researchMapper.PutResFun(res);

    }

    @Override
    public void PutPop(Research res) {
        res.setUpdate_time(LocalDateTime.now());
        researchMapper.putPopFun(res);

    }

    @Override
    public void deleteResFun(Integer id) {
        researchMapper.deleteRes(id);
    }

    @Override
    public PageBean<Research> ResListFun(Integer pageNum, Integer pageSize, String level, String status) {
        PageBean<Research> pb = new PageBean<>();
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        String power = (String) map.get("power");
        if (power.equals("管理员")){
            PageHelper.startPage(pageNum,pageSize);
            List<Research> as = researchMapper.AdminReslist(level,status);
            Page<Research> p = (Page<Research>) as;
            pb.setTotal(p.getTotal());
            pb.setItems(p.getResult());
            return pb;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<Research> as = researchMapper.Reslist(username,level,status);
        Page<Research> p = (Page<Research>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;


    }

    @Override
    public Research findByid(Research res) {
        Research r = researchMapper.findByid(res);
        return r;
    }
}

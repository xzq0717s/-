package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.StudentCompetitionMapper;
import com.example.tedemo.pojo.PageBean;

import com.example.tedemo.pojo.StudentCompetition;
import com.example.tedemo.service.impl.StudentCompetitionService;
import com.example.tedemo.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class StudentCompetitionServiceImpl implements StudentCompetitionService {
    @Autowired
    private StudentCompetitionMapper studentCompetitionMapper;
    @Override
    public void addStuFun(StudentCompetition stu) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");
        stu.setCreate_time(LocalDateTime.now());
        stu.setUpdate_time(LocalDateTime.now());
        stu.setStatus("未审核");
        stu.setUsername(userName);
        studentCompetitionMapper.addstu(stu);

    }

    @Override
    public void PutStu(StudentCompetition stu) {
        stu.setUpdate_time(LocalDateTime.now());
        stu.setStatus("未审核");
        studentCompetitionMapper.PutResFun(stu);

    }

    @Override
    public void PutStuPop(StudentCompetition stu) {
        stu.setUpdate_time(LocalDateTime.now());
        studentCompetitionMapper.putPopFun(stu);

    }

    @Override
    public void deleteStuFun(Integer id) {
        studentCompetitionMapper.deleteStu(id);

    }

    @Override
    public PageBean<StudentCompetition> StuListFun(Integer pageNum, Integer pageSize, String level, String status) {

        PageBean<StudentCompetition> pb = new PageBean<>();
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        String power = (String) map.get("power");
        if (power.equals("管理员")){
            PageHelper.startPage(pageNum,pageSize);
            List<StudentCompetition> as = studentCompetitionMapper.AdminStulist(level,status);
            Page<StudentCompetition> p = (Page<StudentCompetition>) as;
            pb.setTotal(p.getTotal());
            pb.setItems(p.getResult());
            return pb;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<StudentCompetition> as = studentCompetitionMapper.Stulist(username,level,status);
        Page<StudentCompetition> p = (Page<StudentCompetition>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}

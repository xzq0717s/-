package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.TeacherCompetitionMapper;
import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.StudentCompetition;
import com.example.tedemo.pojo.TeacherCompetition;
import com.example.tedemo.service.impl.TeacherCompetitionService;
import com.example.tedemo.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TeacherCompetitionServiceImpl implements TeacherCompetitionService {
    @Autowired
    private TeacherCompetitionMapper teacherCompetitionMapper;
    @Override
    public void addTeaFun(TeacherCompetition tea) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");
        tea.setCreate_time(LocalDateTime.now());
        tea.setUpdate_time(LocalDateTime.now());
        tea.setStatus("未审核");
        tea.setUsername(userName);
        teacherCompetitionMapper.addtea(tea);

    }

    @Override
    public void PutTea(TeacherCompetition tea) {
        tea.setUpdate_time(LocalDateTime.now());
        tea.setStatus("未审核");
        teacherCompetitionMapper.PutteaFun(tea);

    }

    @Override
    public void PutPop(TeacherCompetition tea) {
        tea.setUpdate_time(LocalDateTime.now());
        teacherCompetitionMapper.putPopFun(tea);

    }

    @Override
    public void deleteTeaFun(Integer id) {
        teacherCompetitionMapper.deletetea(id);

    }

    @Override
    public PageBean<TeacherCompetition> TeaListFun(Integer pageNum, Integer pageSize, String level, String status) {
        PageBean<TeacherCompetition> pb = new PageBean<>();
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        String power = (String) map.get("power");
        if (power.equals("管理员")){
            PageHelper.startPage(pageNum,pageSize);
            List<TeacherCompetition> as = teacherCompetitionMapper.Admintealist(level,status);
            Page<TeacherCompetition> p = (Page<TeacherCompetition>) as;
            pb.setTotal(p.getTotal());
            pb.setItems(p.getResult());
            return pb;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<TeacherCompetition> as = teacherCompetitionMapper.tealist(username,level,status);
        Page<TeacherCompetition> p = (Page<TeacherCompetition>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public TeacherCompetition FindByid(TeacherCompetition tea) {
        TeacherCompetition t = teacherCompetitionMapper.findByid(tea);
        return t;
    }
}

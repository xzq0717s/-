package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.TeacherSynthesisMapper;
import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.Pie;
import com.example.tedemo.pojo.TeacherSynthesis;
import com.example.tedemo.service.impl.TeacherSynthesisService;
import com.example.tedemo.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherSynthesisImpl implements TeacherSynthesisService {
    @Autowired
    private TeacherSynthesisMapper teacherSynthesisMapper;
    @Override
    public PageBean<TeacherSynthesis> SyLsit(Integer pageNum, Integer pageSize, String compositeScoreGrade, String teachingQualityScoreGrade) {
        PageBean<TeacherSynthesis> pb = new PageBean<>();
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("nick");
        String power = (String) map.get("power");
        if (power.equals("管理员")){
            PageHelper.startPage(pageNum,pageSize);
            List<TeacherSynthesis> as = teacherSynthesisMapper.AdminSynlist(compositeScoreGrade,teachingQualityScoreGrade);
            Page<TeacherSynthesis> p = (Page<TeacherSynthesis>) as;
            pb.setTotal(p.getTotal());
            pb.setItems(p.getResult());
            return pb;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<TeacherSynthesis> as = teacherSynthesisMapper.Synlist(username,compositeScoreGrade,teachingQualityScoreGrade);
        Page<TeacherSynthesis> p = (Page<TeacherSynthesis>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;


    }

    @Override
    public void putDate(TeacherSynthesis synth) {
        teacherSynthesisMapper.putFun(synth);
    }

    @Override
    public TeacherSynthesis finByUser(String username) {
        TeacherSynthesis t = teacherSynthesisMapper.findByuser(username);
        return t;
    }
    //修改总数
    @Override
    public void updateCount(int count, String prov) {

        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");

        teacherSynthesisMapper.updataCount(count,prov,username);

    }

    @Override
    public void addSynApi(TeacherSynthesis synth) {
        synth.setProvincial_Level(0);
        synth.setNational_Level(0);
        synth.setUniversity_Level(0);
        synth.setTeaching_Achievements_Count(0);
        teacherSynthesisMapper.addSynFun(synth);

    }

    @Override
    public void deleteFindid(Integer id) {
        teacherSynthesisMapper.deleteFind(id);
    }

    @Override
    public Pie seletePieData() {
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("nick");
        String power = (String) map.get("power");
        System.out.println(username);
        if (power.equals("管理员")){
            Pie p = teacherSynthesisMapper.selectDataAdminAPi();
            return p;
        }
        Pie p = teacherSynthesisMapper.selectDataAPi(username);
        System.out.println(p);

        return p;
    }
}

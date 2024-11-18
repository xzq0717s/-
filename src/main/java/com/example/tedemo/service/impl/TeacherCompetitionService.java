package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.TeacherCompetition;

public interface TeacherCompetitionService {
    void addTeaFun(TeacherCompetition tea);

    void PutTea(TeacherCompetition tea);

    void PutPop(TeacherCompetition tea);

    void deleteTeaFun(Integer id);

    PageBean<TeacherCompetition> TeaListFun(Integer pageNum, Integer pageSize, String level, String status);

    TeacherCompetition FindByid(TeacherCompetition tea);
}

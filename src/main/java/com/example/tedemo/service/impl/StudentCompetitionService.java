package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.Research;
import com.example.tedemo.pojo.StudentCompetition;

public interface StudentCompetitionService {
    void addStuFun(StudentCompetition stu);

    void PutStu(StudentCompetition stu);

    void PutStuPop(StudentCompetition stu);

    void deleteStuFun(Integer id);

    PageBean<StudentCompetition> StuListFun(Integer pageNum, Integer pageSize, String level, String status);
}

package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.Pie;
import com.example.tedemo.pojo.TeacherSynthesis;

public interface TeacherSynthesisService {
    PageBean<TeacherSynthesis> SyLsit(Integer pageNum, Integer pageSize, String compositeScoreGrade, String teachingQualityScoreGrade);

    void putDate(TeacherSynthesis synth);

    TeacherSynthesis finByUser(String username);

    void updateCount(int count, String prov);

    void addSynApi(TeacherSynthesis synth);

    void deleteFindid(Integer id);

    Pie seletePieData();
}

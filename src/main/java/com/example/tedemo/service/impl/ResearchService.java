package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.Research;

public interface ResearchService {
    void addResFun(Research res);

    void PutRes(Research res);

    void PutPop(Research res);

    void deleteResFun(Integer id);

    PageBean<Research> ResListFun(Integer pageNum, Integer pageSize, String level, String status);

    Research findByid(Research res);
}

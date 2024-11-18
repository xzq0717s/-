package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.Teaching;

public interface TeachingService {
    void addteachFun(Teaching teach);

    void Putteach(Teaching teach);

    void PutteachPop(Teaching teach);

    void deletetTeachFun(Integer id);

    PageBean<Teaching> teachListFun(Integer pageNum, Integer pageSize, String state);
}

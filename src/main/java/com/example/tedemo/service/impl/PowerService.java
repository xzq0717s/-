package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.powerList;
import com.example.tedemo.pojo.user_info;

import java.util.List;

public interface PowerService {
    void add(user_info u);

    List<powerList> CategoryList();

    PageBean<user_info> PowerListNew(Integer pageNum, Integer pageSize, String power, String role);

    void findByidDelete(Integer id);
}

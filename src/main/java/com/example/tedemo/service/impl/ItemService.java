package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.itmeList;

import java.util.List;

public interface ItemService {
    void add(itmeList item);

    void putDate(itmeList item);

    void deleteById(Integer id);

    List<itmeList> findByuserName(String username);
//条件分页
    PageBean<itmeList> ListNew(Integer pageNum, Integer pageSize, String category, String state);

    void putPop(itmeList item);
}

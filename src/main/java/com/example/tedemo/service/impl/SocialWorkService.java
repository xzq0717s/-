package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.SocialWork;

public interface SocialWorkService {
    void addSocFun(SocialWork soc);

    void PutSoc(SocialWork soc);

    void PutPopFun(SocialWork soc);

    void deleteSocFun(Integer id);

    PageBean<SocialWork> SocListFun(Integer pageNum, Integer pageSize, String status);
}

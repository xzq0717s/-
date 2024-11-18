package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.PartyBuilding;

public interface PartyBuildingService {
    void addParFun(PartyBuilding par);

    void PutPar(PartyBuilding par);

    void PutPopFun(PartyBuilding par);

    void deleteParFun(Integer id);

    PageBean<PartyBuilding> ParListFun(Integer pageNum, Integer pageSize, String status);
}

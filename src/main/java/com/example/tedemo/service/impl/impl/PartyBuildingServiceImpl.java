package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.PartyBuildingMapper;
import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.PartyBuilding;
import com.example.tedemo.pojo.Research;
import com.example.tedemo.service.impl.PartyBuildingService;
import com.example.tedemo.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PartyBuildingServiceImpl implements PartyBuildingService {
    @Autowired
    private PartyBuildingMapper partyBuildingMapper;
    @Override
    public void addParFun(PartyBuilding par) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");
        par.setCreate_time(LocalDateTime.now());
        par.setUpdate_time(LocalDateTime.now());
        par.setUsername(userName);
        par.setStatus("未审核");
        partyBuildingMapper.addPar(par);

    }

    @Override
    public void PutPar(PartyBuilding par) {
        par.setUpdate_time(LocalDateTime.now());
        par.setStatus("未审核");
        partyBuildingMapper.PutResFun(par);

    }

    @Override
    public void PutPopFun(PartyBuilding par) {
        par.setUpdate_time(LocalDateTime.now());
        partyBuildingMapper.putPopFun(par);
    }

    @Override
    public void deleteParFun(Integer id) {
        partyBuildingMapper.deletepar(id);

    }

    @Override
    public PageBean<PartyBuilding> ParListFun(Integer pageNum, Integer pageSize, String status) {
        PageBean<PartyBuilding> pb = new PageBean<>();
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        String power = (String) map.get("power");
        if (power.equals("管理员")){
            PageHelper.startPage(pageNum,pageSize);
            List<PartyBuilding> as = partyBuildingMapper.AdminParlist(status);
            Page<PartyBuilding> p = (Page<PartyBuilding>) as;
            pb.setTotal(p.getTotal());
            pb.setItems(p.getResult());
            return pb;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<PartyBuilding> as = partyBuildingMapper.Parlist(username,status);
        Page<PartyBuilding> p = (Page<PartyBuilding>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}

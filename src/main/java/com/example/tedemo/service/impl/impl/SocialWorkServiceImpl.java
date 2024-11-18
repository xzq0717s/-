package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.SocialWorkMapper;
import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.Research;
import com.example.tedemo.pojo.SocialWork;
import com.example.tedemo.service.impl.SocialWorkService;
import com.example.tedemo.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class SocialWorkServiceImpl  implements SocialWorkService {
    @Autowired
    private SocialWorkMapper socialWorkMapper;
    @Override
    public void addSocFun(SocialWork soc) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");
        soc.setCreate_time(LocalDateTime.now());
        soc.setUpdate_time(LocalDateTime.now());
        soc.setState("未审核");
        soc.setUsername(userName);
        socialWorkMapper.addsoc(soc);

    }

    @Override
    public void PutSoc(SocialWork soc) {
        soc.setUpdate_time(LocalDateTime.now());
        soc.setState("未审核");
        socialWorkMapper.PutsocFun(soc);

    }

    @Override
    public void PutPopFun(SocialWork soc) {
        soc.setUpdate_time(LocalDateTime.now());
        socialWorkMapper.putSocPopFun(soc);

    }

    @Override
    public void deleteSocFun(Integer id) {
        socialWorkMapper.deleteSoc(id);

    }

    @Override
    public PageBean<SocialWork> SocListFun(Integer pageNum, Integer pageSize, String status) {
        PageBean<SocialWork> pb = new PageBean<>();
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        String power = (String) map.get("power");
        if (power.equals("管理员")){
            PageHelper.startPage(pageNum,pageSize);
            List<SocialWork> as = socialWorkMapper.AdminSoclist(status);
            Page<SocialWork> p = (Page<SocialWork>) as;
            pb.setTotal(p.getTotal());
            pb.setItems(p.getResult());
            return pb;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<SocialWork> as = socialWorkMapper.Soclist(username,status);
        Page<SocialWork> p = (Page<SocialWork>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}

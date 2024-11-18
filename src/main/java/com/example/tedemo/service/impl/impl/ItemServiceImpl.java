package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.ItemMapper;
import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.itmeList;
import com.example.tedemo.service.impl.ItemService;
import com.example.tedemo.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public void add(itmeList item) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        item.setUsername(username);
        item.setCreate_time(LocalDateTime.now());
        item.setUpdate_time(LocalDateTime.now());
        itemMapper.add(item);
    }

    @Override
    public void putDate(itmeList item) {
        item.setUpdate_time(LocalDateTime.now());
        itemMapper.upDateList(item);


    }

    @Override
    public void deleteById(Integer id) {
        itemMapper.deleteById(id);
    }

    @Override
    public List<itmeList> findByuserName(String username) {
        List<itmeList> data = itemMapper.findByUserName(username);
        return data;

    }

    @Override
    public PageBean<itmeList> ListNew(Integer pageNum, Integer pageSize, String category, String state) {
        PageBean<itmeList> pb = new PageBean<>();
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        String power = (String) map.get("power");
        if (power.equals("管理员")){
            PageHelper.startPage(pageNum,pageSize);
            List<itmeList> as = itemMapper.Adminlist(category,state);
            Page<itmeList> p = (Page<itmeList>) as;
            pb.setTotal(p.getTotal());
            pb.setItems(p.getResult());
            return pb;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<itmeList> as = itemMapper.list(username,category,state);
        Page<itmeList> p = (Page<itmeList>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void putPop(itmeList item) {
        item.setUpdate_time(LocalDateTime.now());
        itemMapper.upPopData(item);

    }

}

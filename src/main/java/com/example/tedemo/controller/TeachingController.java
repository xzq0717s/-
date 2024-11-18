package com.example.tedemo.controller;

import com.example.tedemo.pojo.PageBean;

import com.example.tedemo.pojo.Teaching;
import com.example.tedemo.pojo.result;
import com.example.tedemo.service.impl.TeachingService;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Teaching")
public class TeachingController {
    @Autowired
    private TeachingService teachingService;

    @PostMapping("/addteach")
    public result addteach(@RequestBody Teaching teach){
        System.out.println(teach);
        teachingService.addteachFun(teach);
        return result.success();
    }
    @PutMapping("/putteach")
    public result Putteach(@RequestBody Teaching teach){
        System.out.println("---Put---");
        System.out.println(teach);
        teachingService.Putteach(teach);
        return result.success();
    }
    @PutMapping("/putteachPOP")
    public result Popteach(@RequestBody Teaching teach){
        System.out.println("----pop----");
        System.out.println(teach);
        Map<String,Object> map = ThreadLocalUtil.get();
        String power = (String) map.get("power");
        if (!power.equals("管理员")){
            return result.error("没有权限修改状态");
        }
        teachingService.PutteachPop(teach);
        return result.success();
    }

    @DeleteMapping("/deleteteach")
    public result deleteteach(Integer id){
        teachingService.deletetTeachFun(id);
        return result.success();
    }

    @GetMapping("/teachList")
    public result<PageBean<Teaching>> teachList(
            Integer pageNum,
            Integer pageSize,

            @RequestParam(required = false) String state
    ){
        PageBean<Teaching> pb = teachingService.teachListFun(pageNum,pageSize,state);
        return  result.success(pb);

    }
}

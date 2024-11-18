package com.example.tedemo.controller;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.PartyBuilding;
import com.example.tedemo.pojo.SocialWork;
import com.example.tedemo.pojo.result;
import com.example.tedemo.service.impl.SocialWorkService;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Social")
public class SocialWorkController {
    @Autowired
    private SocialWorkService socialWorkService;

    @PostMapping("/addPar")
    public result addRes(@RequestBody SocialWork Soc){
        System.out.println(Soc);
        socialWorkService.addSocFun(Soc);
        return result.success();
    }
    @PutMapping("/putSoc")
    public result PutRes(@RequestBody SocialWork Soc){
        System.out.println("---Put---");
        System.out.println(Soc);
        socialWorkService.PutSoc(Soc);
        return result.success();
    }
    @PutMapping("/putSocPOP")
    public result PopSoc(@RequestBody SocialWork Soc){
        System.out.println("----pop----");
        System.out.println(Soc);
        Map<String,Object> map = ThreadLocalUtil.get();
        String power = (String) map.get("power");
        if (!power.equals("管理员")){
            return result.error("没有权限修改状态");
        }
        socialWorkService.PutPopFun(Soc);
        return result.success();
    }

    @DeleteMapping("/deleteSoc")
    public result deleteSoc(Integer id){
        socialWorkService.deleteSocFun(id);
        return result.success();
    }
    @GetMapping("/SocList")
    public result<PageBean<SocialWork>> SocList(
            Integer pageNum,
            Integer pageSize,

            @RequestParam(required = false) String status
    ){
        PageBean<SocialWork> pb = socialWorkService.SocListFun(pageNum,pageSize,status);
        return  result.success(pb);

    }
}

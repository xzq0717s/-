package com.example.tedemo.controller;


import com.example.tedemo.pojo.*;
import com.example.tedemo.service.impl.ResearchService;
import com.example.tedemo.service.impl.TeacherSynthesisService;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Research")
public class ResearchController {
    @Autowired
    private ResearchService researchService;
    @Autowired
    private TeacherSynthesisService teacherSynthesisService;
    @PostMapping("/addRes")
    public result addRes(@RequestBody Research Res){
        System.out.println(Res);
        researchService.addResFun(Res);
        return result.success();
    }
    @PutMapping("/putRes")
    public result PutRes(@RequestBody Research Res){
        System.out.println("---Put---");
        System.out.println(Res);
        researchService.PutRes(Res);
        return result.success();
    }
    @PutMapping("/putPOP")
    public result PopRes(@RequestBody Research Res){
        System.out.println("----pop----");
        System.out.println(Res);
        Map<String,Object> map = ThreadLocalUtil.get();
        String power = (String) map.get("power");
        String username = (String) map.get("userName");
        if (!power.equals("管理员")){
            return result.error("没有权限修改状态");
        }

        Research t = researchService.findByid(Res);
        System.out.println(t);
        TeacherSynthesis T = teacherSynthesisService.finByUser(username);

        if (t.getLevel().equals("省级") && Res.getStatus().equals("审核通过")){
            int count = T.getProvincial_Level() + 1;
            System.out.println(count);
            String Prov = t.getLevel();
            teacherSynthesisService.updateCount(count,Prov);
        }else if (t.getLevel().equals("省级") && Res.getStatus().equals("已作废")){
            int count = T.getProvincial_Level() - 1;
            System.out.println(count+t.getLevel());
            String Prov = t.getLevel();
            teacherSynthesisService.updateCount(count,Prov);
        }
        if(t.getLevel().equals("国家级") && Res.getStatus().equals("审核通过")){
            int count = T.getNational_Level() + 1;
            System.out.println(count);
            String Nat = t.getLevel();
            teacherSynthesisService.updateCount(count,Nat);
        }else if (t.getLevel().equals("国家级") && Res.getStatus().equals("已作废")){
            int count = T.getNational_Level() - 1;
            System.out.println(count+t.getLevel());
            String Nat = t.getLevel();
            teacherSynthesisService.updateCount(count,Nat);
        }
        if(t.getLevel().equals("校级") && Res.getStatus().equals("审核通过")){
            int count = T.getUniversity_Level() + 1;
            String Univer = t.getLevel();
            teacherSynthesisService.updateCount(count,Univer);
        }else if (t.getLevel().equals("校级") && Res.getStatus().equals("已作废")){
            int count = T.getUniversity_Level() - 1;
            System.out.println(count);
            String Univer = t.getLevel();
            teacherSynthesisService.updateCount(count,Univer);
        }

        int allCount = T.getProvincial_Level() + T.getNational_Level() + T.getUniversity_Level();
        teacherSynthesisService.updateCount(allCount,"总数");


        researchService.PutPop(Res);
        return result.success();
    }

    @DeleteMapping("/deleteRes")
    public result deleteRes(Integer id){
        researchService.deleteResFun(id);
        return result.success();
    }
    @GetMapping("/ResList")
    public result<PageBean<Research>> ResList(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String status
    ){
        PageBean<Research> pb = researchService.ResListFun(pageNum,pageSize,level,status);
        return  result.success(pb);

    }


}

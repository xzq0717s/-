package com.example.tedemo.controller;

import com.example.tedemo.pojo.*;
import com.example.tedemo.service.impl.TeacherCompetitionService;
import com.example.tedemo.service.impl.TeacherSynthesisService;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/TeachCom")
public class TeacherCompetitionController {
    @Autowired
    private TeacherCompetitionService teacherCompetitionService;
    @Autowired
    private TeacherSynthesisService teacherSynthesisService;

    @PostMapping("/addTea")
    public result addTea(@RequestBody TeacherCompetition Tea){
        System.out.println(Tea);
        teacherCompetitionService.addTeaFun(Tea);
        return result.success();
    }
    @PutMapping("/putTea")
    public result PutTea(@RequestBody TeacherCompetition Tea){
        System.out.println("---Put---");
        System.out.println(Tea);
        teacherCompetitionService.PutTea(Tea);
        return result.success();
    }

    @PutMapping("/putPOP")
    public result PopTea(@RequestBody TeacherCompetition Tea){
        System.out.println("----pop----");
        System.out.println(Tea);
        Map<String,Object> map = ThreadLocalUtil.get();
        String power = (String) map.get("power");
        String username = (String) map.get("userName");
        System.out.println(username);
        if (!power.equals("管理员")){
            return result.error("没有权限修改状态");
        }
        TeacherCompetition  t = teacherCompetitionService.FindByid(Tea);
        System.out.println(t);
        TeacherSynthesis T = teacherSynthesisService.finByUser(username);
        System.out.println(T+username);
        if (t.getLevel().equals("省级") && Tea.getStatus().equals("审核通过")){
            System.out.println("省级加1");
            int count = T.getProvincial_Level() + 1;
            System.out.println(count);
            String Prov = t.getLevel();
            teacherSynthesisService.updateCount(count,Prov);
        }else if (t.getLevel().equals("省级") && Tea.getStatus().equals("已作废")){
            int count = T.getProvincial_Level() - 1;
            System.out.println(count+t.getLevel());
            String Prov = t.getLevel();
            teacherSynthesisService.updateCount(count,Prov);
        }
        if(t.getLevel().equals("国家级") && Tea.getStatus().equals("审核通过")){
            System.out.println("国家级别加1");
            int count = T.getNational_Level() + 1;
            System.out.println(count + t.getLevel());
            String Nat = t.getLevel();
            teacherSynthesisService.updateCount(count,Nat);
        }else if (t.getLevel().equals("国家级") && Tea.getStatus().equals("已作废")){
            int count = T.getNational_Level() - 1;
            System.out.println(count+t.getLevel());
            String Nat = t.getLevel();
            teacherSynthesisService.updateCount(count,Nat);
        }
        if(t.getLevel().equals("校级") && Tea.getStatus().equals("审核通过")){
            System.out.println("校级加1");
            int count = T.getUniversity_Level() + 1;
            String Univer = t.getLevel();
            teacherSynthesisService.updateCount(count,Univer);
        }else if (t.getLevel().equals("校级") && Tea.getStatus().equals("已作废")){
            int count = T.getUniversity_Level() - 1;
            System.out.println(count);
            String Univer = t.getLevel();
            teacherSynthesisService.updateCount(count,Univer);
        }

        int allCount = T.getProvincial_Level() + T.getNational_Level() + T.getUniversity_Level();
        teacherSynthesisService.updateCount(allCount,"总数");
        System.out.println(allCount);


        teacherCompetitionService.PutPop(Tea);
        System.out.println(T);
        return result.success();
    }

    @DeleteMapping("/deleteTea")
    public result deleteTea(Integer id){
        Map<String,Object> map = ThreadLocalUtil.get();
        String power = (String) map.get("power");
        String username = (String) map.get("userName");


        teacherCompetitionService.deleteTeaFun(id);
        return result.success();
    }
    @GetMapping("/TeaList")
    public result<PageBean<TeacherCompetition>> TeaList(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String status
    ){
        System.out.println(level+status);
        PageBean<TeacherCompetition> pb = teacherCompetitionService.TeaListFun(pageNum,pageSize,level,status);
        return  result.success(pb);

    }
}

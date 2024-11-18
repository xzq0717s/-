package com.example.tedemo.controller;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.Research;
import com.example.tedemo.pojo.StudentCompetition;
import com.example.tedemo.pojo.result;
import com.example.tedemo.service.impl.SocialWorkService;
import com.example.tedemo.service.impl.StudentCompetitionService;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/StudentCom")
public class StudentCompetitionController {
    @Autowired
    private StudentCompetitionService studentCompetitionService;

    @PostMapping("/addStu")
    public result addStu(@RequestBody StudentCompetition Stu){
        System.out.println(Stu);
        studentCompetitionService.addStuFun(Stu);
        return result.success();
    }
    @PutMapping("/putStu")
    public result PutStu(@RequestBody StudentCompetition Stu){
        System.out.println("---Put---");
        System.out.println(Stu);
        studentCompetitionService.PutStu(Stu);
        return result.success();
    }
    @PutMapping("/putStuPOP")
    public result PopStu(@RequestBody StudentCompetition Stu){
        System.out.println("----pop----");
        System.out.println(Stu);
        Map<String,Object> map = ThreadLocalUtil.get();
        String power = (String) map.get("power");
        if (!power.equals("管理员")){
            return result.error("没有权限修改状态");
        }
        studentCompetitionService.PutStuPop(Stu);
        return result.success();
    }

    @DeleteMapping("/deleteStu")
    public result deleteStu(Integer id){
        studentCompetitionService.deleteStuFun(id);
        return result.success();
    }

    @GetMapping("/StuList")
    public result<PageBean<StudentCompetition>> StuList(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String status
    ){
        PageBean<StudentCompetition> pb = studentCompetitionService.StuListFun(pageNum,pageSize,level,status);
        return  result.success(pb);

    }
}

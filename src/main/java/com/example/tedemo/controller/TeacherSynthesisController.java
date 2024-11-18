package com.example.tedemo.controller;

import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.Pie;
import com.example.tedemo.pojo.TeacherSynthesis;
import com.example.tedemo.pojo.result;
import com.example.tedemo.service.impl.TeacherSynthesisService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Synthesis")
@Validated
public class TeacherSynthesisController {
    @Autowired
    private TeacherSynthesisService teacherSynthesisService;
    @GetMapping("/SynthesisList")
    public result<PageBean<TeacherSynthesis>> Synthesis(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String compositeScore,
            @RequestParam(required = false) String teachingQuality
    )
    {
        PageBean<TeacherSynthesis> pb = teacherSynthesisService.SyLsit(pageNum,pageSize,compositeScore,teachingQuality);
        return result.success(pb);
    }

    @PutMapping("/putSynthesis")
    public  result putSynthesis(@RequestBody TeacherSynthesis Synth){
        System.out.println(Synth);
        teacherSynthesisService.putDate(Synth);
        return result.success();
    }
    @PostMapping("/addSynthesis")
    public result addSynthesis(@RequestBody TeacherSynthesis synth){
        System.out.println(synth);
        teacherSynthesisService.addSynApi(synth);
        return result.success();
    }
    @DeleteMapping("/deleteSyn")
    public result deleteSyn(Integer id){
        teacherSynthesisService.deleteFindid(id);
        return result.success();
    }

    //图形部分
    @GetMapping("/pie")
    public result<Pie> PieDate(){
        Pie p = teacherSynthesisService.seletePieData();

        return result.success(p);
    }








}

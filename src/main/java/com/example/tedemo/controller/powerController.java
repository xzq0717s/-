package com.example.tedemo.controller;

import com.example.tedemo.pojo.*;
import com.example.tedemo.service.impl.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/power")
public class powerController {
    @Autowired
    private PowerService powerService;
    @PutMapping("/updatePower")
    public result PutPower(@RequestBody user_info u){
        System.out.println(u);
        powerService.add(u);
        return result.success();
    }


    @GetMapping("/Category")
    public result<List<powerList>> PowerUserCategoryController(){
        List<powerList> p = powerService.CategoryList();
        return  result.success(p);
    }

    @GetMapping("/powerUserList")
    public result<PageBean<user_info>> PowerListUser(   Integer pageNum, Integer pageSize,
                                                    @RequestParam(required = false) String Power,
                                                    @RequestParam(required = false) String role){
        System.out.println(Power + role);
        PageBean<user_info> pb = powerService.PowerListNew(pageNum,pageSize,Power,role);
        return result.success(pb);
    }

    @DeleteMapping("/deletePower")
    public result DeletePower(Integer id){
        System.out.println(id);
        powerService.findByidDelete(id);
        return result.success();
    }


}

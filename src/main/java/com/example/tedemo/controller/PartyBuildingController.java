package com.example.tedemo.controller;

import com.example.tedemo.pojo.PageBean;

import com.example.tedemo.pojo.PartyBuilding;
import com.example.tedemo.pojo.result;
import com.example.tedemo.service.impl.PartyBuildingService;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Party")
public class PartyBuildingController {
    @Autowired
    private PartyBuildingService partyBuildingService;

    @PostMapping("/addPar")
    public result addRes(@RequestBody PartyBuilding Par){
        System.out.println(Par);
        partyBuildingService.addParFun(Par);
        return result.success();
    }
    @PutMapping("/putPar")
    public result PutRes(@RequestBody PartyBuilding Par){
        System.out.println("---Put---");
        System.out.println(Par);
        partyBuildingService.PutPar(Par);
        return result.success();
    }
    @PutMapping("/putParPOP")
    public result PopPar(@RequestBody PartyBuilding Par){
        System.out.println("----pop----");
        System.out.println(Par);
        Map<String,Object> map = ThreadLocalUtil.get();
        String power = (String) map.get("power");
        if (!power.equals("管理员")){
            return result.error("没有权限修改状态");
        }
        partyBuildingService.PutPopFun(Par);
        return result.success();
    }

    @DeleteMapping("/deletePar")
    public result deletePar(Integer id){
        partyBuildingService.deleteParFun(id);
        return result.success();
    }
    @GetMapping("/ParList")
    public result<PageBean<PartyBuilding>> ParList(
            Integer pageNum,
            Integer pageSize,

            @RequestParam(required = false) String status
    ){
        PageBean<PartyBuilding> pb = partyBuildingService.ParListFun(pageNum,pageSize,status);
        return  result.success(pb);

    }

}

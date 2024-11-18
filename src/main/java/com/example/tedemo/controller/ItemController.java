package com.example.tedemo.controller;

import com.example.tedemo.pojo.Category;
import com.example.tedemo.pojo.PageBean;
import com.example.tedemo.pojo.itmeList;
import com.example.tedemo.pojo.result;
import com.example.tedemo.service.impl.ItemService;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    //添加文章
    @PostMapping("/add")
    public result add(@RequestBody itmeList item){
        System.out.println(item);
        itemService.add(item);
        return result.success();
    }
    //更新文章
    @PutMapping("/update")
    public result PutDateList(@RequestBody @Validated itmeList item){
        System.out.println(item);
//        Map<String,Object> map = ThreadLocalUtil.get();
//        String power = (String) map.get("power");
//        if (!power.equals("管理员")&& item.getState() != null){
//            return result.error("没有权限修改状态");
//        }

        itemService.putDate(item);
        return result.success();
    }
    @PutMapping("/upPop")
    public  result PutPop(@RequestBody @Validated itmeList item){
        System.out.println(item);
        Map<String,Object> map = ThreadLocalUtil.get();
        String power = (String) map.get("power");
        if (!power.equals("管理员")){
            return result.error("没有权限修改状态");
        }
        itemService.putPop(item);
        return result.success();


    }


    //删除文章
    @DeleteMapping("/article")
    public result DeleteItem(Integer id){
        itemService.deleteById(id);
        return result.success();
    }
    @GetMapping("/itemList")
    public result<List<itmeList>> listItem(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        List<itmeList> data = itemService.findByuserName(username);
        return result.success(data);
    }

    @GetMapping("/itemListNew")
    public result<PageBean<itmeList>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String state
    ){
        PageBean<itmeList> pb = itemService.ListNew(pageNum,pageSize,category,state);
        return  result.success(pb);

    }


}

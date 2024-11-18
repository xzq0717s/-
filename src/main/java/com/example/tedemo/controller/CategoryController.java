package com.example.tedemo.controller;

import com.example.tedemo.pojo.Category;
import com.example.tedemo.pojo.result;
import com.example.tedemo.service.impl.CategoryService;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@Validated
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    //添加分类
    @PostMapping("/addCategory")
    public result<String> add(@RequestBody @Validated Category category){
        String catName = category.getCategory_name();
        Map<String,Object> map = ThreadLocalUtil.get();
        String catUser = (String) map.get("userName");
        System.out.println(catUser);

        Category c =  categoryService.selectData(catName,catUser);
        if (c == null){
            categoryService.add(category);
            return result.success("添加分类成功");
        }
        if (catName.equals(c.getCategory_name())){
            return result.error("存在相同分类");
        }
        return result.error("分类添加失败");
    }
    //获取分类列表
    @GetMapping("/categoryinfo")
    public result<List<Category>>CategoryInfo(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("userName");
        System.out.println(username);
        List<Category> data = categoryService.findByJobId(username);
        return result.success(data);
    }
    //获取分类详情
    @GetMapping("/categorydetail")
    public result<Category>CatDetail(Integer id){
        Category c = categoryService.findByCatId(id);
        System.out.println(id);
        return result.success(c);
    }
    //更新分类
    @PutMapping("/update")
    public result update(@RequestBody @Validated Category category){
        categoryService.update(category);
        return result.success();
    }
    //删除分类
    @DeleteMapping("/deleteCategory")
    public result deleteCategory(Integer id){
        categoryService.deleteCategoryById(id);
        return result.success();
    }



}

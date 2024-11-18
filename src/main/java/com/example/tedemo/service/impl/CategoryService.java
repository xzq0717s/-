package com.example.tedemo.service.impl;

import com.example.tedemo.pojo.Category;

import java.util.List;

public interface CategoryService {
    //添加分类
    void add(Category category);

    List<Category> findByJobId(String username);

    Category selectData(String catName,String catUser);


    Category findByCatId(Integer id);

    void update(Category category);

    void deleteCategoryById(Integer id);

}

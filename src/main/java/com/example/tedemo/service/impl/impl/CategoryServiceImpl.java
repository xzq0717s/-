package com.example.tedemo.service.impl.impl;

import com.example.tedemo.mapper.CategoryMapper;
import com.example.tedemo.pojo.Category;
import com.example.tedemo.service.impl.CategoryService;
import com.example.tedemo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("userName");
        category.setCreate_time(LocalDateTime.now());
        category.setUpdate_time(LocalDateTime.now());
        category.setCreate_user(userName);
        categoryMapper.add(category);
    }

    @Override
    public List<Category> findByJobId(String username) {
        List<Category> data = categoryMapper.findByJobId(username);
        return (List<Category>) data;
    }

    @Override
    public Category selectData(String catName, String catUser) {
        Category c = categoryMapper.selectData(catName,catUser);

        return c;
    }
    @Override
    public Category findByCatId(Integer id) {
        Category c = categoryMapper.findByID(id);
        return c;
    }

    @Override
    public void update(Category category) {
        category.setUpdate_time(LocalDateTime.now());
        categoryMapper.update(category);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryMapper.deleteById(id);
    }
}

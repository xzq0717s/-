package com.example.tedemo.mapper;

import com.example.tedemo.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    //增加分类
    @Insert("INSERT INTO category(category_name,create_user,create_time,update_time)" +
            "values (#{category_name},#{create_user},#{create_time},#{update_time})")
    void add(Category category);
    //查询
    @Select("select * from category where create_user = #{username}")
    List<Category> findByJobId(String username);
    //查询列表
    @Select("select * from category where category_name = #{catName} and create_user = #{catUser}")
    Category selectData(String catName,String catUser);
    //查询分类
    @Select("select * from category where id = #{id}")
    Category findByID(Integer id);
    //更新
    @Update("update category set category_name = #{category_name},update_time = #{update_time}where id = #{id}")
    void update(Category category);
    //删除
    @Delete("DELETE FROM category WHERE id = #{id}")
    void deleteById(Integer id);
}

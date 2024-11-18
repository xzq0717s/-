package com.example.tedemo.mapper;

import com.example.tedemo.pojo.itmeList;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Insert("insert into item (itemName,category,pratTeacher,money,score,materials,state,username,create_time,update_time,item_class)" +
            "values (#{itemName}, #{category}, #{pratTeacher}, #{money}, #{score}, #{materials}," +
            "#{state}, #{username}, #{create_time}, #{update_time},#{item_class})")
    void add(itmeList item);
    @Update("update item set itemName = #{itemName} ,category = #{category} ,pratTeacher=#{pratTeacher},money=#{money}," +
            " score=#{score},materials=#{materials},update_time=#{update_time},item_class=#{item_class} , state = #{state}where id = #{id}")
    void upDateList(itmeList item);
    @Delete("DELETE FROM item WHERE id = #{id}")
    void deleteById(Integer id);
    @Select("select * from item where username = #{username}")
    List<itmeList> findByUserName(String username);

    List<itmeList> list(String username, String category, String state);
//    @Select("select * from item")
    List<itmeList> Adminlist(String category, String state);
    @Update("update item set state = #{state} where id = #{id}")
    void upPopData(itmeList item);

}

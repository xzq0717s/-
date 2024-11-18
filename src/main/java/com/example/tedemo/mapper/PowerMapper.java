package com.example.tedemo.mapper;

import com.example.tedemo.pojo.powerList;
import com.example.tedemo.pojo.user_info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PowerMapper {
    @Update("update user_info set Power = #{Power} ,role = #{role},update_time = #{update_time} where id = #{id}")
    void updatePower(user_info u);
    @Select("select * from power")
    List<powerList> selectPowerCatList();

    List<user_info> selectPowerUserFun(String power, String role);
    @Delete("DELETE FROM user_info WHERE id = #{id}")
    void deleteUser(Integer id);
}

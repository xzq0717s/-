package com.example.tedemo.mapper;

import com.example.tedemo.pojo.userReg;
import com.example.tedemo.pojo.user_info;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询用户是否存在以及查询用户信息
    @Select("select * from user_info where jobid = #{username}")
    user_info findByUserName(String username);
    //添加用户
    @Insert("insert into user_info(jobid,pasaword,create_time,update_time) " +
            "values (#{username},#{password},now(),now())")
    void add(String username, String password);
    //更新用户资料
    @Update("update user_info set nickname = #{nickname},phone = #{phone}, update_time = #{update_time} where id = #{id}")
    void update(user_info u);
    @Update("update user_info set password = #{rePassWord} ,update_time = now() where id = #{id} ")
    void updatePwd(String rePassWord,Integer id);
    @Select("select * from user_info")
    List<user_info> addAll();
    @Insert("insert into " +
            "user_info" +
            "(jobid,password,nickname,phone,office,Power,role,create_time,update_time) " +
            "values " +
            "(#{jobid},#{password},#{nickname},#{phone},#{office},#{Power},#{role},now(),now())")
    void addNew(userReg u);
}

package com.example.tedemo.mapper;

import com.example.tedemo.pojo.Teaching;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TeachingMapper {
    @Insert("INSERT INTO teaching (username, teacher_name, source, state, create_time, update_time) " +
            "VALUES (#{username}, #{teacher_name}, #{source}, #{state}, #{create_time}, #{update_time})")
    void addteach(Teaching teach);
    @Update("UPDATE teaching " +
            "SET " +
            "teacher_name = #{teacher_name},"+
            "source = #{source}, " +
            "state = #{state}, " +
            "update_time = #{update_time} " +
            "WHERE id = #{id} ")
    void PutteachFun(Teaching teach);
    @Update("update teaching set state = #{state} WHERE id = #{id} ")
    void putteachPopFun(Teaching teach);
    @Delete("DELETE FROM teaching WHERE id = #{id}")
    void deleteteach(Integer id);

    List<Teaching> Adminteachlist(String state);

    List<Teaching> teachlist(String username, String state);
}

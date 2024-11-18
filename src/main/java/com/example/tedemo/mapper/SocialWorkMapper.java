package com.example.tedemo.mapper;

import com.example.tedemo.pojo.SocialWork;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SocialWorkMapper {
    @Insert("INSERT INTO social_work (username, item_name, first_name, sign_time, contract_amount, arrival_memory, teacher_name, teacher_num, source, materials, state, create_time, update_time) " +
            "VALUES (#{username}, #{item_name}, #{first_name}, #{sign_time}, #{contract_amount}, #{arrival_memory}, #{teacher_name}, #{teacher_num}, #{source}, #{materials}, #{state}, #{create_time}, #{update_time})")
    void addsoc(SocialWork soc);
    @Update("UPDATE social_work " +
            "SET " +
            "item_name = #{item_name}, " +
            "first_name = #{first_name}, " +
            "sign_time = #{sign_time}, " +
            "contract_amount = #{contract_amount}, " +
            "arrival_memory = #{arrival_memory}, " +
            "teacher_name = #{teacher_name}, " +
            "teacher_num = #{teacher_num}, " +
            "source = #{source}, " +
            "materials = #{materials}, " +
            "update_time = #{update_time} " +
            "WHERE id = #{id}")
    void PutsocFun(SocialWork soc);
    @Update("update social_work set state = #{state} WHERE id = #{id} ")
    void putSocPopFun(SocialWork soc);
    @Delete("DELETE FROM social_work WHERE id = #{id}")
    void deleteSoc(Integer id);

    List<SocialWork> AdminSoclist(String status);

    List<SocialWork> Soclist(String username, String status);
}

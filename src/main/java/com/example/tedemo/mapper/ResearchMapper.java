package com.example.tedemo.mapper;

import com.example.tedemo.pojo.Research;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResearchMapper {
    @Insert("INSERT INTO research_project (project_name, level, organizer, start_date, end_date, teacher_name, teacher_count, teacher_ranking, score, evidence_materials, status, create_time, update_time, username) " +
            "VALUES (#{project_name}, #{level}, #{organizer}, #{start_date}, #{end_date}, #{teacher_name}, #{teacher_count}, #{teacher_ranking}, #{score}, #{evidence_materials}, #{status}, #{create_time}, #{update_time}, #{username})")
    void addRes(Research res);
    @Update("UPDATE research_project " +
            "SET project_name = #{project_name}, " +
            "level = #{level}, " +
            "organizer = #{organizer}, " +
            "start_date = #{start_date}, " +
            "end_date = #{end_date}, " +
            "teacher_name = #{teacher_name}, " +
            "teacher_count = #{teacher_count}, " +
            "teacher_ranking = #{teacher_ranking}, " +
            "score = #{score}, " +
            "evidence_materials = #{evidence_materials}, " +
            "status = #{status}, " +
            "update_time = #{update_time} " +
            "WHERE id = #{id}")
    void PutResFun(Research res);
    @Update("update research_project set status = #{status} WHERE id = #{id} ")
    void putPopFun(Research res);
    @Delete("DELETE FROM research_project WHERE id = #{id}")
    void deleteRes(Integer id);

    List<Research> AdminReslist(String level, String status);

    List<Research> Reslist(String username, String level, String status);
    @Select("select  * from research_project where  id = #{id}")
    Research findByid(Research res);
}

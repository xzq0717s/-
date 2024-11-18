package com.example.tedemo.mapper;

import com.example.tedemo.pojo.TeacherCompetition;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherCompetitionMapper {
    @Insert("INSERT INTO teacher_competition (match_time, project_name, level, category, organizer, award_time, teacher_name, teacher_num, match_ranking, score, evidence_materials, status, create_time, update_time, username) " +
            "VALUES (#{match_time}, #{project_name}, #{level}, #{category}, #{organizer}, #{award_time}, #{teacher_name}, #{teacher_num}, #{match_ranking}, #{score}, #{evidence_materials}, #{status}, #{create_time}, #{update_time}, #{username})")
    void addtea(TeacherCompetition tea);
    @Update("UPDATE teacher_competition SET match_time = #{match_time}, project_name = #{project_name}, level = #{level}, " +
            "category = #{category}, organizer = #{organizer}, award_time = #{award_time}, teacher_name" +
            " = #{teacher_name}, teacher_num = #{teacher_num}, match_ranking = #{match_ranking}, score = #{score}, " +
            "evidence_materials = #{evidence_materials}, status = #{status}, update_time = #{update_time} " +
            "WHERE id = #{id}")
    void PutteaFun(TeacherCompetition tea);
    @Update("update teacher_competition set status = #{status} WHERE id = #{id} ")
    void putPopFun(TeacherCompetition tea);
    @Delete("DELETE FROM teacher_competition WHERE id = #{id}")
    void deletetea(Integer id);

    List<TeacherCompetition> Admintealist(String level, String status);

    List<TeacherCompetition> tealist(String username, String level, String status);
    @Select("select  * from teacher_competition where id = #{id}")
    TeacherCompetition findByid(TeacherCompetition tea);
}

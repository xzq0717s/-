package com.example.tedemo.mapper;

import com.example.tedemo.pojo.StudentCompetition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentCompetitionMapper {
    @Insert("INSERT INTO student_competition (match_time, project_name, level, category, organizer, award_time, participants, instructor, teacher_num, match_ranking, score, evidence_materials, status, create_time, update_time, username) " +
            "VALUES (#{match_time}, #{project_name}, #{level}, #{category}, #{organizer}, #{award_time}, #{participants}, #{instructor}, #{teacher_num}, #{match_ranking}, #{score}, #{evidence_materials}, #{status}, #{create_time}, #{update_time}, #{username})")
    void addstu(StudentCompetition stu);
    @Update("UPDATE student_competition " +
            "SET " +
            "match_time = #{match_time}, " +
            "project_name = #{project_name}, " +
            "level = #{level}, " +
            "category = #{category}, " +
            "organizer = #{organizer}, " +
            "award_time = #{award_time}, " +
            "participants = #{participants}, " +
            "instructor = #{instructor}, " +
            "teacher_num = #{teacher_num}, " +
            "match_ranking = #{match_ranking}, " +
            "score = #{score}, " +
            "evidence_materials = #{evidence_materials}, " +
            "status = #{status}, " +
            "update_time = #{update_time} " +
            "WHERE id = #{id}")
    void PutResFun(StudentCompetition stu);
    @Update("update student_competition set status = #{status} WHERE id = #{id} ")
    void putPopFun(StudentCompetition stu);
    @Delete("DELETE FROM student_competition WHERE id = #{id}")
    void deleteStu(Integer id);

    List<StudentCompetition> AdminStulist(String level, String status);

    List<StudentCompetition> Stulist(String username, String level, String status);
}

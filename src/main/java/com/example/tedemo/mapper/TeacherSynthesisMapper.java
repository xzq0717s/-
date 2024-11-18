package com.example.tedemo.mapper;

import com.example.tedemo.pojo.Pie;
import com.example.tedemo.pojo.TeacherSynthesis;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherSynthesisMapper {
    List<TeacherSynthesis> AdminSynlist(String compositeScoreGrade, String teachingQualityScoreGrade);

    List<TeacherSynthesis> Synlist(String username, String compositeScoreGrade, String teachingQualityScoreGrade);
    @Update("UPDATE teacher_synthesis SET" +
            " Teaching_Level_Score = #{teaching_Level_Score}, Research_Ability_Score = #{research_Ability_Score}, Teaching_Attitude_Score = #{teaching_Attitude_Score}," +
            "Student_Evaluation_Score = #{student_Evaluation_Score} , teacher_name = #{teacher_Name} WHERE id = #{id}")
    void putFun(TeacherSynthesis synth);
    @Select("select * from teacher_synthesis where teacher_name = #{username}")
    TeacherSynthesis findByuser(String username);

    void updataCount(int counts, String prov, String username);
    @Insert("insert into teacher_synthesis (teacher_name,teaching_Level_Score,research_Ability_Score,teaching_Attitude_Score,student_Evaluation_Score,Provincial_Level,National_Level,University_Level,Teaching_Achievements_Count) values " +
            "(#{teacher_Name},#{teaching_Level_Score},#{research_Ability_Score},#{teaching_Attitude_Score},#{student_Evaluation_Score},#{provincial_Level},#{national_Level},#{university_Level},#{teaching_Achievements_Count})")
    void addSynFun(TeacherSynthesis synth);
    @Delete("DELETE FROM teacher_synthesis WHERE id = #{id}")
    void deleteFind(Integer id);
    @Select("SELECT " +
            "SUM(Provincial_Level) AS provincial_Level_Total," +
            "SUM(National_Level) AS total_National_Level," +
            "SUM(University_Level) AS total_University_Level ," +
            "ROUND(AVG(Teaching_Level_Score), 2) AS teaching_Level_ScoreAvg," +
            "ROUND(AVG(Research_Ability_Score), 2) as research_Ability_ScoreAvg ," +
            "ROUND(AVG(Teaching_Attitude_Score), 2) as teaching_Attitude_ScoreAvg," +
            "ROUND(AVG(Student_Evaluation_Score), 2) as student_Evaluation_ScoreAvg " +
            "FROM user_info JOIN   teacher_synthesis ON user_info.nickname = teacher_synthesis.teacher_name")
    Pie selectDataAdminAPi();
    @Select("select " +
            "Provincial_Level as provincial_Level_Total ," +
            " National_Level as total_National_Level , " +
            "University_Level as total_University_Level " +
            ",Teaching_Level_Score as teaching_Level_ScoreAvg ," +
            " Research_Ability_Score as research_Ability_ScoreAvg," +
            "Teaching_Attitude_Score as teaching_Attitude_ScoreAvg ," +
            "Student_Evaluation_Score as student_Evaluation_ScoreAvg " +
            "from teacher_synthesis where teacher_name = #{username}")
    Pie selectDataAPi(String username);
}

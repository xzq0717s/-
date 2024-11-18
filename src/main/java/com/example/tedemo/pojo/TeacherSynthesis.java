package com.example.tedemo.pojo;

import lombok.Data;

@Data
public class TeacherSynthesis {
    Integer id;
    String teacher_Name;
    Integer teaching_Level_Score;
    Integer research_Ability_Score;
    Integer teaching_Attitude_Score;
    Integer student_Evaluation_Score;
    Integer provincial_Level;
    Integer national_Level;
    Integer university_Level;
    Integer teaching_Achievements_Count;
    Double composite_Score;
    Double teaching_Quality_Score;
    String composite_Score_Grade;
    String teaching_Quality_Score_Grade;
}

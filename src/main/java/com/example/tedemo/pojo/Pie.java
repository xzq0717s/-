package com.example.tedemo.pojo;

import lombok.Data;

@Data
public class Pie {
    Integer provincial_Level_Total;
    Integer total_National_Level;
    Integer total_University_Level;
    double teaching_Level_ScoreAvg;
    double research_Ability_ScoreAvg;
    double teaching_Attitude_ScoreAvg;
    double student_Evaluation_ScoreAvg;

}

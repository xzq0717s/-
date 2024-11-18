package com.example.tedemo.pojo;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
@Data
public class StudentCompetition {
    private Integer id;
    private LocalDateTime match_time; // 时间（年月日）
    private String project_name; // 项目名称
    private String level; // 等级（国家、省级、校级）
    private String category; // 类别（一类、二类、三类）
    private String organizer; // 主办单位
    private LocalDateTime award_time; // 获奖时间
    private String participants; // 参赛学生
    private String instructor; // 指导老师
    private Integer teacher_num; // 教师数量
    private Integer match_ranking; // 获奖排名
    private Double score; // 得分
    private String evidence_materials; // 佐证材料（jpg图片）
    private String status; // 状态（待审核、已审核、作废）
    private LocalDateTime create_time; // 创建时间
    private LocalDateTime update_time; // 更新时间
    private String username; // 用户名
}

package com.example.tedemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class Research {
//    @NonNull
    private Integer id;
    private String project_name;
    private String level;
    private String organizer;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime start_date;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime end_date;
    private String teacher_name;
    private Integer teacher_count;
    private Integer teacher_ranking;
    private Double score;
    private String evidence_materials;
    private String status;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private String username;

}

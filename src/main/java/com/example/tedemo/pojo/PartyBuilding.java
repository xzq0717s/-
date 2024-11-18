package com.example.tedemo.pojo;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class PartyBuilding {

    private Integer id;
    private String project_name;
    private String teacher_name;
    private Double score;
    private String evidence_materials;
    private String status;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private String username;
}

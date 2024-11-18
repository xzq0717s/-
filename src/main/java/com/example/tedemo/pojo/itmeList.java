package com.example.tedemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class itmeList {
    private Integer id;
    private String itemName;
    private String category;
    private String pratTeacher;
    private double money;
    private Integer score;
    private String materials;
    private String state;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime update_time;
    private String item_class;

}

package com.example.tedemo.pojo;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
@Data
public class SocialWork {

    private Integer id;
    private String username;
    private String item_name;
    private String first_name;
    private LocalDateTime sign_time;
    private Double contract_amount;
    private Double arrival_memory;
    private String teacher_name;
    private Integer teacher_num;
    private Double source;
    private String materials;
    private String state;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}

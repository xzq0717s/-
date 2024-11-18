package com.example.tedemo.pojo;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
@Data
public class Teaching {

    private Integer id;
    private String username;
    private String teacher_name;
    private Double source;
    private String state;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
}

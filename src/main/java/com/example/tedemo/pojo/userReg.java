package com.example.tedemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class userReg {

    @NonNull
    private Integer id;
    @NotNull
    private String jobid;
//    @JsonIgnore //接口忽略掉得意思
    @NotNull
    private String password;
    private String nickname;
    @NonNull
    @Pattern(regexp = "^\\d{1,11}$")
    private String phone;
    @NonNull
    private String office;
    private String Power;
    private String role;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime update_time;

    public userReg() {
        // 无参构造函数
    }


}

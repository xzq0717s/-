package com.example.tedemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
@Data
public class user_info  {

    @NonNull
    private Integer id;
    private String jobid;
    @JsonIgnore //接口忽略掉得意思
    private String password;
    private String nickname;
    @NonNull
    @Pattern(regexp = "^\\d{1,11}$",groups = {registerNew.class,login.class})
    private String phone;
    @NonNull
    private String office;
    private String Power;
    private String role;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime update_time;

    public user_info() {
        // 无参构造函数
    }

    public interface registerNew{

    }
    public interface login{

    }
}

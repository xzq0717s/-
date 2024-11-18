package com.example.tedemo.pojo;

import lombok.Data;
import lombok.NonNull;

@Data
public class PassWord {
    @NonNull
    private String lowPassWord;
    @NonNull
    private String newPassWord;
    @NonNull
    private String rePassWord;
}

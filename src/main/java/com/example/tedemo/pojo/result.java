package com.example.tedemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class result <T>{
    private Integer code;
    private String massage;
    private T data;
    private T power;
    public static <E> result <E> success(E data ){
        return new result<>(0,"操作成功",data,null);
    }
    public static <E> result <E> success(E data , E power){
        return new result<>(0,"操作成功",data,power);
    }
    public static result success(){
        return new result(0,"操作成功",null,null);

    }
    public static result error (String message){
        return new result(500,message,null,null);
    }

}

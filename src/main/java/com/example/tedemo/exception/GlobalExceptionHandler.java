package com.example.tedemo.exception;

import com.example.tedemo.pojo.result;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public result handleException(Exception e){
        e.printStackTrace();
        return result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败或者权限不足");

    }

}

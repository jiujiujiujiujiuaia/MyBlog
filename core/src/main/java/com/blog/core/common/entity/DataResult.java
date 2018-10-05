package com.blog.core.common.entity;

import lombok.Data;

@Data
public class DataResult<T> {
    private String message;
    private Integer status;
    private T data;

    private DataResult(String message,T data){
        this.message = message;
        this.data = data;
        this.status = 200;
    }

    private DataResult(String message,int code){
        this.message = message;
        this.status = code;
    }

    private DataResult(String message){
        this.message = message;
        this.status = 200;
    }

    public static DataResult success(String message,Object data){
        return new DataResult<>(message,data);
    }

    public static DataResult success(String message){
        return new DataResult(message);
    }
    public static DataResult error(String message){
        return new DataResult(message);
    }
}

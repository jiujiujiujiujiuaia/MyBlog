package com.blog.core.enums;

public enum CommentStatus {

    VERIFYING(1),
    APPROVED(2),
    REJECT(3),
    DELETED(4);
    private int code;
    CommentStatus(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }

}

package com.blog.core.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasePageRequest implements Serializable {
    private final int DEFAULT_PAGESIZE = 10;
    private int pageNumber=1;
    private int pageSize=0;
    private int pageStart=0;

    public int getPageSize(){
        return pageSize>0?pageSize:DEFAULT_PAGESIZE;
    }
    public int getPageStart(){
        int result = getPageSize()*(pageStart-1);
        return result>0?result:0;
    }

}

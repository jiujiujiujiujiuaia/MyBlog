package com.blog.core.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BasePo implements Serializable {
    private Long id;

    private Date createTime;
    private Date updateTime;
}

package com.blog.core.po;

import com.blog.core.common.entity.BasePo;
import lombok.Data;

@Data
public class TagPo extends BasePo {
    private Long id;
    private String name;
    private String description;
}

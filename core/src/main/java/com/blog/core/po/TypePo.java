package com.blog.core.po;

import com.blog.core.common.entity.BasePo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TypePo extends BasePo {
    private Long pid;
    private String name;
    private String description;
    private Integer sort;
    private Boolean available;
    private String icon;

    private TypePo parent;
    private List<TypePo> nodes=new ArrayList<>();
}

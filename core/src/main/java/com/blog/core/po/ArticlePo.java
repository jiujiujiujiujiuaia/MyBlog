package com.blog.core.po;

import com.blog.core.common.entity.BasePo;
import lombok.Data;

import javax.persistence.Transient;
import java.util.List;

@Data
public class ArticlePo extends BasePo {

    List<TagPo> tags ;
    private String title;
    private Long userId;
    private String user;
    private String coverImage;
    private String content;
    private String contentMd;
    private Boolean isMarkdown;
    private Integer typeId;
    private String description;
    private Boolean comment;
    private String typeName;

    private String qrcodePath;
    private Boolean top;
    private Integer status;
    private Boolean recommended;
    private Boolean original;
    private String keywords;

    //@Transient
    private Integer lookCount;
    //@Transient
    private Integer commentCount;
    //@Transient
    private Integer loveCount;

    private String typeDescription;



}

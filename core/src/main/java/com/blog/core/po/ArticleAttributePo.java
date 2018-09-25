package com.blog.core.po;


import lombok.Data;

@Data
public class ArticleAttributePo {
    private Long articleId;
    //@Transient
    private Integer lookCount;
    //@Transient
    private Integer commentCount;
    //@Transient
    private Integer loveCount;
}

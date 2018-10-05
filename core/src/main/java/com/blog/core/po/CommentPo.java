package com.blog.core.po;

import com.blog.core.common.entity.BasePo;
import lombok.Data;

@Data
public class CommentPo extends BasePo {

    private CommentPo parent;

    private Long userId;
    private Long sid;
    private Long pid;
    private String qq;
    private String nickname;
    private String avatar;
    private String email;
    private String url;
    private int status;
    private String ip;
    private String lng;
    private String lat;
    private String address;
    private String os;
    private String osShortName;
    private String browser;
    private String browserShortName;
    private String content;
    private String remark;
    private Integer support;
    private Integer oppose;
    private String createTimeString;
}

package com.blog.core.po;

import com.blog.core.common.entity.BasePo;
import lombok.Data;

import java.util.Date;
@Data
public class ConfigPo extends BasePo {
    private String homeDesc;
    private String homeKeywords;
    private String domain;
    private String cmsUrl;
    private String siteUrl;
    private String siteName;
    private String siteDesc;
    private String siteFavicon;

    private String staticWebSite;
    private String authorName;
    private String authorEmail;

    private String wxCode;
    private String qq;
    private String weibo;
    private String github;
    private Boolean maintenance;
    private Date maintenanceData;
    private Boolean comment;

    private String qiuniuBasePath;
    private String qiniuAccessKey;
    private String qiniuSecretKey;
    private String qiniuBucketName;


    private String baiduPushToken;
    /**
     * 赞赏码
     */
    private String wxPraiseCode;
    private String zfbPraiseCode;
    /**
     * 百度api授权AK(获取地址：http://lbsyun.baidu.com/apiconsole/key)
     * 调用百度的api时必须
     */
    private String baiduApiAk;
}

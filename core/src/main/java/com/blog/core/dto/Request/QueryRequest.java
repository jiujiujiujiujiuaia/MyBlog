package com.blog.core.dto.Request;

import com.blog.core.common.entity.BasePageRequest;
import lombok.Data;

@Data
public class QueryRequest extends BasePageRequest {
    private int tagId;
    private int typeId;
    private int articleId;
    private String keyword;
    private Boolean recommended;
    private Boolean original;
    private Boolean random;
    private String url;
}

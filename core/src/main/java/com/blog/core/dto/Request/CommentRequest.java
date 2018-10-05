package com.blog.core.dto.Request;

import com.blog.core.common.entity.BasePageRequest;
import lombok.Data;

@Data
public class CommentRequest extends BasePageRequest {
    private Long sid;
}

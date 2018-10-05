package com.blog.web.Controller;

import com.blog.core.common.entity.DataResult;
import com.blog.core.dto.Request.CommentRequest;
import com.blog.core.po.CommentPo;
import com.blog.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;


@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService service;

    @RequestMapping("/comments")
    public DataResult getComment(CommentRequest request){
        return DataResult.success(null,service.getComments(request));
    }

    @PostMapping("/comment")
    public DataResult publishComment(CommentPo commentPo){
        service.publishComment(commentPo);
        return DataResult.success("发表成功");
    }
}

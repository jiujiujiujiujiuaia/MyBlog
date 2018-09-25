package com.blog.core.service;

import com.blog.core.dao.ArticleDao;
import com.blog.core.dto.Request.QueryRequest;
import com.blog.core.po.ArticleAttributePo;
import com.blog.core.po.ArticlePo;
import com.blog.core.po.TagPo;
import com.blog.core.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao dao;

    public Model getIndex(QueryRequest request, Model model){
        int start = (request.getPageNumber()-1)*request.getPageSize();
        int last = request.getPageNumber()*request.getPageSize();
        List<ArticlePo> articles = dao.getArticleList(request);
        if(articles.size()>0) {
            int total = articles.size();
            if(articles.size()>request.getPageSize()){
                if(total>start&&total<last){
                    last = total ;
                }
                articles = articles.subList(start,last);
            }
            List<Long> ids = articles.stream().map(ArticlePo::getId).collect(Collectors.toList());
            List<ArticleAttributePo> articleAttributePos = dao.getAttributeByIds(ids);
            PageHelper<ArticlePo> pageInfo = new PageHelper(total, request.getPageNumber(), request.getPageSize(), articles);
            buildParam(pageInfo.getList(),articleAttributePos);
            model.addAttribute("page",pageInfo);
            model.addAttribute("url",request.getUrl());
        }
        return model;
    }

    public Model getArticle(Long articleId,Model model){
        List<ArticlePo> articles = new ArrayList<>();
        List<TagPo> tagPos = dao.getTagByArticleId(articleId);
        List<ArticleAttributePo> articleAttributePos = dao.getAttributeByIds(Arrays.asList(articleId));
        ArticlePo article = dao.getArticleById(articleId);
        article.setTags(tagPos);

        articles.add(article);
        buildParam(articles,articleAttributePos);
        model.addAttribute("article",articles.get(0));
        return model;
    }

    public void buildParam(List<ArticlePo> articles,List<ArticleAttributePo> attributes){
        articles.forEach(p->{
            ArticleAttributePo attribute = attributes.stream().filter(n->n.getArticleId()
                    .equals(p.getId())).findFirst().orElse(null);
            if(attribute!=null){
                if(attribute.getCommentCount()!=null){
                    p.setCommentCount(attribute.getCommentCount());
                }
                if(attribute.getLookCount()!=null){
                    p.setLookCount(attribute.getLookCount());
                }
                if(attribute.getLoveCount()!=null){
                    p.setLoveCount(attribute.getLoveCount());
                }
            }
        });
    }
}

package com.blog.core.service;

import com.blog.core.dao.ArticleDao;
import com.blog.core.dto.Request.CommentRequest;
import com.blog.core.dto.Request.QueryRequest;
import com.blog.core.enums.CommentStatus;
import com.blog.core.po.ArticleAttributePo;
import com.blog.core.po.ArticlePo;
import com.blog.core.po.CommentPo;
import com.blog.core.po.TagPo;
import com.blog.core.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao dao;

    //这里的分页还要完善（https://juejin.im/entry/59195dd744d904006c6dd7c1）
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
        //插入一条浏览量
        dao.insert(articleId);
        return model;
    }

    public Map<String,Object> getComments(CommentRequest request){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap<String,Object> map = new HashMap<>();
        int start = (request.getPageNumber()-1) * request.getPageSize();
        int last = request.getPageNumber() * request.getPageSize();
        List<CommentPo> commentPos = dao.getComments(request.getSid());
        int total = commentPos.size();
        if(total>0){
            if(total>request.getPageSize()) {
                if (total < last && total > start) {
                    last = total;
                }
                commentPos = commentPos.subList(start, last);
            }
           commentPos.forEach(p->{
                   p.setCreateTimeString(simpleDateFormat.format(p.getCreateTime()));
           });
            PageHelper<CommentPo> pageHelper = new PageHelper(total,request.getPageNumber(),request.getPageSize(),commentPos);
            if(pageHelper!=null){
                map.put("commentList", pageHelper.getList());
                map.put("total", pageHelper.getTotal());
                map.put("hasNextPage", pageHelper.isHasNextPage());
                map.put("nextPage", pageHelper.getNextPage());
            }
        }
        return map;
    }

    public void publishComment(CommentPo commentPo){
        Pattern pattern = Pattern.compile("<p>(.*)</p>");
        Matcher matcher = pattern.matcher(commentPo.getContent());
        if(matcher.find()){
            commentPo.setContent(matcher.group(1));
        }
        commentPo.setStatus(CommentStatus.APPROVED.getCode());
        commentPo.setCreateTime(new Date());
        commentPo.setUpdateTime(new Date());
        dao.insertComments(commentPo);
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

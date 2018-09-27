package com.blog.core.dao;

import com.blog.core.dto.Request.QueryRequest;
import com.blog.core.po.ArticleAttributePo;
import com.blog.core.po.ArticlePo;
import com.blog.core.po.TagPo;
import com.blog.core.po.TypePo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;


import java.util.List;

@Mapper
public interface ArticleDao {

    List<ArticlePo> getArticleList(QueryRequest request);

    List<TagPo> getAllTag();

    List<TypePo> getAllType();

    List<TagPo> getTagByArticleId(@Param("articleId")Long articleId);

    List<ArticleAttributePo> getAttributeByIds(List<Long> articleIds);

    ArticlePo getArticleById(@Param("id")Long id);

    void insert(@Param("id")Long id);
}

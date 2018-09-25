package com.blog.core.dao;

import com.blog.core.po.CommentPo;
import com.blog.core.po.TagPo;
import com.blog.core.po.TypePo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface FrontComponentDao {

    List<TagPo> getAllTag();

    List<TypePo> getAllType();

    Page<CommentPo> getComment(@Param("status") int status, RowBounds rowBounds);


}

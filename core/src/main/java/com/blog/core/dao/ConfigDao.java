package com.blog.core.dao;

import com.blog.core.po.ConfigPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfigDao {
    ConfigPo get();
}

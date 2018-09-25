package com.blog.core.service;

import com.blog.core.dao.FrontComponentDao;
import com.blog.core.enums.CommentStatus;
import com.blog.core.po.CommentPo;
import com.blog.core.po.TagPo;
import com.blog.core.po.TypePo;
import com.blog.core.util.BeanMap;
import com.github.pagehelper.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
为前端页面自定义的标签返回值
 */

@Service
public class FrontComponentService {
    @Autowired
    private FrontComponentDao dao;

    public List<TypePo> getTypes(){
        List<TypePo> types= dao.getAllType();
        if(types.size()>0){
            HashMap<Object,TypePo> map = new HashMap<>();
            types.forEach(p->{
                if(p.getPid() == null){
                    map.put(p.getId(),p);
                }
            });
            if(map.size() != types.size()){
                types.forEach(p->{
                    if(p.getPid()!=null){
                        map.get(p.getPid()).getNodes().add(p);
                    }
                });
            }
            return BeanMap.mapToList(map);
        }
        return null ;
    }

    public List<TagPo> getTag(){
        return dao.getAllTag();
    }

    public List<CommentPo> getComment(int pageSize){
        RowBounds rowBounds = new RowBounds(0,pageSize);
        List<CommentPo> result = new ArrayList<>();
        Page<CommentPo> page = dao.getComment(CommentStatus.APPROVED.getCode(),rowBounds);
        if(page!=null){
            result = page.getResult();
        }
        return result;

    }




}

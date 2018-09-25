package com.blog.core.service;

import com.blog.core.dao.ConfigDao;
import com.blog.core.po.ConfigPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    @Autowired
    private ConfigDao dao;

    public ConfigPo get(){
        return dao.get();
    }

}

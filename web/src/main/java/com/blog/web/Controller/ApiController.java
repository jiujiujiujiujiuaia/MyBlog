package com.blog.web.Controller;

import com.blog.core.common.entity.DataResult;
import com.blog.core.service.ApiService;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ApiService service;

    @RequestMapping("/qq/{qq}")
    public DataResult getInfoByQq(@PathVariable("qq")String qq) throws UnirestException {
        return DataResult.success(null, service.qqApi(qq));
    }

}

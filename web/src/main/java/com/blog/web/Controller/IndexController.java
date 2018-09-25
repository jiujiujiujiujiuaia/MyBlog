package com.blog.web.Controller;

import com.blog.core.dao.ArticleDao;
import com.blog.core.dto.Request.QueryRequest;
import com.blog.core.service.ArticleService;
import com.blog.core.util.CheckParam;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @Autowired
    private ArticleService service;

    @RequestMapping(value={"/index","/index/{pageNumber}"})
    public ModelAndView index(QueryRequest request, @PathVariable(value="pageNumber",required = false)Integer pageNumber, Model model){
        CheckParam checkParam = new CheckParam();
        checkParam.buildPageNumber(pageNumber).build(request);
        request.setUrl("index");
        model = service.getIndex(request,model);
        return new ModelAndView("index");
    }

    @RequestMapping(value={"/tag/{tagId}","/tag/{tagId}/{pageNumber}"})
    public ModelAndView findPageByTag(Model model,QueryRequest request,@PathVariable(value="tagId")Integer tagId,
                                      @PathVariable(value="pageNumber",required = false)Integer pageNumber){
        CheckParam checkParam = new CheckParam();
        checkParam.buildTagId(tagId).buildPageNumber(pageNumber).build(request);

        model = service.getIndex(request,model);
        return new ModelAndView("index");
    }
    @RequestMapping(value={"/type/{typeId}","/type/{typeId}/{pageNumber}"})
    public ModelAndView findPageByType(Model model,QueryRequest request,@PathVariable(value="typeId") Integer typeId,
                                       @PathVariable(value="pageNumber",required = false)Integer pageNumber){
        CheckParam checkParam = new CheckParam();
        checkParam.buildTypeId(typeId).buildPageNumber(pageNumber).build(request);

        model = service.getIndex(request,model);
        return new ModelAndView("index");
    }
    @RequestMapping(value="/article/{articleId}")
    public ModelAndView getArticle(Model model,@PathVariable("articleId")Long id){
        model = service.getArticle(id,model);
        return new ModelAndView("article");
    }




}

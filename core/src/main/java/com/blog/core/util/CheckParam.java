package com.blog.core.util;

import com.blog.core.dto.Request.QueryRequest;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


public class CheckParam {
        private Integer tagId ;
        private Integer typeId ;
        private String keyword;
        private Integer pageNumber;

        public CheckParam buildTypeId(Integer typeId) {
            if (typeId != null) {
                this.typeId = typeId;
            }
            return this;
        }

        public CheckParam buildTagId(Integer tagId) {
            if (tagId != null) {
                this.tagId = tagId;
            }
            return this;
        }

        public CheckParam buildKeyword(String keyword) {
            if (keyword != null) {
                this.keyword = keyword;
            }
            return this;
        }
        public CheckParam buildPageNumber(Integer pageNumber){
            if (pageNumber !=null){
                this.pageNumber = pageNumber;
            }
            return this;
        }
        public void build(QueryRequest request){
            if(this.tagId!=null){
                request.setTagId(this.tagId);
                request.setUrl("tag/"+this.tagId);
            }
            else if(this.keyword!=null){
                request.setKeyword(this.keyword);
            }
            else if(this.typeId!=null){
                request.setTypeId(this.typeId);
                request.setUrl("type/"+this.typeId);
            }
            else if(this.pageNumber!=null){
                request.setPageNumber(this.pageNumber);

            }
        }
    }


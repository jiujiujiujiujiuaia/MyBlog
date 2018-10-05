package com.blog.core.util;

import lombok.Data;

import java.util.List;

@Data
public class PageHelper<T> {
    private int total;
    //结果集合
    private List<T> list;
    //总页数
    private int pages;
    //是否有前一页
    private boolean hasPreviousPage;
    //是否有后一页
    private boolean hasNextPage;
    //前一页
    private int prePage;
    //后一页
    private int nextPage;
    //当前页
    private int pageNum;
    public PageHelper(int total,int currentPage,int limit,List<T> list) {
         if (total > 0) {
             this.total = total;
             this.list = list;
             this.pages = total % limit>0 ? total/limit+1:total/limit;
             pageNum = currentPage;
             if(pages == 1){
                 hasNextPage = false;
                 hasPreviousPage = false;
             }
             else if (currentPage == 1) {
                 hasPreviousPage = false;
                 hasNextPage = true;
                 nextPage = currentPage + 1;
             } else if (currentPage == pages) {
                 hasNextPage = false;
                 hasPreviousPage = true;
                 prePage = currentPage - 1;
             } else {
                 hasPreviousPage = true;
                 hasNextPage = true;
                 prePage = currentPage - 1;
                 nextPage = currentPage + 1;
             }
         }
     }

}

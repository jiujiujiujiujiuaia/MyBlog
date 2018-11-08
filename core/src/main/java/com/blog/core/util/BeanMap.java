package com.blog.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class  BeanMap<T> {

    public static <T> List<T> mapToList(HashMap<Object,T> map){
        List<T> list = new ArrayList<>();
        for(T value: map.values()){
            list.add(value);
        }
        return list;
    }

}

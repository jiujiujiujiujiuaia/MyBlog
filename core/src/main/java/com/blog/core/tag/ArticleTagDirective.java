package com.blog.core.tag;

import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class ArticleTagDirective implements TemplateDirectiveModel {
    private static final String METHOD_KEY = "method";
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
        if (map.containsKey(METHOD_KEY)) {
            String method = map.get(METHOD_KEY).toString();
            int pageSize = 10;
            if (map.containsKey("pageSize")) {
                String pageSizeStr = map.get("pageSize").toString();
                pageSize = Integer.parseInt(pageSizeStr);
            }
        }
        templateDirectiveBody.render(environment.getOut());
    }
}

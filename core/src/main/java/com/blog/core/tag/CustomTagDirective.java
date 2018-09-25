package com.blog.core.tag;


import com.blog.core.service.FrontComponentService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class CustomTagDirective implements TemplateDirectiveModel {
    public static final String METHOD_KEY = "method";

    @Autowired
    private FrontComponentService frontComponentService;
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
            long typeId = -1;
            if (map.containsKey("typeId")) {
                String typeStr = map.get("typeId").toString();
                typeId = Long.parseLong(typeStr);
            }
            switch (method){
                case "types":
                    environment.setVariable("types", builder.build().wrap(frontComponentService.getTypes()));
                    break;
                case "tagsList":
                    environment.setVariable("tagsList",builder.build().wrap(frontComponentService.getTag()));
                    break;
                case "recentComments":
                    environment.setVariable("recentComments",builder.build().wrap(frontComponentService.getComment(pageSize)));
            }
        }
        templateDirectiveBody.render(environment.getOut());
    }
}

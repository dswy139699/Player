package com.publiccms.views.directive.home;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.common.base.AbstractTemplateDirective;
import com.publiccms.common.handler.RenderHandler;
import com.publiccms.common.tools.CommonUtils;
import com.publiccms.entities.home.HomeUser;
import com.publiccms.logic.service.home.HomeUserService;

/**
 *
 * HomeUserDirective
 * 
 */
@Component
public class HomeUserDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        if (CommonUtils.notEmpty(id)) {
            handler.put("object", service.getEntity(id)).render();
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (CommonUtils.notEmpty(ids)) {
                List<HomeUser> entityList = service.getEntitys(ids);
                Map<String, HomeUser> map = new LinkedHashMap<>();
                for (HomeUser entity : entityList) {
                    map.put(String.valueOf(entity.getUserId()), entity);
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private HomeUserService service;

}

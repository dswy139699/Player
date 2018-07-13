package com.publiccms.views.directive.tools;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.common.base.AbstractTemplateDirective;
import com.publiccms.common.handler.RenderHandler;
import com.publiccms.common.tools.CommonUtils;
import com.publiccms.logic.component.template.MetadataComponent;

/**
 *
 * MetadataDirective
 * 
 */
@Component
public class MetadataDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        String path = handler.getString("path");
        String dir = handler.getString("dir");
        if (CommonUtils.notEmpty(path) && !path.endsWith(SEPARATOR)) {
            handler.put("object",
                            metadataComponent.getTemplateMetadata(siteComponent.getWebTemplateFilePath(getSite(handler), path)))
                    .render();
        } else if (null != dir) {
            handler.put("object", metadataComponent.getTemplateMetadataMap(siteComponent.getWebTemplateFilePath(getSite(handler), dir)))
                    .render();
        }
    }
    
    @Override
    public boolean needAppToken() {
        return true;
    }

    @Autowired
    private MetadataComponent metadataComponent;
}

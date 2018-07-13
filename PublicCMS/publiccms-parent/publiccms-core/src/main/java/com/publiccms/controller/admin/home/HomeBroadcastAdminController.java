package com.publiccms.controller.admin.home;

// Generated 2016-11-13 11:38:14 by com.publiccms.common.source.SourceGenerator

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.publiccms.common.base.AbstractController;
import com.publiccms.common.tools.CommonUtils;
import com.publiccms.common.tools.ControllerUtils;
import com.publiccms.common.tools.JsonUtils;
import com.publiccms.common.tools.RequestUtils;
import com.publiccms.entities.home.HomeBroadcast;
import com.publiccms.entities.log.LogOperate;
import com.publiccms.entities.sys.SysSite;
import com.publiccms.logic.service.home.HomeBroadcastService;
import com.publiccms.logic.service.log.LogLoginService;

/**
 *
 * HomeBroadcastAdminController
 * 
 */
@Controller
@RequestMapping("homeBroadcast")
public class HomeBroadcastAdminController extends AbstractController {

    /**
     * @param id
     * @param request
     * @param session
     * @param model
     * @return view name
     */
    @RequestMapping(value = "enable", method = RequestMethod.POST)
    public String enable(Long id, HttpServletRequest request, HttpSession session, ModelMap model) {
        if (ControllerUtils.verifyEquals("admin.operate", getAdminFromSession(session).getId(), id, model)) {
            return TEMPLATE_ERROR;
        }
        HomeBroadcast entity = service.getEntity(id);
        if (null != entity) {
            SysSite site = getSite(request);
            if (ControllerUtils.verifyNotEquals("siteId", site.getId(), entity.getSiteId(), model)) {
                return TEMPLATE_ERROR;
            }
            service.updateStatus(id, false);
            logOperateService
                    .save(new LogOperate(site.getId(), getAdminFromSession(session).getId(), LogLoginService.CHANNEL_WEB_MANAGER,
                            "enable.home.broadcast", RequestUtils.getIpAddress(request), CommonUtils.getDate(), JsonUtils.getString(entity)));
        }
        return TEMPLATE_DONE;
    }

    /**
     * @param id
     * @param request
     * @param session
     * @param model
     * @return view name
     */
    @RequestMapping(value = "disable", method = RequestMethod.POST)
    public String disable(Long id, HttpServletRequest request, HttpSession session, ModelMap model) {
        if (ControllerUtils.verifyEquals("admin.operate", getAdminFromSession(session).getId(), id, model)) {
            return TEMPLATE_ERROR;
        }
        HomeBroadcast entity = service.getEntity(id);
        if (null != entity) {
            SysSite site = getSite(request);
            if (ControllerUtils.verifyNotEquals("siteId", site.getId(), entity.getSiteId(), model)) {
                return TEMPLATE_ERROR;
            }
            service.updateStatus(id, true);
            logOperateService
                    .save(new LogOperate(site.getId(), getAdminFromSession(session).getId(), LogLoginService.CHANNEL_WEB_MANAGER,
                            "disable.home.broadcast", RequestUtils.getIpAddress(request), CommonUtils.getDate(), JsonUtils.getString(entity)));
        }
        return TEMPLATE_DONE;
    }

    @Autowired
    private HomeBroadcastService service;
}
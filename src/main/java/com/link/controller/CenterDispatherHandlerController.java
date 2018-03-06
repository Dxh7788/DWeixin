package com.link.controller;

import com.link.service.CenterDispatherHandlerService;
import com.link.util.XmlUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 12:49
 */
@RestController
@RequestMapping("/darticle")
public class CenterDispatherHandlerController {
    //中心分发器
    @Autowired
    HttpServletRequest request;
    @Autowired
    CenterDispatherHandlerService centerDispatherHandlerService;
    @RequestMapping(method = RequestMethod.POST)
    public Boolean centerDispatchHandler(){
        boolean bvalue = false;
        try {
            centerDispatherHandlerService.dispatcher(XmlUtils.parseXml(request));
            bvalue =true;
        } catch (Exception e){
            bvalue = false;
            e.printStackTrace();
        }
        return bvalue;
    }
    @RequestMapping(method = RequestMethod.GET)
    public void doGet(){

    }
}

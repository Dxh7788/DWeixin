package com.link.controller;

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
@RequestMapping("/dispatcher")
public class CenterDispatherHandlerController {
    //中心分发器
    @Autowired
    HttpServletRequest request;
    @RequestMapping(value = "/to",method = RequestMethod.GET)
    public Boolean centerDispatchHandler(){
        return null;
    }
}

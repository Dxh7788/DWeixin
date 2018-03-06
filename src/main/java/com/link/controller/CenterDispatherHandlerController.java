package com.link.controller;

import com.link.service.CenterDispatcherHandlerService;
import com.link.util.SignUtil;
import com.link.util.XmlUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    HttpServletResponse response;
    @Autowired
    CenterDispatcherHandlerService centerDispatherHandlerService;
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
    public void validate(){
        String signature = request.getParameter("signature".trim());
        // 时间戳
        String timestamp = request.getParameter("timestamp".trim());
        // 随机数
        String nonce = request.getParameter("nonce".trim());
        // 随机字符串
        String echostr = request.getParameter("echostr".trim());
        boolean access = SignUtil.checkSignature(signature,timestamp,nonce);
        PrintWriter out = null;
		try {
            out = response.getWriter();
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            out = null;
        }
    }
}

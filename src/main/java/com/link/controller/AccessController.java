package com.link.controller;

import com.link.form.bo.response.AccessToken;
import com.link.util.ConvertUtil;
import com.link.util.IOUtil;
import com.link.util.SignUtil;
import com.link.weixin.AccessConfig;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 10:35
 */
@RestController
@RequestMapping("/access")
public class AccessController {
    @Autowired
    HttpServletRequest request;
    //校验
    @RequestMapping(value = "/validate")
    public Boolean validate(){
        String signature = request.getParameter("signature ");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        boolean access = SignUtil.checkSignature(signature,timestamp,nonce);
        return access;
    }
    //获取access_token
    @RequestMapping(value = "/access_token",method = RequestMethod.GET)
    public AccessToken getAccessToken(){
        String tecentUrl = AccessConfig.APP_URL+"?grant_type=client_credential&appid="+AccessConfig.APP_ID+"&secret="+AccessConfig.APP_SECRET;
        AccessToken accessToken = new AccessToken();
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(tecentUrl);
            HttpResponse response =client.execute(request);
            InputStream input = response.getEntity().getContent();
            String jsonString  = IOUtil.getJsonStringFromGZIP(input);
            accessToken = ConvertUtil.converStrToAccessToken(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
        return accessToken;
    }
}

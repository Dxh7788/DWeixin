package com.link.util;

import com.link.form.bo.response.AccessToken;
import com.link.weixin.AccessConfig;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 16:26
 */
public class HttpUtils {
    //获取access_token
    public static AccessToken accessToken(){
        String url = AccessConfig.APP_URL+"?grant_type=client_credential&appid="+AccessConfig.APP_ID+"&secret="+AccessConfig.APP_SECRET;
        AccessToken accessToken = new AccessToken();
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response =client.execute(request);
            InputStream input = response.getEntity().getContent();
            String jsonString  = IOUtil.getJsonStringFromGZIP(input);
            accessToken = ConvertUtil.converStrToAccessToken(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
        return accessToken;
    }
    public static void sendPostBuffer(String url, String s) {
        HttpClient client = HttpClientBuilder.create().build();
        StringEntity entity = new StringEntity(s, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");

        HttpPost post = new HttpPost(url);
        post.setHeader("Content-type", "application/json; charset=utf-8");

        post.setEntity(entity);
        try {
            HttpResponse response =client.execute(post);
            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK){
                System.out.println("=================成功======================");
            }else {
                System.out.println("=================失败======================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(post != null){
                try {
                    post.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

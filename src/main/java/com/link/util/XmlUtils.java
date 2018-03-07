package com.link.util;

import com.link.constants.TypeConstants;
import com.link.form.base.response.BaseResponseMessage;
import com.link.form.base.response.TextResponseMessage;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 解析工具
 * @author xh.d
 * @since 2018/3/6 12:53
 */
public class XmlUtils {
    //解析request中的xml请求
    public static Map<String,String> parseXml(HttpServletRequest request) throws Exception{
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // document.selectSingleNode("//")
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }
    //包装response的数据为xml
    public static String wrapperXml(BaseResponseMessage message){
        StringBuffer sb = new StringBuffer();
        if (StringUtils.equals(message.getMsgType(), TypeConstants.MsgType.TEXT_MSG_TYPE)){
            TextResponseMessage responseMessage = (TextResponseMessage)message;

        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.IMAGE_MSG_TYPE)){

        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.VOICE_MSG_TYPE)){

        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.VIDEO_MSG_TYPE)){

        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.MUSIC_MSG_TYPE)){

        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.NEWS_MSG_TYPE)){

        }
        return null;
    }
}

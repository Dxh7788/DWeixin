package com.link.util;

import com.link.constants.TypeConstants;
import com.link.form.base.response.*;
import com.link.util.xstream.CDATAConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
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
    private static XStream xStream = new XStream(new DomDriver());
    private static CDATAConverter cDataConverter = new CDATAConverter();
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
        xStream.processAnnotations(new Class[]{TextResponseMessage.class, ImageResponseMessage.class, MusicResponseMessage.class,
                NewsResponseMessage.class, TextResponseMessage.class, VideoResponseMessage.class, VoiceResponseMessage.class});
        String str = null;
        xStream.aliasType("xml",BaseResponseMessage.class);
        xStream.registerConverter(cDataConverter);
        if (StringUtils.equals(message.getMsgType(), TypeConstants.MsgType.TEXT_MSG_TYPE)){
            TextResponseMessage responseMessage = (TextResponseMessage)message;
            str = xStream.toXML(responseMessage);
        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.IMAGE_MSG_TYPE)){
            ImageResponseMessage responseMessage = (ImageResponseMessage)message;
            str = xStream.toXML(responseMessage);
        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.VOICE_MSG_TYPE)){
            VoiceResponseMessage responseMessage = (VoiceResponseMessage)message;
            str = xStream.toXML(responseMessage);
        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.VIDEO_MSG_TYPE)){
            VideoResponseMessage responseMessage = (VideoResponseMessage)message;
            str = xStream.toXML(responseMessage);
        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.MUSIC_MSG_TYPE)){
            MusicResponseMessage responseMessage = (MusicResponseMessage)message;
            str = xStream.toXML(responseMessage);
        }else if (StringUtils.equals(message.getMsgType(), TypeConstants.ResponseMsgType.NEWS_MSG_TYPE)){
            NewsResponseMessage responseMessage = (NewsResponseMessage)message;
            str = xStream.toXML(responseMessage);
        }
        if (StringUtils.isNotBlank(str)){
            str = StringEscapeUtils.unescapeXml(str);
        }
        return str;
    }
}

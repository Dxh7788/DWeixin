package com.link.service.impl;

import com.link.constants.TypeConstants;
import com.link.data.form.base.request.*;
import com.link.data.form.base.response.TextResponseMessage;
import com.link.data.form.base.response.VideoResponseMessage;
import com.link.data.form.base.response.meta.Video;
import com.link.service.CommonMessageDispatcherService;
import com.link.util.XmlUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 15:43
 */
@Service
public class CommonMessageDispatcherServiceImpl implements CommonMessageDispatcherService {
    @Autowired
    HttpServletResponse response;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public void dispatcher(Map<String, String> map, BaseRequestMessage message) {
        String content = "欢迎您的关注,感谢长期陪伴";
        String msgType = message.getMsgType();
        if (StringUtils.equals(msgType, TypeConstants.MsgType.TEXT_MSG_TYPE)) {
            //文本消息处理
            content = textMessageDealer(map, message);
            logger.debug("处理文本消息");
        } else if (StringUtils.equals(msgType, TypeConstants.MsgType.IMAGE_MSG_TYPE)) {
            //图片消息处理
            content = imageMessageDealer(map, message);
        } else if (StringUtils.equals(msgType, TypeConstants.MsgType.VOICE_MSG_TYPE)) {
            //音频消息处理
            content = voiceMessageDealer(map, message);
        } else if (StringUtils.equals(msgType, TypeConstants.MsgType.VIDEO_MSG_TYPE)) {
            //视频消息处理
            content = videoMessageDealer(map, message);
        } else if (StringUtils.equals(msgType, TypeConstants.MsgType.LOCATION_MSG_TYPE)) {
            //定位信息处理
            content = locationMessageDealer(map, message);
        } else if (StringUtils.equals(msgType, TypeConstants.MsgType.LINK_MSG_TYPE)) {
            //链接消息处理
            content = linkMessageDealer(map, message);
        }
        try {
            PrintWriter writer = response.getWriter();
            response.setContentType("text/html;charset=utf-8");
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String linkMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        LinkRequestMessage linkRequestMessage = wrapLinkRequestMessage(map, shadowMessage);
        return handleLinkMessage(linkRequestMessage);
    }

    private String locationMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        LocationRequestMessage locationRequestMessage = wrapLocationRequestMessage(map, shadowMessage);
        return handleLocationMessage(locationRequestMessage);
    }

    private String videoMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        VideoRequestMessage videoRequestMessage = wrapVideoRequestMessage(map, shadowMessage);
        return handleVideoMessage(videoRequestMessage);
    }

    private String voiceMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        VoiceRequestMessage voiceRequestMessage = wrapVoiceRequestMessage(map, shadowMessage);
        return handleVoiceMessage(voiceRequestMessage);
    }

    private String imageMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        ImageRequestMessage imageRequestMessage = wrapImageRequestMessage(map, shadowMessage);
        return handleImageMessage(imageRequestMessage);
    }

    private String textMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        TextRequestMessage textRequestMessage = wrapTextRequestMessage(map, shadowMessage);
        return handleTextMessage(textRequestMessage);
    }

    private TextRequestMessage wrapTextRequestMessage(Map<String, String> map, BaseRequestMessage shadowMessage) {
        TextRequestMessage textRequestMessage = new TextRequestMessage(shadowMessage);
        textRequestMessage.setContent(map.get("Content"));
        return textRequestMessage;
    }

    private ImageRequestMessage wrapImageRequestMessage(Map<String, String> map, BaseRequestMessage shadowMessage) {
        ImageRequestMessage imageRequestMessage = new ImageRequestMessage(shadowMessage);
        imageRequestMessage.setPicUrl(map.get("PicUrl"));
        return imageRequestMessage;
    }

    private VoiceRequestMessage wrapVoiceRequestMessage(Map<String, String> map, BaseRequestMessage shadowMessage) {
        VoiceRequestMessage voiceRequestMessage = new VoiceRequestMessage(shadowMessage);
        voiceRequestMessage.setMediaId(map.get("MediaId"));
        voiceRequestMessage.setFormat(map.get("Format"));
        return voiceRequestMessage;
    }

    private VideoRequestMessage wrapVideoRequestMessage(Map<String, String> map, BaseRequestMessage shadowMessage) {
        VideoRequestMessage videoRequestMessage = new VideoRequestMessage(shadowMessage);
        videoRequestMessage.setMediaId(map.get("MediaId"));
        return videoRequestMessage;
    }

    private LocationRequestMessage wrapLocationRequestMessage(Map<String, String> map, BaseRequestMessage shadowMessage) {
        LocationRequestMessage locationRequestMessage = new LocationRequestMessage(shadowMessage);
        locationRequestMessage.setLocationX(Double.valueOf(map.get("Location_X")));
        locationRequestMessage.setLocationY(Double.valueOf(map.get("Location_Y")));
        locationRequestMessage.setLabel(map.get("Label"));
        locationRequestMessage.setScale(Integer.valueOf(map.get("Scale")));
        return locationRequestMessage;
    }

    private LinkRequestMessage wrapLinkRequestMessage(Map<String, String> map, BaseRequestMessage shadowMessage) {
        LinkRequestMessage linkRequestMessage = new LinkRequestMessage(shadowMessage);
        linkRequestMessage.setDescription(map.get("Description"));
        linkRequestMessage.setTitle(map.get("Title"));
        linkRequestMessage.setUrl(map.get("Url"));
        return linkRequestMessage;
    }

    /**
     * 核心处理器
     * */
    //处理链接消息
    private String handleLinkMessage(LinkRequestMessage linkRequestMessage) {
        return null;
    }

    //处理地址消息
    private String handleLocationMessage(LocationRequestMessage locationRequestMessage) {
        return null;
    }
    //处理视频消息
    private String handleVideoMessage(VideoRequestMessage videoRequestMessage) {
        VideoResponseMessage responseMessage = new VideoResponseMessage();
        responseMessage.setFromUserName(videoRequestMessage.getToUserName());
        responseMessage.setToUserName(videoRequestMessage.getFromUserName());
        responseMessage.setCreateTime(new Date());
        Video video = new Video();
        video.setTitle("123");
        video.setDescription("我来自测试DWeixin");
        video.setMediaId(videoRequestMessage.getMediaId());
        responseMessage.setVideo(video);
        responseMessage.setMsgType("video");
        String content = XmlUtils.wrapperXml(responseMessage);
        return content;
    }
    //处理音频消息
    private String handleVoiceMessage(VoiceRequestMessage voiceRequestMessage) {
        return null;
    }
    //处理图片消息
    private String handleImageMessage(ImageRequestMessage imageRequestMessage) {
        return null;
    }
    //处理文本消息
    private String handleTextMessage(TextRequestMessage textRequestMessage) {
        TextResponseMessage responseMessage = new TextResponseMessage();
        responseMessage.setFromUserName(textRequestMessage.getToUserName());
        responseMessage.setToUserName(textRequestMessage.getFromUserName());
        responseMessage.setCreateTime(new Date());
        responseMessage.setContent("我已经收到你的消息,请继续关注我们!谢谢");
        responseMessage.setMsgType("text");
        String content = XmlUtils.wrapperXml(responseMessage);
        return content;
    }
}

package com.link.service.impl;

import com.link.constants.TypeConstants;
import com.link.form.base.request.*;
import com.link.service.CenterDispatherHandlerService;
import com.link.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 把这个改成切面
 * @author xh.d
 * @since 2018/3/6 13:42
 */
@Service
public class CenterDispatherHandlerServiceImpl implements CenterDispatherHandlerService {

    public void dispatcher(Map<String, String> map) {
        BaseRequestMessage message = new BaseRequestMessage();
        try {
            //创建时间
            if (StringUtils.isNotBlank(map.get("CreateTime"))){
                Long timestamp = Long.valueOf(map.get("CreateTime"));
                Date date = new Date(timestamp);
                message.setCreateTime(date);
            }
            //发自用户openid
            String toUserName = map.get("ToUserName");
            //发给用户openid
            String fromUserName = map.get("FromUserName");
            //消息类型
            String msgType = map.get("MsgType");
            //消息id
            String msgId = map.get("MsgId");
            BaseRequestMessage shadowMessage = new BaseRequestMessage(toUserName, fromUserName, message.getCreateTime(), msgType, msgId);
            if (StringUtils.equals(msgType, TypeConstants.MsgType.TEXT_MSG_TYPE)){
                //文本消息处理
                textMessageDealer(map, shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.IMAGE_MSG_TYPE)){
                //图片消息处理
                imageMessageDealer(map, shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.VOICE_MSG_TYPE)){
                //音频消息处理
                voiceMessageDealer(map, shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.VIDEO_MSG_TYPE)){
                //视频消息处理
                videoMessageDealer(map, shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.LOCATION_MSG_TYPE)){
                //定位信息处理
                locationMessageDealer(map, shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.LINK_MSG_TYPE)){
                //链接消息处理
                linkMessageDealer(map, shadowMessage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void linkMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        LinkRequestMessage linkRequestMessage = wrapLinkRequestMessage(map, shadowMessage);
        handleLinkMessage(linkRequestMessage);
    }

    private void locationMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        LocationRequestMessage locationRequestMessage = wrapLocationRequestMessage(map, shadowMessage);
        handleLocationMessage(locationRequestMessage);
    }

    private void videoMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        VideoRequestMessage videoRequestMessage = wrapVideoRequestMessage(map, shadowMessage);
        handleVideoMessage(videoRequestMessage);
    }

    private void voiceMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        VoiceRequestMessage voiceRequestMessage = wrapVoiceRequestMessage(map, shadowMessage);
        handleVoiceMessage(voiceRequestMessage);
    }

    private void imageMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        ImageRequestMessage imageRequestMessage = wrapImageRequestMessage(map, shadowMessage);
        handleImageMessage(imageRequestMessage);
    }

    private void textMessageDealer(Map<String, String> map, BaseRequestMessage shadowMessage) {
        TextRequestMessage textRequestMessage = wrapTextRequestMessage(map, shadowMessage);
        handleTextMessage(textRequestMessage);
    }

    private TextRequestMessage wrapTextRequestMessage(Map<String, String> map, BaseRequestMessage shadowMessage) {
        TextRequestMessage textRequestMessage = new TextRequestMessage(shadowMessage);
        textRequestMessage.setContent(map.get("Content"));
        return textRequestMessage;
    }

    private ImageRequestMessage wrapImageRequestMessage(Map<String, String> map, BaseRequestMessage shadowMessage) {
        ImageRequestMessage imageRequestMessage = new ImageRequestMessage(shadowMessage);
        imageRequestMessage.setUrl(map.get("Url"));
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

    //处理链接消息
    private void handleLinkMessage(LinkRequestMessage linkRequestMessage) {
    }

    //处理地址消息
    private void handleLocationMessage(LocationRequestMessage locationRequestMessage) {
    }
    //处理视频消息
    private void handleVideoMessage(VideoRequestMessage videoRequestMessage) {
    }
    //处理音频消息
    private void handleVoiceMessage(VoiceRequestMessage voiceRequestMessage) {
    }
    //处理图片消息
    private void handleImageMessage(ImageRequestMessage imageRequestMessage) {
    }
    //处理文本消息
    private void handleTextMessage(TextRequestMessage textRequestMessage) {
    }
}

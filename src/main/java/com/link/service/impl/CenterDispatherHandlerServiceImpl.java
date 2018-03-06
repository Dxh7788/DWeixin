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
 *
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
            String msgType = map.get("msgType");
            //消息id
            String magId = map.get("msgId");
            BaseRequestMessage shadowMessage = new BaseRequestMessage(toUserName, fromUserName, message.getCreateTime(),msgType, magId);
            if (StringUtils.equals(msgType, TypeConstants.MsgType.TEXT_MSG_TYPE)){
                TextRequestMessage textRequestMessage = new TextRequestMessage(shadowMessage);
                textRequestMessage.setContent(map.get("Content"));
                handleTextMessage(textRequestMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.IMAGE_MSG_TYPE)){
                ImageRequestMessage imageRequestMessage = new ImageRequestMessage(shadowMessage);
                imageRequestMessage.setUrl(map.get("Url"));
                handleImageMessage(imageRequestMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.VOICE_MSG_TYPE)){
                VoiceRequestMessage voiceRequestMessage = new VoiceRequestMessage(shadowMessage);
                voiceRequestMessage.setMediaId(map.get("MediaId"));
                voiceRequestMessage.setFormat(map.get("Format"));
                handleVoiceMessage(voiceRequestMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.VIDEO_MSG_TYPE)){
                VideoRequestMessage videoRequestMessage = new VideoRequestMessage(shadowMessage);
                videoRequestMessage.setMediaId(map.get("MediaId"));
                handleVideoMessage(videoRequestMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.LOCATION_MSG_TYPE)){
                LocationRequestMessage locationRequestMessage = new LocationRequestMessage(shadowMessage);
                locationRequestMessage.setLocationX(Double.valueOf(map.get("Location_X")));
                locationRequestMessage.setLocationY(Double.valueOf(map.get("Location_Y")));
                locationRequestMessage.setLabel(map.get("Label"));
                locationRequestMessage.setScale(Integer.valueOf(map.get("Scale")));
                handleLocationMessage(locationRequestMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.LINK_MSG_TYPE)){
                LinkRequestMessage linkRequestMessage = new LinkRequestMessage(shadowMessage);
                linkRequestMessage.setDescription(map.get("Description"));
                linkRequestMessage.setTitle(map.get("Title"));
                linkRequestMessage.setUrl(map.get("Url"));
                handleLinkMessage(linkRequestMessage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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

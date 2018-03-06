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
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.IMAGE_MSG_TYPE)){
                ImageRequestMessage imageRequestMessage = new ImageRequestMessage(shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.VOICE_MSG_TYPE)){
                VoiceRequestMessage imageRequestMessage = new VoiceRequestMessage(shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.VIDEO_MSG_TYPE)){
                VideoRequestMessage imageRequestMessage = new VideoRequestMessage(shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.LOCATION_MSG_TYPE)){
                LocationRequestMessage imageRequestMessage = new LocationRequestMessage(shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.LINK_MSG_TYPE)){
                LinkRequestMessage imageRequestMessage = new LinkRequestMessage(shadowMessage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

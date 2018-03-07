package com.link.service.dispatcher.impl;

import com.link.constants.TypeConstants;
import com.link.data.form.base.request.BaseRequestMessage;
import com.link.data.form.base.request.menu.MenuBaseEventMessage;
import com.link.service.dispatcher.CenterDispatcherHandlerService;
import com.link.service.dispatcher.CommonMessageDispatcherService;
import com.link.service.dispatcher.MenuDispatcherService;
import com.link.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 把这个改成切面
 * @author xh.d
 * @since 2018/3/6 13:42
 */
@Service
public class CenterDispatherHandlerServiceImpl implements CenterDispatcherHandlerService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MenuDispatcherService menuDispatcherService;
    @Autowired
    CommonMessageDispatcherService commonMessageDispatcherService;

    public void dispatcher(Map<String, String> map) {
        try {
            String strDate = DateUtil.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss");
            BaseRequestMessage shadowMessage = wrapBaseRequestMessage(map);
            String msgType = shadowMessage.getMsgType();
            String[] arrays = TypeConstants.Base_All_Msg_Type.split("[*,*]");
            List<String> types = Arrays.asList(arrays);
            if (types.contains(msgType)) {
                logger.debug("用户{}于{}进入普通事件分发中心", shadowMessage.getFromUserName(), strDate);
                commonMessageDispatcherService.dispatcher(map, shadowMessage);
            }else if (StringUtils.equals(msgType, TypeConstants.MsgType.Menu_Event_Msg_Type)){//菜单事件推送
                logger.debug("用户{}于{}进入菜单事件分发中心",shadowMessage.getFromUserName(),strDate);
                MenuBaseEventMessage menuBaseEventMessage = wrapMenuBaseRequestMessage(map, shadowMessage);
                menuDispatcherService.dispatcher(map, menuBaseEventMessage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //封装基本数据
    private BaseRequestMessage wrapBaseRequestMessage(Map<String, String> map) {
        BaseRequestMessage message = new BaseRequestMessage();
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
        String type = map.get("MsgType");
        //消息id
        String msgId = map.get("MsgId");
        return new BaseRequestMessage(toUserName, fromUserName, message.getCreateTime(), type, msgId);
    }

    //封装菜单基本请求数据
    private MenuBaseEventMessage wrapMenuBaseRequestMessage(Map<String, String> map, BaseRequestMessage shadowMessage) {
        MenuBaseEventMessage menuBaseEventMessage = new MenuBaseEventMessage(shadowMessage);
        menuBaseEventMessage.setEvent(map.get("Event"));
        menuBaseEventMessage.setEventKey(map.get("EventKey"));
        return menuBaseEventMessage;
    }
}

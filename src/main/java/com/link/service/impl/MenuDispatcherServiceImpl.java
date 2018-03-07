package com.link.service.impl;

import com.link.constants.TypeConstants;
import com.link.form.base.request.menu.MenuBaseEventMessage;
import com.link.service.MenuDispatcherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 15:30
 */
@Service
public class MenuDispatcherServiceImpl implements MenuDispatcherService {

    public void dispatcher(Map<String, String> map, MenuBaseEventMessage message) {
        String event = message.getEvent();
        if (StringUtils.equals(event, TypeConstants.EventType.CLICK_EVENT)){
            doClickEvent(map, message);
        }else if (StringUtils.equals(event, TypeConstants.EventType.VIEW_EVENT)){
            doCiewEvent(map, message);
        }else if (StringUtils.equals(event, TypeConstants.EventType.MINIPROGRAM)){
            doMiniProgram(map, message);
        }else if (StringUtils.equals(event, TypeConstants.EventType.LOCATION_SELECT)){
            doLocationSelect(map, message);
        }else if (StringUtils.equals(event, TypeConstants.EventType.PIC_PHOTO_OR_ALBUM)){
            doPicPhotoOrAlbum(map, message);
        }else if (StringUtils.equals(event, TypeConstants.EventType.PIC_SYSPHOTO)){
            doPicSysPhoto(map, message);
        }else if (StringUtils.equals(event, TypeConstants.EventType.PIC_WEIXIN)){
            doPicWeixin(map, message);
        }else if (StringUtils.equals(event, TypeConstants.EventType.SCANCODE_PUSH)){
            doScancodePush(map, message);
        }else if (StringUtils.equals(event, TypeConstants.EventType.SCANCODE_WAITMSG)){
            doScancodeWait(map, message);
        }
    }

    //点击事件处理
    private void doClickEvent(Map<String, String> map, MenuBaseEventMessage message) {
    }
    //网页跳转事件处理
    private void doCiewEvent(Map<String, String> map, MenuBaseEventMessage message) {
    }
    //小程序事件处理
    private void doMiniProgram(Map<String, String> map, MenuBaseEventMessage message) {
    }
    //定位选择事件处理
    private void doLocationSelect(Map<String, String> map, MenuBaseEventMessage message) {
    }
    //弹出拍照或者相册发图的事件推送
    private void doPicPhotoOrAlbum(Map<String, String> map, MenuBaseEventMessage message) {
    }
    //弹出系统拍照发图的事件推送
    private void doPicSysPhoto(Map<String, String> map, MenuBaseEventMessage message) {
    }
    //弹出微信相册发图器的事件推送
    private void doPicWeixin(Map<String, String> map, MenuBaseEventMessage message) {
    }
    //扫码推事件的事件推送
    private void doScancodePush(Map<String, String> map, MenuBaseEventMessage message) {
    }
    //扫码推事件且弹出“消息接收中”提示框的事件推送
    private void doScancodeWait(Map<String, String> map, MenuBaseEventMessage message) {
    }
}

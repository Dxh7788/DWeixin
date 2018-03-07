package com.link.service.impl;

import com.link.constants.TypeConstants;
import com.link.data.form.base.request.menu.*;
import com.link.service.MenuDispatcherService;
import com.link.service.event.MajorEventHandlerService;
import com.link.service.code.ScanCodeHandlerService;
import com.link.service.pic.PicHandlerService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 15:30
 */
@Service
public class MenuDispatcherServiceImpl implements MenuDispatcherService {

    @Autowired
    HttpServletRequest request;
    @Autowired
    PicHandlerService picHandlerService;
    @Autowired
    ScanCodeHandlerService scanCodeHandlerService;
    @Autowired
    MajorEventHandlerService majorEventHandlerService;
    public void dispatcher(Map<String, String> map, MenuBaseEventMessage message) {
        String event = message.getEvent();
        if (StringUtils.equals(event, TypeConstants.EventType.CLICK_EVENT)){
            doClickEvent();
        }else if (StringUtils.equals(event, TypeConstants.EventType.VIEW_EVENT)){
            doViewEvent();
        }else if (StringUtils.equals(event, TypeConstants.EventType.MINIPROGRAM)){
            doMiniProgram();
        }else if (StringUtils.equals(event, TypeConstants.EventType.LOCATION_SELECT)){
            doLocationSelect();
        }else if (StringUtils.equals(event, TypeConstants.EventType.PIC_PHOTO_OR_ALBUM)||
                StringUtils.equals(event, TypeConstants.EventType.PIC_WEIXIN)||
                StringUtils.equals(event, TypeConstants.EventType.PIC_SYSPHOTO)){
            //pic处理
            doPic(event);
        }else if (StringUtils.equals(event, TypeConstants.EventType.SCANCODE_PUSH)||
                StringUtils.equals(event, TypeConstants.EventType.SCANCODE_WAITMSG)){
            //二维码处理
            doScancode(event);
        }
    }

    //点击事件处理
    private void doClickEvent() {
        try {
            InputStream in =request.getInputStream();
            XStream xStream = new XStream(new DomDriver());
            xStream.autodetectAnnotations(true);
            ClickEventMessage message = (ClickEventMessage) xStream.fromXML(in);
            majorEventHandlerService.doClick(message);
            //最后关闭连接
            in = null;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //网页跳转事件处理
    private void doViewEvent() {
        try {
            InputStream in =request.getInputStream();
            XStream xStream = new XStream(new DomDriver());
            xStream.autodetectAnnotations(true);
            ViewEventMessage message = (ViewEventMessage) xStream.fromXML(in);
            majorEventHandlerService.doView(message);
            //最后关闭连接
            in = null;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //小程序事件处理
    private void doMiniProgram() {
        try {
            InputStream in =request.getInputStream();
            XStream xStream = new XStream(new DomDriver());
            xStream.autodetectAnnotations(true);
            MiniProgramEventMessage message = (MiniProgramEventMessage) xStream.fromXML(in);
            majorEventHandlerService.doMiniProgram(message);
            //最后关闭连接
            in = null;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //定位选择事件处理
    private void doLocationSelect() {
        try {
            InputStream in =request.getInputStream();
            XStream xStream = new XStream(new DomDriver());
            xStream.autodetectAnnotations(true);
            LocationSelectEventMessage message = (LocationSelectEventMessage) xStream.fromXML(in);
            majorEventHandlerService.doLocationSelection(message);
            //最后关闭连接
            in = null;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //弹出拍照或者相册发图的事件推送
    private void doPic(String event) {
        try {
            InputStream in =request.getInputStream();
            XStream xStream = new XStream(new DomDriver());
            xStream.autodetectAnnotations(true);
            PicEventMessage message = (PicEventMessage) xStream.fromXML(in);
            if (StringUtils.equals(message.getEvent(), TypeConstants.EventType.PIC_PHOTO_OR_ALBUM)){
                picHandlerService.doPhotoOrAlbum(message);
            }else if (StringUtils.equals(message.getEvent(), TypeConstants.EventType.PIC_SYSPHOTO)){
                picHandlerService.doSysPhoto(message);
            }else if (StringUtils.equals(message.getEvent(), TypeConstants.EventType.PIC_WEIXIN)){
                picHandlerService.doWeixin(message);
            }
            //最后关闭连接
            in = null;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //扫码推事件的事件推送
    private void doScancode(String event) {
        try {
            InputStream in =request.getInputStream();
            XStream xStream = new XStream(new DomDriver());
            xStream.autodetectAnnotations(true);
            ScanCodeEventMessage message = (ScanCodeEventMessage) xStream.fromXML(in);
            if (StringUtils.equals(message.getEvent(), TypeConstants.EventType.SCANCODE_WAITMSG)){
                scanCodeHandlerService.doWaitMsg(message);
            }else if (StringUtils.equals(message.getEvent(), TypeConstants.EventType.SCANCODE_PUSH)){
                scanCodeHandlerService.doPush(message);
            }
            //最后关闭连接
            in = null;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

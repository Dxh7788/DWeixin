package com.link.service.event.impl;

import com.link.data.form.base.request.menu.ClickEventMessage;
import com.link.data.form.base.request.menu.LocationSelectEventMessage;
import com.link.data.form.base.request.menu.MiniProgramEventMessage;
import com.link.data.form.base.request.menu.ViewEventMessage;
import com.link.service.event.MajorEventHandlerService;
import org.springframework.stereotype.Service;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 19:25
 */
@Service
public class MajorHandlerServiceImpl implements MajorEventHandlerService {
    //处理点击
    public void doClick(ClickEventMessage message) {

    }
    //处理网页
    public void doView(ViewEventMessage message) {

    }
    //处理小程序
    public void doMiniProgram(MiniProgramEventMessage message) {

    }
    //处理定位
    public void doLocationSelection(LocationSelectEventMessage message) {

    }
}

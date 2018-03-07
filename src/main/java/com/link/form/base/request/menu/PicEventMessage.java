package com.link.form.base.request.menu;

import com.link.form.base.request.menu.base.SendPicsInfo;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 16:44
 */
public class PicEventMessage extends MenuBaseEventMessage {
    private SendPicsInfo sendPicsInfo;

    public SendPicsInfo getSendPicsInfo() {
        return sendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
        this.sendPicsInfo = sendPicsInfo;
    }
}

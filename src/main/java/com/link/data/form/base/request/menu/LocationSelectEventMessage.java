package com.link.data.form.base.request.menu;

import com.link.data.form.base.request.menu.base.SendLocationInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 16:43
 */
@XStreamAlias("xml")
public class LocationSelectEventMessage extends MenuBaseEventMessage {
    @XStreamAlias("SendLocationInfo")
    private SendLocationInfo sendLocationInfo;

    public SendLocationInfo getSendLocationInfo() {
        return sendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
        this.sendLocationInfo = sendLocationInfo;
    }
}

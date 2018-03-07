package com.link.form.base.request.menu;

import com.link.form.BaseMessage;
import com.link.form.base.request.BaseRequestMessage;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 15:26
 */
public class MenuBaseEventMessage  extends BaseMessage {
    private String event;
    private String eventKey;

    public MenuBaseEventMessage() {
    }

    public MenuBaseEventMessage(BaseRequestMessage baseRequestMessage) {
        this.setCreateTime(baseRequestMessage.getCreateTime());
        this.setFromUserName(baseRequestMessage.getFromUserName());
        this.setToUserName(baseRequestMessage.getToUserName());
        this.setMsgType(baseRequestMessage.getMsgType());
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}

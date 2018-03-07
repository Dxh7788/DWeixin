package com.link.data.form.base.request;

import com.link.data.form.BaseMessage;

import java.util.Date;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 基本事件请求
 * @author xh.d
 * @since 2018/3/6 12:55
 */
public class BaseRequestMessage extends BaseMessage {
    private String msgId;//消息id

    public BaseRequestMessage() {
    }

    public BaseRequestMessage(String toUserName, String fromUserName, Date createTime, String msgType, String msgId) {
        super(toUserName, fromUserName, createTime, msgType);
        this.msgId = msgId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}

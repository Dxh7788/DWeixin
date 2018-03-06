package com.link.form.base.request;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 基本事件请求
 * @author xh.d
 * @since 2018/3/6 12:55
 */
public class BaseRequestMessage implements Serializable{
    private String toUserName;//发自谁,openId
    private String fromUserName;//发给谁
    private Date createTime;//创建时间
    private String msgType;//消息类型
    private String msgId;//消息id

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}

package com.link.form.base.response;

import com.link.util.xstream.CDATAConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.Date;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 13:09
 */
public class BaseResponseMessage {
    @XStreamConverter(CDATAConverter.class)
    private String ToUserName;//发自谁,openId
    @XStreamConverter(CDATAConverter.class)
    private String FromUserName;//发给谁
    @XStreamConverter(CDATAConverter.class)
    private Date CreateTime;//创建时间
    @XStreamConverter(CDATAConverter.class)
    private String MsgType;//消息类型

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}

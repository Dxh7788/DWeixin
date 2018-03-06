package com.link.form.base.request;

import java.util.Date;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 12:59
 */
public class ImageRequestMessage extends BaseRequestMessage {

    public ImageRequestMessage() {
    }

    public ImageRequestMessage(BaseRequestMessage baseRequestMessage) {
        this.setCreateTime(baseRequestMessage.getCreateTime());
        this.setFromUserName(baseRequestMessage.getFromUserName());
        this.setMsgId(baseRequestMessage.getMsgId());
        this.setToUserName(baseRequestMessage.getToUserName());
        this.setMsgType(baseRequestMessage.getMsgType());
    }

    private String url;//图片url

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.link.form.base.request;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 12:59
 */
public class ImageRequestMessage extends BaseRequestMessage {
    private String url;//图片url

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

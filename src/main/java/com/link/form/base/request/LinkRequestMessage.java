package com.link.form.base.request;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 链接消息
 * @author xh.d
 * @since 2018/3/6 13:02
 */
public class LinkRequestMessage extends BaseRequestMessage {
    private String title;
    private String Description;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

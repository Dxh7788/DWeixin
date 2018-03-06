package com.link.form.base.request;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 12:59
 */
public class ContentRequestMessage extends BaseRequestMessage {
    private String content;//文本内容

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

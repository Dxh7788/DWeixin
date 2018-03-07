package com.link.form.base.response;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 13:12
 */
public class TextResponseMessage extends BaseResponseMessage {
    private String Content;//文本内容

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}

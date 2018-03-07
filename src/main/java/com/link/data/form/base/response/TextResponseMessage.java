package com.link.data.form.base.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 13:12
 */
@XStreamAlias("xml")
public class TextResponseMessage extends BaseResponseMessage {
    private String Content;//文本内容

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}

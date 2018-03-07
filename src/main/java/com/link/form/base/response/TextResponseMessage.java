package com.link.form.base.response;

import com.link.util.CDATAConverter;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 13:12
 */
public class TextResponseMessage extends BaseResponseMessage {
    @XStreamConverter(CDATAConverter.class)
    private String content;//文本内容

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

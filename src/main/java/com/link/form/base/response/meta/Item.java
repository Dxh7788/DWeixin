package com.link.form.base.response.meta;

import com.link.util.xstream.CDATAConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 13:16
 */
@XStreamAlias("Item")
public class Item {
    @XStreamConverter(CDATAConverter.class)
    private String Title;
    @XStreamConverter(CDATAConverter.class)
    private String PicUrl;
    @XStreamConverter(CDATAConverter.class)
    private String Description;
    @XStreamConverter(CDATAConverter.class)
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}

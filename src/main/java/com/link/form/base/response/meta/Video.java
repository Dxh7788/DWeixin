package com.link.form.base.response.meta;

import com.link.util.CDATAConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 11:40
 */
@XStreamAlias("Video")
public class Video {
    @XStreamConverter(CDATAConverter.class)
    private String MediaId;
    @XStreamConverter(CDATAConverter.class)
    private String Description;
    @XStreamConverter(CDATAConverter.class)
    private String Title;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

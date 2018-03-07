package com.link.form.base.response.meta;

import com.link.util.CDATAConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 11:38
 */
@XStreamAlias("Music")
public class Music {
    @XStreamConverter(CDATAConverter.class)
    private String Title;
    @XStreamConverter(CDATAConverter.class)
    private String Description;
    @XStreamConverter(CDATAConverter.class)
    private String MusicUrl;
    @XStreamConverter(CDATAConverter.class)
    private String HQMusicUrl;
    @XStreamConverter(CDATAConverter.class)
    private String ThumbMediaId;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMusicUrl() {
        return MusicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        MusicUrl = musicUrl;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}

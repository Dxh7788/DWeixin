package com.link.form.base.request;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *  音频消息
 * @author xh.d
 * @since 2018/3/6 13:28
 */
public class VoiceRequestMessage extends BaseRequestMessage {
    private String mediaId;
    private String format;//格式

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

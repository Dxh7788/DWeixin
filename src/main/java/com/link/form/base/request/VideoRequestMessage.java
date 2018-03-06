package com.link.form.base.request;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 视频消息
 * @author xh.d
 * @since 2018/3/6 13:30
 */
public class VideoRequestMessage extends BaseRequestMessage{
    private String mediaId;
    private String thumbMediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

package com.link.data.form.base.request;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *  音频消息
 * @author xh.d
 * @since 2018/3/6 13:28
 */
public class VoiceRequestMessage extends BaseRequestMessage {
    private String mediaId;
    private String format;//格式

    public VoiceRequestMessage() {
    }

    public VoiceRequestMessage(BaseRequestMessage baseRequestMessage) {
        this.setCreateTime(baseRequestMessage.getCreateTime());
        this.setFromUserName(baseRequestMessage.getFromUserName());
        this.setMsgId(baseRequestMessage.getMsgId());
        this.setToUserName(baseRequestMessage.getToUserName());
        this.setMsgType(baseRequestMessage.getMsgType());
    }

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

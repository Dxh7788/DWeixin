package com.link.form.base.response;

import com.link.form.base.response.meta.Video;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 10:58
 */
@XStreamAlias("xml")
public class VideoResponseMessage extends BaseResponseMessage{
    private Video Video;

    public com.link.form.base.response.meta.Video getVideo() {
        return Video;
    }

    public void setVideo(com.link.form.base.response.meta.Video video) {
        Video = video;
    }
}

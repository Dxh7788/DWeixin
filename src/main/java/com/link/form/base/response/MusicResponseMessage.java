package com.link.form.base.response;

import com.link.form.base.response.meta.Music;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 13:12
 */
@XStreamAlias("xml")
public class MusicResponseMessage extends BaseResponseMessage {
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}

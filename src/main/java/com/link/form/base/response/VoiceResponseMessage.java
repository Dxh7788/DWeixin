package com.link.form.base.response;

import com.link.form.base.response.meta.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 10:58
 */
@XStreamAlias("xml")
public class VoiceResponseMessage extends BaseResponseMessage{
    private Voice Voice;

    public com.link.form.base.response.meta.Voice getVoice() {
        return Voice;
    }

    public void setVoice(com.link.form.base.response.meta.Voice voice) {
        Voice = voice;
    }
}

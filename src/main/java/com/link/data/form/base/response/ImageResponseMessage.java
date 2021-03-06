package com.link.data.form.base.response;

import com.link.data.form.base.response.meta.Image;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 10:59
 */
@XStreamAlias("xml")
public class ImageResponseMessage extends BaseResponseMessage {
    private Image Image;

    public com.link.data.form.base.response.meta.Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}

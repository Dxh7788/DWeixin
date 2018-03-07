package com.link.form.base.response;

import com.link.form.base.response.meta.Image;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 10:59
 */
public class ImageResponseMessage extends BaseResponseMessage {
    private Image Image;

    public com.link.form.base.response.meta.Image getImage() {
        return Image;
    }

    public void setImage(com.link.form.base.response.meta.Image image) {
        Image = image;
    }
}

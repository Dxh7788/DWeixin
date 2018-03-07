package com.link.service.pic;

import com.link.data.form.base.request.menu.PicEventMessage;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 19:18
 */
public interface PicHandlerService {
    void doPhotoOrAlbum(PicEventMessage message);
    void doSysPhoto(PicEventMessage message);
    void doWeixin(PicEventMessage message);
}

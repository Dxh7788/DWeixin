package com.link.service.event;

import com.link.data.form.base.request.menu.ClickEventMessage;
import com.link.data.form.base.request.menu.LocationSelectEventMessage;
import com.link.data.form.base.request.menu.MiniProgramEventMessage;
import com.link.data.form.base.request.menu.ViewEventMessage;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 19:25
 */
public interface MajorEventHandlerService {
    void doClick(ClickEventMessage message);
    void doView(ViewEventMessage message);
    void doMiniProgram(MiniProgramEventMessage message);
    void doLocationSelection(LocationSelectEventMessage message);
}

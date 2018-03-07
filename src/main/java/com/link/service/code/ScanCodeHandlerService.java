package com.link.service.code;

import com.link.data.form.base.request.menu.ScanCodeEventMessage; /**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 19:22
 */
public interface ScanCodeHandlerService {

    void doWaitMsg(ScanCodeEventMessage message);

    void doPush(ScanCodeEventMessage message);
}

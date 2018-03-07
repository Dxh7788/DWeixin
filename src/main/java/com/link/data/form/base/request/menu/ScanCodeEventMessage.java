package com.link.data.form.base.request.menu;

import com.link.data.form.base.request.menu.base.ScanCodeInfo;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 16:45
 */
@XStreamAlias("xml")
public class ScanCodeEventMessage extends MenuBaseEventMessage {
    @XStreamAlias("ScanCodeInfo")
    private ScanCodeInfo scanCodeInfo;

    public ScanCodeInfo getScanCodeInfo() {
        return scanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
        this.scanCodeInfo = scanCodeInfo;
    }
}

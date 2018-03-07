package com.link.service;

import com.link.form.base.request.BaseRequestMessage;

import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 15:42
 */
public interface CommonMessageDispatcherService {
    void dispatcher(Map<String, String> map, BaseRequestMessage message);
}

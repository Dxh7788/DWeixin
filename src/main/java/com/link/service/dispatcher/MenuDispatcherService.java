package com.link.service.dispatcher;

import com.link.data.form.base.request.menu.MenuBaseEventMessage;

import java.util.Map;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 15:23
 */
public interface MenuDispatcherService {

    //菜单分发器
    void dispatcher(Map<String, String> map, MenuBaseEventMessage message);
}

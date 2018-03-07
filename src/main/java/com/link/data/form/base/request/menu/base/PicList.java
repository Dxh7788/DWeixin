package com.link.data.form.base.request.menu.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 17:05
 */
@XStreamAlias("PicList")
public class PicList {
    private List<Item> items = new ArrayList<Item>(0);
}

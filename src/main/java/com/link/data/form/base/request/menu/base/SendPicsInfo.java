package com.link.data.form.base.request.menu.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 17:04
 */
public class SendPicsInfo {
    @XStreamAlias("Count")
    private Integer count;
    @XStreamAlias("PicList")
    private List<PicList> picLists = new ArrayList<PicList>(0);

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<PicList> getPicLists() {
        return picLists;
    }

    public void setPicLists(List<PicList> picLists) {
        this.picLists = picLists;
    }
}

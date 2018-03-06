package com.link.form.base.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 图文返回消息
 * @author xh.d
 * @since 2018/3/6 13:15
 */
public class FixedTextImgeResponseMessage extends BaseResponseMessage {
    private Integer articleCount;
    private List<Item> items = new ArrayList<Item>(0);

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

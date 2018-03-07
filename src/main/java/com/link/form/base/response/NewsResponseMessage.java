package com.link.form.base.response;

import com.link.form.base.response.meta.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 图文返回消息
 * @author xh.d
 * @since 2018/3/6 13:15
 */
public class NewsResponseMessage extends BaseResponseMessage {
    private Integer ArticleCount;
    private List<Item> Articles = new ArrayList<Item>(0);

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }

    public List<Item> getArticles() {
        return Articles;
    }

    public void setArticles(List<Item> articles) {
        Articles = articles;
    }
}

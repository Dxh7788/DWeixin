package com.link.form.base.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 图文返回消息
 * @author xh.d
 * @since 2018/3/6 13:15
 */
public class NewsResponseMessage extends BaseResponseMessage {
    private Integer articleCount;
    private List<Item> articles = new ArrayList<Item>(0);

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public List<Item> getArticles() {
        return articles;
    }

    public void setArticles(List<Item> articles) {
        this.articles = articles;
    }
}

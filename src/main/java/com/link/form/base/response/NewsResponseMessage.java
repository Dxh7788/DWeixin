package com.link.form.base.response;

import com.link.form.base.response.meta.Item;
import com.link.util.CDATAConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 * 图文返回消息
 * @author xh.d
 * @since 2018/3/6 13:15
 */
@XStreamAlias("xml")
public class NewsResponseMessage extends BaseResponseMessage {
    @XStreamConverter(CDATAConverter.class)
    private Integer ArticleCount;
    private List<Item> articles = new ArrayList<Item>(0);

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }

    public List<Item> getArticles() {
        return articles;
    }

    public void setArticles(List<Item> articles) {
        this.articles = articles;
    }
}

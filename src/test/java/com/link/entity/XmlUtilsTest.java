package com.link.entity;

import com.link.data.form.base.response.*;
import com.link.data.form.base.response.meta.*;
import com.link.util.XmlUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 12:13
 */
public class XmlUtilsTest {
    @Test
    public void wrapperXmlTest(){
        System.out.println("文本返回值格式化");
        TextResponseMessage responseMessage = new TextResponseMessage();
        responseMessage.setContent("12321");
        responseMessage.setCreateTime(new Date());
        responseMessage.setFromUserName("123");
        responseMessage.setToUserName("321");
        responseMessage.setMsgType("text");

        System.out.println(XmlUtils.wrapperXml(responseMessage));

        System.out.println("图片返回值格式化");
        ImageResponseMessage imageResponseMessage = new ImageResponseMessage();
        Image image = new Image();
        image.setMediaId("12321===");
        imageResponseMessage.setImage(image);
        imageResponseMessage.setCreateTime(new Date());
        imageResponseMessage.setFromUserName("123");
        imageResponseMessage.setToUserName("321");
        imageResponseMessage.setMsgType("image");
        System.out.println(XmlUtils.wrapperXml(imageResponseMessage));

        System.out.println("Voice返回值格式化");
        VoiceResponseMessage voiceResponseMessage = new VoiceResponseMessage();
        Voice voice = new Voice();
        voice.setMediaId("12321===");
        voiceResponseMessage.setVoice(voice);
        voiceResponseMessage.setCreateTime(new Date());
        voiceResponseMessage.setFromUserName("123");
        voiceResponseMessage.setToUserName("321");
        voiceResponseMessage.setMsgType("voice");
        System.out.println(XmlUtils.wrapperXml(voiceResponseMessage));

        System.out.println("Video返回值格式化");
        VideoResponseMessage videoResponseMessage = new VideoResponseMessage();
        Video video = new Video();
        video.setMediaId("12321===");
        video.setDescription("我是一个video");
        video.setTitle("邓丽君");
        videoResponseMessage.setVideo(video);
        videoResponseMessage.setCreateTime(new Date());
        videoResponseMessage.setFromUserName("123");
        videoResponseMessage.setToUserName("321");
        videoResponseMessage.setMsgType("video");
        System.out.println(XmlUtils.wrapperXml(videoResponseMessage));

        System.out.println("Music返回值格式化");
        MusicResponseMessage musicResponseMessage = new MusicResponseMessage();
        Music music = new Music();
        music.setHQMusicUrl("https://sdf.c");
        music.setMusicUrl("ht");
        music.setTitle("邓丽君");
        music.setThumbMediaId("thumb45");
        music.setDescription("还不知道");

        musicResponseMessage.setMusic(music);
        musicResponseMessage.setCreateTime(new Date());
        musicResponseMessage.setFromUserName("123");
        musicResponseMessage.setToUserName("321");
        musicResponseMessage.setMsgType("music");
        System.out.println(XmlUtils.wrapperXml(musicResponseMessage));

        System.out.println("图文返回值格式化");
        NewsResponseMessage newsResponseMessage = new NewsResponseMessage();
        newsResponseMessage.setCreateTime(new Date());
        newsResponseMessage.setFromUserName("123");
        newsResponseMessage.setToUserName("321");
        newsResponseMessage.setMsgType("news");
        newsResponseMessage.setArticleCount(2);
        List<Item> items = new ArrayList<Item>(0);
        Item item = new Item();
        item.setDescription("还不知道1");
        item.setPicUrl("hhtp://");
        item.setTitle("item1");
        item.setUrl("yu://");

        Item item0 = new Item();
        item0.setDescription("还不知道2");
        item0.setPicUrl("hhtp://2");
        item0.setTitle("item2");
        item0.setUrl("yu://2");

        items.add(item);
        items.add(item0);
        newsResponseMessage.setArticles(items);
        System.out.println(XmlUtils.wrapperXml(newsResponseMessage));
    }

}

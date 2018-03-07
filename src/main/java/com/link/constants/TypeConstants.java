package com.link.constants;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 13:47
 */
public class TypeConstants {
    /**
     * 消息类型
     * */
    public static class MsgType{
        public static final String TEXT_MSG_TYPE = "text";
        public static final String IMAGE_MSG_TYPE = "image";
        public static final String VOICE_MSG_TYPE = "voice";
        public static final String VIDEO_MSG_TYPE = "video";
        public static final String LOCATION_MSG_TYPE = "location";
        public static final String LINK_MSG_TYPE = "link";
        public static final String Menu_Event_Msg_Type = "event";
    }

    //响应类型
    public static class ResponseMsgType{
        public static final String TEXT_MSG_TYPE = "text";
        public static final String IMAGE_MSG_TYPE = "image";
        public static final String VOICE_MSG_TYPE = "voice";
        public static final String VIDEO_MSG_TYPE = "video";
        public static final String MUSIC_MSG_TYPE = "music";
        public static final String NEWS_MSG_TYPE = "news";
    }
    //事件类型
    public static class EventType{
        public static final String CLICK_EVENT = "click";//点击类型
        public static final String VIEW_EVENT = "view";//网页类型
        public static final String MINIPROGRAM = "miniprogram";//小程序
        public static final String SCANCODE_PUSH = "scancode_push";//
        public static final String SCANCODE_WAITMSG = "scancode_waitmsg";
        public static final String PIC_SYSPHOTO = "pic_sysphoto";
        public static final String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
        public static final String PIC_WEIXIN = "pic_weixin";
        public static final String LOCATION_SELECT = "location_select";

    }
    public static final String Base_All_Msg_Type = "text,image,voice,video,location,link";
}

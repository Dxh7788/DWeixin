package com.link.entity;

import com.link.form.base.response.TextResponseMessage;
import com.link.util.XmlUtils;
import org.junit.Test;

import java.util.Date;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 12:13
 */
public class XmlUtilsTest {
    @Test
    public void wrapperXmlTest(){
        TextResponseMessage responseMessage = new TextResponseMessage();
        responseMessage.setContent("12321");
        responseMessage.setCreateTime(new Date());
        responseMessage.setFromUserName("123");
        responseMessage.setToUserName("321");
        responseMessage.setMsgId("12");
        responseMessage.setMsgType("text");

        System.out.println(XmlUtils.wrapperXml(responseMessage));
    }

}

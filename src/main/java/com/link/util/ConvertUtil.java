package com.link.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.link.form.bo.response.AccessToken;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 11:43
 */
public class ConvertUtil {
    public static AccessToken converStrToAccessToken(String jsonString) {
        AccessToken accessToken = new AccessToken();
        JSONObject o = JSON.parseObject(jsonString);
        accessToken.setAccessToken(String.valueOf(o.get("access_token")));
        //强转Long
        accessToken.setExpireIn(Long.valueOf(String.valueOf(o.get("expires_in"))));
        return accessToken;
    }
}

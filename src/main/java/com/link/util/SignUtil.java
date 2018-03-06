package com.link.util;

import com.link.weixin.AccessConfig;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 10:53
 */
public class SignUtil {

    //校验微信合法性
    public static Boolean checkSignature(String signature,String timestamp,String nouce){
        String arr[] = new String[]{AccessConfig.TOKEN, timestamp,nouce};
        //排序
        Arrays.sort(arr);
        //将3个字符串合并成一个进行SHA-1加密
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<arr.length; i++){
            builder.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            //获取SHA-1摘要算法的实例
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(builder.toString().getBytes());
            tmpStr = convert(digest);
        }catch (Exception e){
            e.printStackTrace();
        }
        builder = null;
        return tmpStr!=null?tmpStr.equals(signature.toUpperCase()):false;
    }

    private static String convert(byte[] digest) {
        StringBuffer sb = new StringBuffer();
        for (byte bt:digest){
            sb.append(hexcode(bt));
        }
        return sb.toString();
    }

    //字符穿换成16进制
    private static String hexcode(byte bt) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A','B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(bt >>> 4) & 0X0F];
        tempArr[1] = Digit[bt & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}

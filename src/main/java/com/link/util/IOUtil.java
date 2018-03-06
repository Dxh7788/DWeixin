package com.link.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 11:36
 */
public class IOUtil {
    public static String getJsonStringFromGZIP(InputStream is){
        String jsonString = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(is);
            bis.mark(2);
            // 取前两个字节
            byte[] header = new byte[2];
            int result = bis.read(header);
            // reset 输入流到开始位置
            bis.reset();
            // 判断是否是 GZIP 格式
            int headerData = getShort(header);
            // Gzip 流 的前两个字节是 0x1f8b
            if (result != -1 && headerData == 0x1f8b) {
                // LogUtil.i("HttpTask", " use GZIPInputStream  ");
                is = new GZIPInputStream(bis);
            } else {
                // LogUtil.d("HttpTask", " not use GZIPInputStream");
                is = bis;
            }
            InputStreamReader reader = new InputStreamReader(is, "utf-8");
            char[] data = new char[100];
            int readSize;
            StringBuffer sb = new StringBuffer();
            while ((readSize = reader.read(data)) > 0) {
                sb.append(data, 0, readSize);
            }
            jsonString = sb.toString();
            bis.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    //
    private static int getShort(byte[] data) {
        return (data[0] << 8) | data[1] & 0xFF;
    }
}

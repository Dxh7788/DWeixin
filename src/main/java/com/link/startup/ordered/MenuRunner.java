package com.link.startup.ordered;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.link.form.bo.response.AccessToken;
import com.link.startup.menu.ClickMenu;
import com.link.startup.menu.ViewMenu;
import com.link.util.HttpUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/6 18:26
 */
@Component
public class MenuRunner implements ApplicationRunner,Ordered{
    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    public void run(ApplicationArguments args) throws Exception {
        ClickMenu cbt=new ClickMenu();
        cbt.setKey("image");
        cbt.setName("回复图片");
        cbt.setType("click");


        ViewMenu vbt=new ViewMenu();
        vbt.setUrl("http://www.cuiyongzhi.com");
        vbt.setName("博客");
        vbt.setType("view");

        JSONArray sub_button=new JSONArray();
        sub_button.add(cbt);
        sub_button.add(vbt);


        JSONObject buttonOne=new JSONObject();
        buttonOne.put("name", "菜单");
        buttonOne.put("sub_button", sub_button);

        JSONArray button=new JSONArray();
        button.add(vbt);
        button.add(buttonOne);
        button.add(cbt);

        JSONObject menujson=new JSONObject();
        menujson.put("button", button);
        //这里为请求接口的url +号后面的是token，这里就不做过多对token获取的方法解释
        AccessToken at = HttpUtils.accessToken();
        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+at.getAccessToken();
        try{
            HttpUtils.sendPostBuffer(url, menujson.toJSONString());
        }catch(Exception e){
            System.out.println("请求错误！");
        }
    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    public int getOrder() {
        return 2;
    }
}

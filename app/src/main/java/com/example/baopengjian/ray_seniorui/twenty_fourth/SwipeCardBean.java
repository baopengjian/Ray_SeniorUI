package com.example.baopengjian.ray_seniorui.twenty_fourth;

import java.util.ArrayList;
import java.util.List;

public class SwipeCardBean {
    private int postition;
    private String url;
    private String name;

    public SwipeCardBean(int postition, String url, String name) {
        this.postition = postition;
        this.url = url;
        this.name = name;
    }

    public int getPostition() {
        return postition;
    }

    public SwipeCardBean setPostition(int postition) {
        this.postition = postition;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SwipeCardBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public SwipeCardBean setName(String name) {
        this.name = name;
        return this;
    }

    public static List<SwipeCardBean> initDatas() {
        List<SwipeCardBean> datas = new ArrayList<>();
        int i = 1;
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201503/22/20150322100412_mftVS.thumb.700_0.jpeg", "美女1"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201809/11/20180911165610_lmzva.thumb.700_0.jpg", "美女2"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201609/15/20160915211353_swE83.thumb.700_0.jpeg", "美女3"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201612/04/20161204204344_GXYUr.thumb.700_0.jpeg", "美女4"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201607/27/20160727215901_FEf3U.thumb.700_0.jpeg", "美女5"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201608/25/20160825104134_CySeU.thumb.700_0.jpeg", "美女6"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201701/19/20170119220742_wKGdf.thumb.700_0.jpeg", "美女7"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201612/04/20161204204004_EcYzh.thumb.700_0.jpeg","美女8"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201512/09/20151209190940_UvuKC.thumb.700_0.jpeg","美女9"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201512/14/20151214192543_veC5y.thumb.700_0.jpeg","美女10"));
        datas.add(new SwipeCardBean(i++, "https://c-ssl.duitang.com/uploads/item/201906/24/20190624135636_Z2RCh.thumb.700_0.jpeg","美女11"));
        return datas;
    }
}

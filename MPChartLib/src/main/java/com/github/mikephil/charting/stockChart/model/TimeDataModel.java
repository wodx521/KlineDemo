package com.github.mikephil.charting.stockChart.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/8.
 */
public class TimeDataModel implements Serializable {

    //时间戳
    private String timeMills ;
    //现价
    private String nowPrice;
    //均价
    private String averagePrice;
    //分钟成交量
    private String volume;
    //今开
    private String open;
    //昨收
    private String preClose;
    private String per;
    private String cha;
    private String total;
    private int color = 0xff000000;

    public String getTimeMills() {
        return timeMills;
    }

    public void setTimeMills(String timeMills) {
        this.timeMills = timeMills;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getPreClose() {
        return preClose;
    }

    public void setPreClose(String preClose) {
        this.preClose = preClose;
    }

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getCha() {
        return cha;
    }

    public void setCha(String cha) {
        this.cha = cha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        TimeDataModel model = (TimeDataModel) obj;
        return getTimeMills().equals(model.getTimeMills());
    }
}

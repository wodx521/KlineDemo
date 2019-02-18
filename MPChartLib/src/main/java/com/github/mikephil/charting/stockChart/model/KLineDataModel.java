package com.github.mikephil.charting.stockChart.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/8.
 */
public class KLineDataModel implements Serializable {
    public String m_szInstrumentID;// 合约ID

    //时间戳
    private String dateMills ;
    private float high;// 最高价
    private float low;// 最低价
    private float open;// 开盘价
    private float close;// 收盘价
    private float volume;// 成交量
    private float total;// 成交额
    private float preClose;// 昨收价
    private float ma5;
    private float ma10;
    private float ma20;
    private float ma30;
    private float ma60;
    public float maLow;
    public float maMid;
    public float maUp;

    public String getDateMills() {
        return dateMills;
    }

    public void setDateMills(String dateMills) {
        this.dateMills = dateMills;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getPreClose() {
        return preClose;
    }

    public void setPreClose(float preClose) {
        this.preClose = preClose;
    }

    public float getMa5() {
        return ma5;
    }

    public void setMa5(float ma5) {
        this.ma5 = ma5;
    }

    public double getMa10() {
        return ma10;
    }

    public void setMa10(float ma10) {
        this.ma10 = ma10;
    }

    public float getMa20() {
        return ma20;
    }

    public void setMa20(float ma20) {
        this.ma20 = ma20;
    }

    public float getMa30() {
        return ma30;
    }

    public void setMa30(float ma30) {
        this.ma30 = ma30;
    }

    public float getMa60() {
        return ma60;
    }

    public void setMa60(float ma60) {
        this.ma60 = ma60;
    }
}

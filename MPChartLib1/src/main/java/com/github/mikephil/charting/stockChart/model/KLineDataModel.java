package com.github.mikephil.charting.stockChart.model;

public class KLineDataModel {
    public String m_szInstrumentID;// 合约ID

    //时间戳
    public String date;
    public float high;// 最高价
    public float low;// 最低价
    public float open;// 开盘价
    public float close;// 收盘价
    public float volume;// 成交量
    public float turnOver;// 持仓量
    public float total;// 成交额
    public float preClose;// 昨收价
    public float ma5;
    public float ma10;
    public float ma20;
    public float ma30;
    public float ma60;
    public float maLow;
    public float maMid;
    public float maUp;

}

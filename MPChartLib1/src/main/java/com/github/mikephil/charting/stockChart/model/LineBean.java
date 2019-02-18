package com.github.mikephil.charting.stockChart.model;

public class LineBean {
    /**
     * date : 20190214
     * time : 0730
     * open : 2.596
     * high : 2.598
     * low : 2.596
     * close : 2.598
     * volume : 8
     * turnover : 0
     */

    private String date;
    private String time;
    //  开
    private String open;
    // 高
    private String high;
    // 低
    private String low;
    // 收
    private String close;
    // 成交量
    private String volume;
    // 持仓量
    private String turnover;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }
}

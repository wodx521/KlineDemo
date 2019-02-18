package com.github.mikephil.charting.stockChart.model;

public class TimeBean {
    /**
     * time : 0800
     * close : 25508
     * volume : 126
     * turnover : 0
     */

    private String time;
    private String close;
    private String volume;
    private String turnover;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

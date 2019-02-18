package com.lairui.klinedemo;

import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.stockChart.data.TimeDataManage;
import com.github.mikephil.charting.stockChart.view.OneDayView;
import com.lairui.klinedemo.entity.KlineParams;
import com.lairui.klinedemo.presenter.SecondPresenter;
import com.wanou.framelibrary.base.BaseMvpActivity;
import com.wanou.framelibrary.utils.GsonUtils;

public class SecondActivity extends BaseMvpActivity<SecondPresenter> {
    private OneDayView chart;
    private TimeDataManage kTimeData = new TimeDataManage();
    private KlineParams klineParams = new KlineParams();
    private String jsonParams;

    @Override
    protected SecondPresenter getPresenter() {
        return new SecondPresenter();
    }

    @Override
    protected int getResId() {
        return R.layout.activity_second;
    }

    @Override
    protected void initView() {
        chart = findViewById(R.id.chart);
        chart.initChart(true);
    }

    @Override
    protected void initData() {
        klineParams.Auth = "kkandroid145";
        klineParams.InstId = "MHIG9";
        klineParams.Period = "0";
        jsonParams = GsonUtils.toJson(klineParams);
        mPresenter.getKlineData(jsonParams);
    }


    public void setTimeData(String body) {
        kTimeData.parseTimeData(body, "");
        chart.setDataToChart(kTimeData);
    }
}

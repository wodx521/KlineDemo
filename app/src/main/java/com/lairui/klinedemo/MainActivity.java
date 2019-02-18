package com.lairui.klinedemo;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.github.mikephil.charting.stockChart.CoupleChartGestureListener;
import com.github.mikephil.charting.stockChart.data.KLineDataManage;
import com.github.mikephil.charting.stockChart.view.KLineView;
import com.github.mikephil.charting.stockChart.view.OneDayView;
import com.lairui.klinedemo.dialog.ChoosePopup;
import com.lairui.klinedemo.entity.KlineParams;
import com.lairui.klinedemo.presenter.MainPresenter;
import com.wanou.framelibrary.base.BaseMvpActivity;
import com.wanou.framelibrary.utils.GsonUtils;
import com.wanou.framelibrary.utils.UiTools;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements View.OnClickListener {

    private RadioButton rbOneMinute;
    private RadioButton rbThreeMinute;
    private RadioGroup rgChooseK;
    private RadioButton rbMore;
    private RadioButton rbFiveMinute;
    private RadioButton rbFifteenMinute;
    private KLineView combinedchart;
    private KlineParams klineParams = new KlineParams();
    private List<String> kLineList = new ArrayList<>();
    private boolean land = true;
    private int indexType = 1;
    private OneDayView chart;
    private KLineDataManage kLineData;

    @Override
    protected int getResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        rbOneMinute = findViewById(R.id.rbOneMinute);
        rbThreeMinute = findViewById(R.id.rbThreeMinute);
        rgChooseK = findViewById(R.id.rgChooseK);
        rbMore = findViewById(R.id.rbMore);
        rbFiveMinute = findViewById(R.id.rbFiveMinute);
        rbFifteenMinute = findViewById(R.id.rbFifteenMinute);
        combinedchart = findViewById(R.id.combinedchart);
        chart = findViewById(R.id.chart);

        rbOneMinute.setOnClickListener(this);
        rbThreeMinute.setOnClickListener(this);
        rbFiveMinute.setOnClickListener(this);
        rbFifteenMinute.setOnClickListener(this);
        rbMore.setOnClickListener(this);
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        kLineList.clear();
        kLineList.add(UiTools.getString(R.string.thirtyMinute));
        kLineList.add(UiTools.getString(R.string.oneHour));
        kLineList.add(UiTools.getString(R.string.oneDay));

        ChoosePopup.getPopup(this, kLineList, rbMore, UiTools.getDeviceWidth(this) * 4 / 5, false, false);
        ChoosePopup.setOnChooseContentListener(new ChoosePopup.OnChooseContentListener() {
            @Override
            public void onChooseClickListener(int position) {
                String jsonParams;
                klineParams.Auth = "kkandroid145";
                klineParams.BeforeDT = "-1";
                klineParams.InstId = "MHIG9";
                rbMore.setText(kLineList.get(position));
                switch (position) {
                    case 0:
                        klineParams.Period = "7";
                        break;
                    case 1:
                        klineParams.Period = "8";
                        break;
                    case 2:
                        klineParams.Period = "9";
                        break;
                    default:
                }
                jsonParams = GsonUtils.toJson(klineParams);
                mPresenter.getKlineData(jsonParams);
            }
        });
    }


    @Override
    public void onClick(View v) {
        String jsonParams;
        klineParams.Auth = "kkandroid145";
        klineParams.BeforeDT = "-1";
        klineParams.InstId = "MHIG9";
        switch (v.getId()) {
            case R.id.rbOneMinute:
                klineParams.Period = "3";
                break;
            case R.id.rbThreeMinute:
                klineParams.Period = "4";
                break;
            case R.id.rbFiveMinute:
                klineParams.Period = "5";
                break;
            case R.id.rbFifteenMinute:
                klineParams.Period = "6";
                break;
            default:
        }
        jsonParams = GsonUtils.toJson(klineParams);
        mPresenter.getKlineData(jsonParams);
    }

    public void setKlineData(String body) {
        kLineData = new KLineDataManage(this);
        combinedchart.initChart(true);
        kLineData.parseFeatureKlineData(body, "", true);
        combinedchart.setDataToChart(kLineData);

        combinedchart.getGestureListenerCandle().setCoupleClick(new CoupleChartGestureListener.CoupleClick() {
            @Override
            public void singleClickListener() {

            }
        });

        combinedchart.getGestureListenerBar().setCoupleClick(new CoupleChartGestureListener.CoupleClick() {
            @Override
            public void singleClickListener() {
                if (land) {
                    loadIndexData(indexType < 6 ? ++indexType : 1);
                }
            }
        });
    }

    private void loadIndexData(int type) {
        indexType = type;
        switch (indexType) {
            case 1://成交量
                combinedchart.doBarChartSwitch(indexType);
                break;
            case 2://请求MACD
                kLineData.initMACD();
                combinedchart.doBarChartSwitch(indexType);
                break;
            case 3://请求KDJ
                kLineData.initKDJ();
                combinedchart.doBarChartSwitch(indexType);
                break;
//            case 4://请求BOLL
//                kLineData.initBOLL();
//                combinedchart.doBarChartSwitch(indexType);
//                break;
            case 4://请求RSI
                kLineData.initRSI();
                combinedchart.doBarChartSwitch(indexType);
                break;
            case 5:
                kLineData.initADX();
                combinedchart.doBarChartSwitch(indexType);
                break;
            case 6:
                kLineData.initATR();
                combinedchart.doBarChartSwitch(indexType);
                break;
            default:
                break;
        }
    }
}

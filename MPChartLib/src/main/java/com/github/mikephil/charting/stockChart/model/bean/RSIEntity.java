package com.github.mikephil.charting.stockChart.model.bean;


import android.util.Log;

import com.github.mikephil.charting.stockChart.model.KLineDataModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by loro on 2017/3/7.
 */

public class RSIEntity {

    private ArrayList<Float> RSIs;

    /**
     * @param kLineBeens
     * @param n          几日
     */
    public RSIEntity(ArrayList<KLineDataModel> kLineBeens, int n) {
        this(kLineBeens, n, 100);
    }

    /**
     * @param kLineBeens
     * @param n          几日
     * @param defult     不足N日时的默认值
     */
    public RSIEntity(ArrayList<KLineDataModel> kLineBeens, int n, float defult) {
        countRSIdatas(kLineBeens, n,defult);
    }


    public ArrayList<Float> getRSIs() {
        return RSIs;
    }

    /**
     * * SMA(C,N,M) = (M*C+(N-M)*Y')/N
     * * LC := REF(CLOSE,1);
     * * RSI$1:SMA(MAX(CLOSE-LC,0),N1,1)/SMA(ABS(CLOSE-LC),N1,1)*100;
     */
    private List<Float> countRSIdatas(ArrayList<KLineDataModel> kLineBeens, int days, float defult) {
        RSIs = new ArrayList<>();
        if (kLineBeens == null) {
            return null;
        }
        if (days > kLineBeens.size()) {
            return null;
        }
        float smaMax = 0, smaAbs = 0;//默认0
        float lc = 0;//默认0
        float close = 0;
        float rsi = 0;

        for (int i = 0; i < kLineBeens.size(); i++) {
            if (i > 0) {
                KLineDataModel entity = kLineBeens.get(i);
                lc = kLineBeens.get(i - 1).getClose();
                close = entity.getClose();
                smaMax = countSMA(Math.max(close - lc, 0f), days, 1, smaMax);
                smaAbs = countSMA(Math.abs(close - lc), days, 1, smaAbs);
                rsi = smaMax / smaAbs * 100;
                RSIs.add(rsi);
            } else {
                RSIs.add(defult);
            }
        }
        int size = kLineBeens.size() - RSIs.size();
        for (int i = 0; i < size; i++) {
//            rsiList.add(0, new KCandleObj());
            RSIs.add(defult);
        }
        return RSIs;
    }

    /**
     * * SMA(C,N,M) = (M*C+(N-M)*Y')/N
     * * C=今天收盘价－昨天收盘价    N＝就是周期比如 6或者12或者24， M＝权重，其实就是1
     * *
     * * @param c   今天收盘价－昨天收盘价
     * * @param n   周期
     * * @param m   1
     * * @param sma 上一个周期的sma
     * * @return
     */
    public float countSMA(float c, float n, float m, float sma) {
        return (m * c + (n - m) * sma) / n;
    }
}

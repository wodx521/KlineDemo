package com.github.mikephil.charting.stockChart;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.R;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.stockChart.model.KLineDataModel;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.NumberUtils;

public class CustomMarkerView extends MarkerView {
    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    private KLineDataModel kLineDataModel;
    private int precision;
    private TextView tvTime, tvOpen, tvHighest, tvLowest, tvClose, tvUpDownAmount,
            tvUpDownRatio, tvTradeAmount, tvHoldAmount, tvDiffAmount;

    public CustomMarkerView(Context context, int layoutResource, int precision) {
        super(context, layoutResource);
        this.precision = precision;
        tvTime = findViewById(R.id.tvTime);
        tvOpen = findViewById(R.id.tvOpen);
        tvHighest = findViewById(R.id.tvHighest);
        tvLowest = findViewById(R.id.tvLowest);
        tvClose = findViewById(R.id.tvClose);
        tvUpDownAmount = findViewById(R.id.tvUpDownAmount);
        tvUpDownRatio = findViewById(R.id.tvUpDownRatio);
        tvTradeAmount = findViewById(R.id.tvTradeAmount);
        tvHoldAmount = findViewById(R.id.tvHoldAmount);
        tvDiffAmount = findViewById(R.id.tvDiffAmount);

    }

    public void setData(KLineDataModel kLineDataModel) {
        this.kLineDataModel = kLineDataModel;
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        tvTime.setText(kLineDataModel.date);
        tvOpen.setText(NumberUtils.keepPrecision(kLineDataModel.open, precision));
        tvHighest.setText(NumberUtils.keepPrecision(kLineDataModel.high, precision));
        tvLowest.setText(NumberUtils.keepPrecision(kLineDataModel.low, precision));
        tvClose.setText(NumberUtils.keepPrecision(kLineDataModel.close, precision));
        float upDownAmount = kLineDataModel.close - kLineDataModel.open;
        float upDownRatio = upDownAmount / kLineDataModel.open * 100;
        tvUpDownAmount.setText(NumberUtils.keepPrecision(upDownAmount, precision));
        tvUpDownRatio.setText(NumberUtils.keepPrecision(upDownRatio, 2) + " %");
        if (upDownAmount >= 0) {
            tvUpDownAmount.setTextColor(getResources().getColor(R.color.up_color));
            tvUpDownRatio .setTextColor(getResources().getColor(R.color.up_color));
            tvLowest .setTextColor(getResources().getColor(R.color.up_color));
            tvTradeAmount .setTextColor(getResources().getColor(R.color.up_color));
        }else{
            tvUpDownAmount.setTextColor(getResources().getColor(R.color.down_color));
            tvUpDownRatio .setTextColor(getResources().getColor(R.color.down_color));
            tvLowest .setTextColor(getResources().getColor(R.color.down_color));
            tvTradeAmount .setTextColor(getResources().getColor(R.color.down_color));
        }
        tvTradeAmount.setText(NumberUtils.keepPrecision(kLineDataModel.volume, precision));
        tvHoldAmount.setText(NumberUtils.keepPrecision(kLineDataModel.turnOver, precision));
        tvDiffAmount.setText("0");
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}

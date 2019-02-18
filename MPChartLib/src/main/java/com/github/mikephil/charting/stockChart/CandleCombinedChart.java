package com.github.mikephil.charting.stockChart;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.stockChart.data.KLineDataManage;
import com.github.mikephil.charting.stockChart.model.KLineDataModel;
import com.github.mikephil.charting.utils.CommonUtil;


/**
 * Created by ly on 2016/9/12.
 */
public class CandleCombinedChart extends CombinedChart {
    private CustomMarkerView customMarkerView;
    public KLineDataManage kLineData;

    public CandleCombinedChart(Context context) {
        super(context);
    }

    public CandleCombinedChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CandleCombinedChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setMarker(CustomMarkerView customMarkerView, KLineDataManage kLineData) {
        this.customMarkerView = customMarkerView;
        this.kLineData = kLineData;
    }

    //暂时无用
    public void setHighlightValue(Highlight h) {
        if (mData == null) {
            mIndicesToHighlight = null;
        } else {
            mIndicesToHighlight = new Highlight[]{h};
        }
        invalidate();
    }

    @Override
    protected void drawMarkers(Canvas canvas) {
        // if there is no marker view or drawing marker is disabled
        if (!isDrawMarkersEnabled() || !valuesToHighlight()) {
            return;
        }

        for (int i = 0; i < mIndicesToHighlight.length; i++) {

            Highlight highlight = mIndicesToHighlight[i];

            IDataSet set = mData.getDataSetByIndex(highlight.getDataSetIndex());

            Entry e = mData.getEntryForHighlight(mIndicesToHighlight[i]);
            int entryIndex = set.getEntryIndex(e);

            // make sure entry not null
            if (e == null || entryIndex > set.getEntryCount() * mAnimator.getPhaseX()) {
                continue;
            }

            float[] pos = getMarkerPosition(highlight);

            // check bounds
            if (!mViewPortHandler.isInBounds(pos[0], pos[1])) {
                continue;
            }
            KLineDataModel kLineDataModel = kLineData.getKLineDatas().get((int) mIndicesToHighlight[i].getX());
            customMarkerView.setData(kLineDataModel);
            customMarkerView.refreshContent(e, mIndicesToHighlight[i]);
            customMarkerView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
            if (pos[0] >= CommonUtil.getWindowWidth(getContext()) / 2) {
                if (getAxisLeft().getLabelPosition() == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    customMarkerView.draw(canvas, mViewPortHandler.contentLeft() - customMarkerView.getWidth() / 2, 0);//+ CommonUtil.dip2px(getContext(),20)   - myMarkerViewLeft.getHeight() / 2
                } else {
                    customMarkerView.draw(canvas, mViewPortHandler.contentLeft() + customMarkerView.getWidth() / 2, 0);//+ CommonUtil.dip2px(getContext(),20)   - myMarkerViewLeft.getHeight() / 2
                }
            }else{
                if (getAxisRight().getLabelPosition() == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    customMarkerView.draw(canvas, mViewPortHandler.contentRight() + customMarkerView.getWidth() / 2, 0);
                } else {
                    customMarkerView.draw(canvas, mViewPortHandler.contentRight() - customMarkerView.getWidth() / 2, 0);
                }
            }
        }
    }
}

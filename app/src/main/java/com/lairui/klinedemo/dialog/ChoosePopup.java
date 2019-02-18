package com.lairui.klinedemo.dialog;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lairui.klinedemo.R;
import com.lairui.klinedemo.adapter.ChooseListAdapter;
import com.wanou.framelibrary.base.BaseRecycleViewAdapter;
import com.wanou.framelibrary.utils.UiTools;

import java.util.List;

/**
 * Author by wodx521
 * Date on 2018/12/13.
 */
public class ChoosePopup {
    public static void getPopup(Activity activity, List<String> contentList, TextView textView, int padding, boolean setDefault, boolean defaultShow) {
        int deviceWidth = UiTools.getDeviceWidth(activity);

        PopupWindow popupWindow = new PopupWindow(deviceWidth - UiTools.dip2px(padding), ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = UiTools.parseLayout(R.layout.choose_list, null);
        RecyclerView mRvChooseList = view.findViewById(R.id.rv_choose_list);
        ChooseListAdapter chooseListAdapter = new ChooseListAdapter(activity);
        mRvChooseList.setAdapter(chooseListAdapter);
        chooseListAdapter.setData(contentList);
        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(UiTools.getDrawable(R.drawable.shape_choose_list));
        if (setDefault) {
            textView.setText(contentList.get(0));
        }

        if (defaultShow) {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            } else {
                popupWindow.showAsDropDown(textView, 0, UiTools.dip2px(5), Gravity.NO_GRAVITY);
            }
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    popupWindow.showAsDropDown(textView, 0, UiTools.dip2px(5), Gravity.NO_GRAVITY);
                }
            }
        });
        chooseListAdapter.setOnItemClickListener(new BaseRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                if (mOnChooseContentListener != null) {
                    mOnChooseContentListener.onChooseClickListener(position);
                    if (popupWindow.isShowing()) {
                        popupWindow.dismiss();
                    }
                }
            }
        });
    }

    public interface OnChooseContentListener {
        void onChooseClickListener(int position);
    }

    private static OnChooseContentListener mOnChooseContentListener;

    public static void setOnChooseContentListener(OnChooseContentListener onChooseContentListener) {
        mOnChooseContentListener = onChooseContentListener;
    }
}

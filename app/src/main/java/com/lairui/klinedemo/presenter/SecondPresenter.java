package com.lairui.klinedemo.presenter;

import com.lairui.klinedemo.Constant;
import com.lairui.klinedemo.SecondActivity;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.wanou.framelibrary.base.BasePresenterImpl;
import com.wanou.framelibrary.okgoutil.OkGoUtils;

public class SecondPresenter extends BasePresenterImpl<SecondActivity> {
    public void getKlineData(String json) {
        OkGoUtils.postRequest(Constant.TIME_URL, "time", json, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                mPresenterView.setTimeData(response.body());
            }

            @Override
            public void onFinish() {
                super.onFinish();

            }
        });
    }
}

package com.lairui.klinedemo.presenter;

import com.lairui.klinedemo.Constant;
import com.lairui.klinedemo.MainActivity;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.wanou.framelibrary.base.BasePresenterImpl;
import com.wanou.framelibrary.okgoutil.OkGoUtils;
import com.wanou.framelibrary.utils.UiTools;

public class MainPresenter extends BasePresenterImpl<MainActivity> {
    public void getKlineData(String json) {
        OkGoUtils.postRequest(Constant.KLINE_URL, "kline", json, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                mPresenterView.setKlineData(response.body());
            }

            @Override
            public void onFinish() {
                super.onFinish();

            }
        });
    }
}

package com.lairui.klinedemo;

import android.content.Context;

import com.wanou.framelibrary.GlobalApplication;

public class MyApplication extends GlobalApplication {

    @Override
    protected Context getAppContext() {
        return this;
    }
}

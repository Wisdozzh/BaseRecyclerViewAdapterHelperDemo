package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.app.Application;

import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.Utils;

public class MyApplication extends Application {

    private static MyApplication appContext;

    public static MyApplication getInstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        Utils.init(this);
    }
}

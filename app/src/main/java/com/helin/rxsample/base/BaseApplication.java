package com.helin.rxsample.base;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

/**
 * Created by helin on 2016/11/11 11:15.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }
}

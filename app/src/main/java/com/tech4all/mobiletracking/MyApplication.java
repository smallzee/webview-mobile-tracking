package com.tech4all.mobiletracking;

import android.app.Application;

public class MyApplication extends Application {

    private static MyApplication mInstance;

    public MyApplication(){
        mInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

    }

    public static synchronized MyApplication getInstance(){
        return mInstance;
    }
}

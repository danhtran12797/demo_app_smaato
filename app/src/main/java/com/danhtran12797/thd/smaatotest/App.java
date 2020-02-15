package com.danhtran12797.thd.smaatotest;

import android.app.Application;

import com.smaato.sdk.core.SmaatoSdk;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SmaatoSdk.init(this, getResources().getString(R.string.publisher_id));
    }
}

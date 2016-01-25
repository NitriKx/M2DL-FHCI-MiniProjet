package com.lifo.upspoi;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by Benoît Sauvère on 25/01/16.
 */
public class UPSPOIApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}

package com.fsp.greendao;

import android.app.Application;
import android.content.Context;

/**
 * Created by kaifa on 2017/6/28.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //初始化greendao
        GreenDaoManager.getInstance();
    }
    public static Context getContext(){
        return context;
    }
}

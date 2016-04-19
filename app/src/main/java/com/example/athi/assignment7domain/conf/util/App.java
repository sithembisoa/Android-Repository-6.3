package com.example.athi.assignment7domain.conf.util;

/**
 * Created by Administrator on 2016/04/19.
 */
import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Context context;


    private static App singleton;

    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        singleton = this;
    }

    public static Context getAppContext() {
        return App.context;
    }

    public static final String TAG = App.class
            .getSimpleName();


    public static synchronized App getInstance() {
        return singleton;
    }
}

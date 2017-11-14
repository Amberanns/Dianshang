package com.bawei.dianshang.home.api;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author 郭丽君
 *         类的作用：
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}

package com.angcyo.uidemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.angcyo.rjpush.RJpush;
import com.angcyo.uiview.RApplication;
import com.angcyo.uiview.Root;
import com.tencent.smtt.sdk.QbSdk;

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2016/12/05 15:00
 * 修改人员：Robi
 * 修改时间：2016/12/05 15:00
 * 修改备注：
 * Version: 1.0.0
 */
public class RApp extends RApplication {

    private static RApp app;

    public static RApp getApp() {
        if (app == null) {
            throw new IllegalArgumentException("RApp 初始化了吗?");
        }
        return app;
    }

    @SuppressLint("MissingPermission")
    public static String getIMEI() {
        return ((TelephonyManager) getApp().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        Root.APP_FOLDER = "UIDemo";
    }

    @Override
    protected void onInit() {
        super.onInit();
//        if (BuildConfig.SHOW_DEBUG) {
//            Takt.stock(this)
//                    .seat(Seat.TOP_RIGHT)
//                    .play();
//
//            BlockCanary.install(this, new AppBlockCanaryContext()).start();
//        }

        //x5内核初始化接口
        QbSdk.initX5Environment(this, null);

        RJpush.init(this, BuildConfig.DEBUG);

        //移步到Activity中初始化
        //FDown.init(this, false/*BuildConfig.DEBUG*/);
    }

    @Override
    protected void onAsyncInit() {
        super.onAsyncInit();
    }

    @Override
    public void onTerminate() {
        if (BuildConfig.SHOW_DEBUG) {
            //Takt.finish();
        }
        super.onTerminate();
    }
}

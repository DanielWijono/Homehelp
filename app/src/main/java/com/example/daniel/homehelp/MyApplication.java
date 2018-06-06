package com.example.daniel.homehelp;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

public class MyApplication extends MultiDexApplication {

    public static MyApplication mInstance;
    private SharedPreferenceCustom sharedPreferenceCustom;
    public Activity activity;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        sharedPreferenceCustom = SharedPreferenceCustom.getInstance(this);
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public boolean isHarian() {
        return sharedPreferenceCustom.getSharedPrefBoolean("IS_HARIAN");
    }

    public void setIsHarian(boolean isHarian) {
        sharedPreferenceCustom.putSharedPrefBoolean("IS_HARIAN", isHarian);
    }

    public boolean isBorongan() {
        return sharedPreferenceCustom.getSharedPrefBoolean("IS_BORONGAN");
    }

    public void setIsBorongan(boolean isBorongan) {
        sharedPreferenceCustom.putSharedPrefBoolean("IS_BORONGAN", isBorongan);
    }

}

package com.riwu.notification.open;

import android.content.Intent;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class OpenNotificationModule extends ReactContextBaseJavaModule {
    private static final int REQUEST_CODE = 1;

    public OpenNotificationModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "OpenNotification";
    }

    @ReactMethod
    public void open() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");

        ReactContext reactContext = getReactApplicationContext();
        String packageName = reactContext.getPackageName();
        intent.putExtra("app_package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_uid", reactContext.getApplicationInfo().uid);

        getReactApplicationContext().startActivityForResult(intent, REQUEST_CODE, null);
    }

}

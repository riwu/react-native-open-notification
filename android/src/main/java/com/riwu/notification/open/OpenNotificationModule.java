package com.riwu.notification.open;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

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
        ReactContext reactContext = getReactApplicationContext();
        String packageName = reactContext.getPackageName();
        Intent intent = new Intent();

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
            intent.putExtra("app_package", packageName);
            intent.putExtra("app_uid", reactContext.getApplicationInfo().uid);
        } else {
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setData(Uri.parse("package:" + packageName));
        }

        getReactApplicationContext().startActivityForResult(intent, REQUEST_CODE, null);
    }

}

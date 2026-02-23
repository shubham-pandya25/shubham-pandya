package com.shubham.monefy.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static AndroidDriver createAndroidDriver() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("Android Emulator");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.monefy.app.lite");
        options.setAppActivity("com.monefy.activities.main.MainActivity_");
        options.setAutoGrantPermissions(true);
        options.setNoReset(false);

        return new AndroidDriver(
                new URL("http://127.0.0.1:4723/"),
                options
        );
    }
}
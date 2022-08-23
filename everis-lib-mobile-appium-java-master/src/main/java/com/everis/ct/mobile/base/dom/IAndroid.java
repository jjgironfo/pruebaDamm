package com.everis.ct.mobile.base.dom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;

public interface IAndroid {

    AndroidDriver<MobileElement> androidDriver();

    void hideKeyboard();

    void enterKey();

    void pressKey(AndroidKey androidKey);

}
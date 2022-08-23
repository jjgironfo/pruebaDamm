package com.everis.ct.mobile.base.methods;

import com.everis.ct.mobile.base.dom.IAndroid;
import com.everis.ct.mobile.lib.MobileDriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidDom implements IAndroid {

    @Override
    public AndroidDriver<MobileElement> androidDriver() {
        return ((AndroidDriver<MobileElement>) MobileDriverManager.getDriver());
    }

    @Override
    public void hideKeyboard() {
        androidDriver().hideKeyboard();
    }

    @Override
    public void enterKey() {
        pressKey(AndroidKey.ENTER);
    }

    @Override
    public void pressKey(AndroidKey androidKey) {
        androidDriver().pressKey(new KeyEvent(androidKey));
    }

}
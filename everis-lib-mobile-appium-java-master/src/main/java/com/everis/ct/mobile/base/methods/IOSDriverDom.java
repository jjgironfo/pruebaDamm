package com.everis.ct.mobile.base.methods;

import com.everis.ct.mobile.base.dom.IIOS;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.Keys;

import static com.everis.ct.mobile.lib.MobileDriverManager.getDriver;

public class IOSDriverDom implements IIOS {

    @Override
    public IOSDriver<MobileElement> iosDriver() {
        return ((IOSDriver<MobileElement>) getDriver());
    }

    @Override
    public void hideKeyboard() {
        iosDriver().hideKeyboard();
    }

    @Override
    public void hideKeyboardByKey(String keyName) {
        iosDriver().hideKeyboard(HideKeyboardStrategy.PRESS_KEY, keyName);
    }

    @Override
    public void hideKeyboardTabOutSide() {
        iosDriver().hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE);
    }

    @Override
    public void enterKey() {
        pressKey(Keys.ENTER);
    }

    @Override
    public void pressKey(Keys keys) {
        iosDriver().getKeyboard().sendKeys(keys);
    }
}

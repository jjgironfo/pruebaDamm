package com.everis.ct.mobile.base.dom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Keys;

public interface IIOS {

    IOSDriver<MobileElement> iosDriver();

    void hideKeyboard();

    void hideKeyboardByKey(String keyName);

    void hideKeyboardTabOutSide();

    void enterKey();

    void pressKey(Keys keys);

}

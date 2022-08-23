package com.everis.ct.mobile.service.screenrecorder;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.Scenario;

public interface IScreenRecorder {

    void androidStartRecording(AppiumDriver<MobileElement> driver);

    void iosStartRecording(AppiumDriver<MobileElement> driver);

    void stopRecording(AppiumDriver<MobileElement> driver, String platformName, Scenario scenario);

}

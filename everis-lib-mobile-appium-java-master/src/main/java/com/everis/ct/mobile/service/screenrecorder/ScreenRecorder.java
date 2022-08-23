package com.everis.ct.mobile.service.screenrecorder;

import com.everis.ct.mobile.service.util.UtilMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.cucumber.java.Scenario;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;

@Component
public class ScreenRecorder implements IScreenRecorder{

    /**
     * Start Recording AndroidDriver
     *
     * @param driver AppiumDriver (AndroidDriver)
     */
    @Override
    public void androidStartRecording(AppiumDriver<MobileElement> driver) {
        UtilMobile.logger(this.getClass()).info("Recording video - Android.");
        ((CanRecordScreen) driver).startRecordingScreen(
                new AndroidStartScreenRecordingOptions().enableBugReport());
    }

    /**
     * Start Recording IOSDriver
     *
     * @param driver AppiumDriver (IOSDriver)
     */
    @Override
    public void iosStartRecording(AppiumDriver<MobileElement> driver) {
        UtilMobile.logger(this.getClass()).info("Recording video - iOS.");
        ((CanRecordScreen) driver).startRecordingScreen(new IOSStartScreenRecordingOptions()
                .withFps(25)
                .withVideoScale("320:-2")
                .withVideoType("h264")); // require ffmpeg
    }

    /**
     * Stop Recording video - Android, iOS
     *
     * @param driver       AppiumDriver (AndroidDriver, IOSDriver)
     * @param platformName (Android, Driver)
     * @param scenario     Running test-scenario from cucumber.
     */
    @Override
    public void stopRecording(AppiumDriver<MobileElement> driver, String platformName, Scenario scenario) {
        UtilMobile.logger(this.getClass()).log(Level.INFO, "Stopping Recording video - {0}", platformName);
        var base64String = ((CanRecordScreen) driver).stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        var videoName = "j-" + platformName.toLowerCase(Locale.ROOT).substring(0, 3) + "-"
                + scenario.getSourceTagNames() + "-"
                + new Date().getTime() + ".mp4";

        var pathVideo = System.getProperty("user.dir") + "/target/video/" +
                platformName.toLowerCase(Locale.ROOT);
        File file = new File(pathVideo);
        if (file.mkdirs())
            UtilMobile.logger(this.getClass()).log(Level.INFO, "Directory \"{0}\" was created successfully", pathVideo);
        else
            UtilMobile.logger(this.getClass()).info("Failed to create directory or already exist.");

        try {
            Files.write(Path.of(pathVideo + "/" + videoName), data);
        } catch (IOException e) {
            e.printStackTrace();
            UtilMobile.logger(this.getClass()).warning("Something was wrong creating video recording.");
        }
    }


}

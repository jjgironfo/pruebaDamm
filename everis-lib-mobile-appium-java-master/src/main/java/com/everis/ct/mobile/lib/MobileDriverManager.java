package com.everis.ct.mobile.lib;

import com.everis.ct.mobile.service.config.PropertiesVault;
import com.everis.ct.mobile.service.constans.Platform;
import com.everis.ct.mobile.service.io.ManageFiles;
import com.everis.ct.mobile.service.screenrecorder.ScreenRecorder;
import com.everis.ct.mobile.service.stepdefinition.ManageScenario;
import com.everis.ct.mobile.service.util.UtilMobile;
import com.google.common.collect.Lists;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.MutableCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.everis.ct.mobile.service.util.UtilMobile.logger;

@Configuration
public class MobileDriverManager extends SetDriver implements IMobileDriverManager {

    @Autowired
    private PropertiesVault propertiesVault;
    @Autowired
    private ScreenRecorder screenRecorder;
    @Autowired
    private ManageScenario scenario;

    private static final ThreadLocal<AppiumDriver<MobileElement>> threadLocal = new ThreadLocal<>();

    public void setDriver(AppiumDriver<MobileElement> driver) {
        threadLocal.set(driver);
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return threadLocal.get();
    }

    @Override
    public void setUpDriver() {
        AppiumDriver<MobileElement> driver;
        var platformName = propertiesVault.getPlatformName();
        var implicitWait = propertiesVault.getImplicitWait();
        logger(MobileDriverManager.class).log(Level.INFO, "PlatformName >>> \"{0}\"", platformName);
        try {
            switch (platformName.toUpperCase(Locale.ROOT)) {
                case Platform.ANDROID:
                    driver = configAndroidDriver();
                    if (propertiesVault.isScreenRecorderOn())
                        screenRecorder.androidStartRecording(driver);
                    break;
                case Platform.IOS:
                    driver = configIosDriver();
                    if (propertiesVault.isScreenRecorderOn())
                        screenRecorder.iosStartRecording(driver);
                    break;
                default:
                    throw new IllegalArgumentException("Plataforma mobile " + platformName.toUpperCase(Locale.ROOT) + " no soportada.");
            }
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
            setDriver(driver);
        } catch (MalformedURLException malformedURLException) {
            logger(this.getClass()).log(Level.WARNING, "Error al construir la ruta del Hub de Appium. >>> {0}", malformedURLException.getCause());
        }
        logger(this.getClass()).log(Level.INFO, "DriverSession >>> {0}", getDriver().getSessionId());
    }

    @Deprecated
    @Override
    public void setUpDriver(String port, String udid, String platformName) {
        final AppiumDriver<MobileElement> driver;
        logger(MobileDriverManager.class).log(Level.INFO, "Parallel execution, Thread ID - \"{0}\", Thread Name - \"{0}\".",
                new Object[]{Thread.currentThread().getId(), Thread.currentThread().getName()});
        logger(MobileDriverManager.class).log(Level.INFO, "PlatformName >>> \"{0}\"", platformName);
        var urlHub = String.format("%s:%s/wd/hub", propertiesVault.getAppiumHub(), port);
        logger(MobileDriverManager.class).log(Level.INFO, "Parallel AppiumHub >>> \"{0}\"", urlHub);
        var implicitWait = propertiesVault.getImplicitWait();
        var app = propertiesVault.getApp();
        var appAndroid = propertiesVault.getAppAndroid();
        var appIOS = propertiesVault.getAppIOS();

        try {
            switch (platformName.toUpperCase(Locale.ROOT)) {
                case Platform.ANDROID:
                    if (app.isEmpty() || app.isBlank())
                        app = appAndroid;
                    driver = configAndroidDriver(urlHub, udid, app);
                    break;
                case Platform.IOS:
                    if (app.isEmpty() || app.isBlank()) app = appIOS;
                    driver = configIosDriver(urlHub, udid, app);
                    break;
                default:
                    throw new IllegalArgumentException("Plataforma mobile " + platformName.toUpperCase(Locale.ROOT) + " no soportada.");
            }
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
            setDriver(driver);
        } catch (MalformedURLException malformedURLException) {
            logger(this.getClass()).log(Level.WARNING, "Error al construir la ruta del Hub de Appium. >>> {0}", malformedURLException.getCause());
        }

        logger(this.getClass()).log(Level.INFO, "DriverSession >>> {0}", getDriver().getSessionId());
    }

    @Override
    public void driverOnDetails() {
        if (getDriver().getSessionId() != null)
            UtilMobile.logger(MobileDriverManager.class).log(Level.INFO,
                    ManageFiles.readAsString("logs/launch-right-app.txt"),
                    new Object[]{getDriver().getSessionId(),
                            getDriver().getCapabilities(),
                            getDriver().getContext(),
                            getDriver().getStatus()});
    }

    @Override
    public void quitDriver() {
        if (isDriverOn()) {
            if (propertiesVault.isScreenRecorderOn())
                screenRecorder.stopRecording(getDriver(), propertiesVault.getPlatformName(), scenario.getScenario());
            getDriver().quit();
        } else
            logger(this.getClass()).warning("Driver session does not exist.");
    }

    @Override
    public boolean isDriverOn() {
        return getDriver() != null;
    }

    @Override
    public void clearCacheApp(String packageName) {
        Map<String, Object> clearPackageCache = new HashMap<>();
        clearPackageCache.put("command", "pm");
        clearPackageCache.put("args", Lists.newArrayList("clear", packageName));
        getDriver().executeScript("mobile: shell", clearPackageCache);
        logger(this.getClass()).info("Cache cleared: {}" + packageName);
    }

//    public void setUpiOSSauceLabsDriver() throws MalformedURLException {
//        AppiumDriver<MobileElement> driver;
//        driver = configIosSauceLabsDriver();
//    }

    public String getUdid() {
        String udid=propertiesVault.getUdid();
        return udid;
    }

    public String getScenario(){
        return scenario.getScenario().getName();
    }

    public String getDevice(){
        return propertiesVault.getDeviceName();
    }
}
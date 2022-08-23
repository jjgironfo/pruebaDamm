package com.everis.ct.mobile.lib;

import com.everis.ct.mobile.service.config.ConfigCapabilities;
import com.everis.ct.mobile.service.config.PropertiesVault;
import com.everis.ct.mobile.service.constans.Platform;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import static com.everis.ct.mobile.service.util.UtilMobile.logger;

public class SetDriver {

    private String appiumHub;

    @Autowired
    private ConfigCapabilities configCapabilities;
    @Autowired
    private PropertiesVault properties;

    @PostConstruct
    public void initProperties() {
        appiumHub = properties.getAppiumHub();
        logger(MobileDriverManager.class).log(Level.INFO, "AppiumHub >>> \"{0}\"", appiumHub);
    }

    protected AndroidDriver<MobileElement> configAndroidDriver() throws MalformedURLException {
        if (!properties.getCapabilitiesConfig().isEmpty())
            return new AndroidDriver<>(new URL(appiumHub), configCapabilities.configCapabilitiesByMap(properties.getCapabilitiesConfig()));
        else
            return new AndroidDriver<>(new URL(appiumHub), configCapabilities.setAndroidCapabilities());
    }

    protected IOSDriver<MobileElement> configIosDriver() throws MalformedURLException {
        if (!properties.getCapabilitiesConfig().isEmpty())
            return new IOSDriver<>(new URL(appiumHub), configCapabilities.configCapabilitiesByMap(properties.getCapabilitiesConfig()));
        else
            return new IOSDriver<>(new URL(appiumHub), configCapabilities.setIOSCapabilities());
    }

    //parallel
    protected AndroidDriver<MobileElement> configAndroidDriver(String appiumHub, String udid, String app) throws MalformedURLException {
        return new AndroidDriver<>(new URL(appiumHub), configCapabilities.configCapabilities(Platform.ANDROID, udid, app));
    }

    //parallel
    protected IOSDriver<MobileElement> configIosDriver(String appiumHub, String udid, String app) throws MalformedURLException {
        return new IOSDriver<>(new URL(appiumHub), configCapabilities.configCapabilities(Platform.IOS, udid, app));
    }

//    protected IOSDriver<MobileElement> configIosSauceLabsDriver() throws MalformedURLException {
//        return new IOSDriver<>(new URL("https://nttmobile:549a6cab-6d6e-4250-af08-576a1dd69ac0@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), configCapabilities.setiOSCapabilitiesSauceLabs());
//    }

}
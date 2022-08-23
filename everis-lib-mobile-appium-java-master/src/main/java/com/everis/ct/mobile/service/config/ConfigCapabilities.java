package com.everis.ct.mobile.service.config;

import com.everis.ct.mobile.model.Capabilities;
import com.everis.ct.mobile.service.constans.Platform;
import com.everis.ct.mobile.service.util.UtilMobile;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Map;

@Component
public class ConfigCapabilities {

    private DesiredCapabilities desiredCapabilities;
    private boolean isAppiumGridOn;

    @Autowired
    private Capabilities capabilities;

    @Autowired
    private PropertiesVault propertiesVault;

    @PostConstruct
    public void initDesiredCapabilities() {
        desiredCapabilities = new DesiredCapabilities();
        isAppiumGridOn = propertiesVault.isAppiumDriverOn();
    }

    private DesiredCapabilities setCommonsCapabilities() {
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, capabilities.getAutomationName());
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, capabilities.getPlatformName());
        desiredCapabilities.setCapability(MobileCapabilityType.APP, capabilities.getApp());
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, capabilities.getUdid());
        if (!isAppiumGridOn) {//grid esta apagado
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, capabilities.getPlatformVersion());
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, capabilities.isNoReset());
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, capabilities.getDeviceName());
        }

        if (isAppiumGridOn && propertiesVault.getPlatformName().equalsIgnoreCase(Platform.IOS))
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, capabilities.getDeviceName());
        return desiredCapabilities;
    }

    public DesiredCapabilities setAndroidCapabilities() {
        propertiesVault.fetchingAndroidCapabilities(); //active recovery
        DesiredCapabilities desiredCapabilities = setCommonsCapabilities();
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, capabilities.getAppActivity());
        //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, capabilities.getAppPackage());
        UtilMobile.logger(this.getClass()).info("Android Capabilities: " + desiredCapabilities);
        return desiredCapabilities;
    }


    public DesiredCapabilities setIOSCapabilities() {
        propertiesVault.fetchingIOSCapabilities(); //active recovery
        DesiredCapabilities desiredCapabilities = setCommonsCapabilities();
        desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, capabilities.getBundleId());
        desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, capabilities.getXcodeOrgId());
        desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, capabilities.getXcodeSigningId());
        desiredCapabilities.setCapability(IOSMobileCapabilityType.CONNECT_HARDWARE_KEYBOARD, capabilities.isConnectHardWareKeyboard());
        UtilMobile.logger(this.getClass()).info("iOS Capabilities: " + desiredCapabilities);
        return setCommonsCapabilities();
    }

    public DesiredCapabilities configCapabilities(String platformName, String udid, String app) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName.toUpperCase(Locale.ROOT));
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, udid);
//        desiredCapabilities.setCapability(MobileCapabilityType.UDID, udid);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app);
        if (platformName.toUpperCase(Locale.ROOT).equals(Platform.IOS)) {
            desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, propertiesVault.getBundleId());
            desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, capabilities.getXcodeOrgId());
            desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, capabilities.getXcodeSigningId());
            desiredCapabilities.setCapability(IOSMobileCapabilityType.CONNECT_HARDWARE_KEYBOARD, capabilities.isConnectHardWareKeyboard());
        } else if (platformName.toUpperCase(Locale.ROOT).equals(Platform.ANDROID)) {
//            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, propertiesVault.getAppActivity());
//            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, propertiesVault.getAppPackage());
        } else {
            throw new IllegalArgumentException("Plataforma mobile " + platformName.toUpperCase(Locale.ROOT) + " no soportada.");
        }
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, propertiesVault.isNoReset());
        return desiredCapabilities;
    }

    /**
     * Configure capabilities by Map from yaml configuration.
     * Set the property capabilities.config: {'key':''value' ...}
     *
     * @param capabilitiesConfig Map of capabilities
     * @return Capabilities configured
     */
    public DesiredCapabilities configCapabilitiesByMap(Map<String, Object> capabilitiesConfig) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (Map.Entry<String, Object> caps : capabilitiesConfig.entrySet()) {
            capabilities.setCapability(caps.getKey(), caps.getValue());
        }
        UtilMobile.logger(this.getClass()).info("Capabilities configured: " + capabilities);
        return capabilities;
    }

//    public DesiredCapabilities setiOSCapabilitiesSauceLabs() throws MalformedURLException {
//        MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("appium:deviceName", "iPhone_12_mini_14_POC12");
//        caps.setCapability("appium:app", "storage:filename=YDRAY-My-Hey.ipa");
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("username", "nttmobile");
//        sauceOptions.setCapability("accessKey", "549a6cab-6d6e-4250-af08-576a1dd69ac0");
//        caps.setCapability("sauce:options", sauceOptions);
//        URL url = new URL("https://nttmobile:549a6cab-6d6e-4250-af08-576a1dd69ac0@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
//        return desiredCapabilities;
//    }

}
package com.everis.ct.mobile.service.config;

import com.everis.ct.mobile.model.Capabilities;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Component
public class PropertiesVault {

    @Autowired
    private Capabilities capabilities;

    @Value("${mobiledriver.implicitWaitOnSeconds:15}")
    private int implicitWait;
    @Value("${mobiledriver.appiumGrid:true}")
    private boolean appiumDriverOn;
    @Value("${mobiledriver.screenRecorder:false}")
    private boolean screenRecorderOn;
    @Value("${mobiledriver.screenRecorderPath:target}")
    private String screenRecorderPath;

    @Value("${capabilities.appiumHubSauceLabs:}")
    private String appiumHub;
    @Value("${capabilities.automationName:NOT_DEFINED}")
    private String automationName;
    @Value("${capabilities.platformName:}")
    private String platformName;
    @Value("${capabilities.platformVersion:}")
    private String platformVersion;
    @Value("${capabilities.deviceName:}")
    private String deviceName;
    @Value("${capabilities.app:}")
    private String app;
    @Value("${capabilities.udid:NOT_DEFINED}")
    private String udid;
    @Value("${capabilities.noReset:}")
    private boolean noReset;
    @Value("#{${capabilities.config:{:}}}")
    private Map<String,Object> capabilitiesConfig;

    /**
     * ANDROID CAPABILITIES
     */
    @Value("${capabilities.app.android:NOT_DEFINED}")
    private String appAndroid;
    @Value("${capabilities.android.appActivity:}")
    private String appActivity;
    @Value("${capabilities.android.appPackage:}")
    private String appPackage;

    /**
     * IOS CAPABILITIES
     */
    @Value("${capabilities.app.ios:}")
    private String appIOS;
    @Value("${capabilities.ios.bundleId:}")
    private String bundleId;
    @Value("${capabilities.ios.xcodeOrgId:}")
    private String xcodeOrgId;
    @Value("${capabilities.ios.xcodeSigningId:}")
    private String xcodeSigningId;
    @Value("${capabilities.ios.connectHardWareKeyboard:false}")
    private boolean connectHardWareKeyboard;

    /**
     * Fetching commons capabilities values into Capabilities Local Object
     */
    private void fetchingCommonsCapabilities() {
        capabilities.setAutomationName(automationName);
        capabilities.setPlatformName(platformName);
        capabilities.setPlatformVersion(platformVersion);
        capabilities.setDeviceName(deviceName);
        capabilities.setApp(app);
        capabilities.setUdid(udid);
        capabilities.setNoReset(noReset);
    }

    /**
     * Fetching iOS capabilities values into Capabilities Local Object
     */
    public void fetchingIOSCapabilities() {
        capabilities.setBundleId(bundleId);
        capabilities.setXcodeOrgId(xcodeOrgId);
        capabilities.setXcodeSigningId(xcodeSigningId);
        capabilities.setConnectHardWareKeyboard(connectHardWareKeyboard);
        fetchingCommonsCapabilities();
    }

    /**
     * Fetching Android capabilities values into Capabilities Local Object
     */
    public void fetchingAndroidCapabilities() {
        fetchingCommonsCapabilities();
        capabilities.setAppActivity(appActivity);
        capabilities.setAppPackage(appPackage);
    }
}
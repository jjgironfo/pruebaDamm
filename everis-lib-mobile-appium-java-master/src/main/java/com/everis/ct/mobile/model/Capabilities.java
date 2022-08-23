package com.everis.ct.mobile.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Capabilities {
    private String automationName;
    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String app;
    private String udid;
    private boolean noReset;
    private String appActivity;
    private String appPackage;
    private String bundleId;
    private String xcodeOrgId;
    private String xcodeSigningId;
    private boolean connectHardWareKeyboard;
}
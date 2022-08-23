package com.everis.ct.mobile.lib;

public interface IMobileDriverManager {

    void setUpDriver();

    void setUpDriver(String port, String udid, String platformName);

    void driverOnDetails();

    void quitDriver();

    boolean isDriverOn();

    void clearCacheApp(String packageName);
}

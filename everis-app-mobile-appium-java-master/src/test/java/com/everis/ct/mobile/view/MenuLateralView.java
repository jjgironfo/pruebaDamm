package com.everis.ct.mobile.view;

import com.everis.ct.mobile.base.MobileBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MenuLateralView extends MobileBase {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    @AndroidFindBy(id = "com.damm.dammbars.pre:id/settings_icon")
    protected MobileElement botonEngranaje;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"MI NEGOCIO\"`][1]")
    @AndroidFindBy(xpath = "//*[contains(@text,'MI NEGOCIO')]")
    protected MobileElement miNegocio;

    @iOSXCUITFindBy(accessibility = "CONSUMOS")
    @AndroidFindBy(xpath = "//*[contains(@text,'CONSUMOS')]")
    protected MobileElement consumos;

    @iOSXCUITFindBy(accessibility = "PROMOCIONES")
    @AndroidFindBy(xpath = "//*[contains(@text,'PROMOCIONES')]")
    protected MobileElement promociones;


    public void tapBotonConfig(){
        waitUntilElementIsVisible(botonEngranaje, 15);
        tap(botonEngranaje);
    }

    public void pulsarMiNegocio(){
        if(isAndroid()) {
            //tapByCoordinates(735);
            waitUntilElementIsVisible(miNegocio, 15);
            tap(miNegocio);
        } else {
            waitUntilElementIsVisible(miNegocio, 15);
            tap(miNegocio);
        }
    }

    public void pulsarConsumo(){
        if(isAndroid()) {
            //tapByCoordinates(885);
            waitUntilElementIsVisible(consumos, 15);
            tap(consumos);
        } else {
            waitUntilElementIsVisible(consumos, 15);
            tap(consumos);
        }
    }

    public void pulsarPromociones(){
        if(isAndroid()) {
            //tapByCoordinates(1132);
            waitUntilElementIsVisible(promociones, 15);
            tap(promociones);
        } else {
            waitUntilElementIsVisible(promociones, 15);
            tap(promociones);
        }
    }
}
package com.everis.ct.mobile.view;

import com.everis.ct.mobile.base.MobileBase;
import com.everis.ct.mobile.service.util.ReadProperties;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginView extends MobileBase {


    @AndroidFindBy(id = "com.android.chrome:id/terms_accept")
    protected MobileElement botonGoogle;

    @AndroidFindBy(id = "com.android.chrome:id/positive_button")
    protected MobileElement botonSync;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Correo Electrónico\"`]")
    @AndroidFindBy(xpath = "(//*[contains(@class,'android.widget.EditText')])[1]")
    protected MobileElement campoEmail;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`value == \"Contraseña\"`]")
    @AndroidFindBy(xpath = "(//*[contains(@class,'android.widget.EditText')])[2]")
    protected MobileElement campoPass;

    @iOSXCUITFindBy(accessibility = "Acceder")
    @AndroidFindBy(xpath = "//*[contains(@text,'Acceder')]")
    protected MobileElement botonAcceder;

    @iOSXCUITFindBy(accessibility = "Done")
    protected MobileElement btnDoneTecladoIos;


    public void sendEmail(boolean scenario4) {
        ReadProperties properties = new ReadProperties();
        String email = null;
        if(scenario4){
            email = properties.pasarEmailPromos();
        } else {
            email = properties.pasarEmail();
        }
        waitUntilElementIsVisible(campoEmail, 20);
        if(isIOS()) {
            campoEmail.sendKeys("a" + email);
            tap(btnDoneTecladoIos);
        } else {
            campoEmail.sendKeys(email);
        }
    }

    public void sendPass(boolean scenario4) {
        ReadProperties properties = new ReadProperties();
        String pass = null;
        if(scenario4){
            pass = properties.pasarPassPromos();
        } else {
            pass = properties.pasarPass();
        }
        waitUntilElementIsVisible(campoPass, 15);

        if(isIOS()) {
            sleep(1000);
            campoPass.sendKeys("a" + pass);
            tap(btnDoneTecladoIos);
        } else {
            campoPass.sendKeys(pass);
        }
    }

    public void tapAcceder() {
        waitUntilElementIsVisible(botonAcceder, 15);
        tap(botonAcceder);
    }

    public void tapTerminosGoogle(){
        waitUntilElementIsVisible(botonGoogle, 15);
        tap(botonGoogle);
    }

    public void tapSync(){
        waitUntilElementIsVisible(botonSync, 15);
        tap(botonSync);
    }
}
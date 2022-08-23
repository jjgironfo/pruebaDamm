package com.everis.ct.mobile.view;

import com.everis.ct.mobile.base.MobileBase;
import com.everis.ct.mobile.service.util.ReadProperties;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SettingView extends MobileBase{

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'USUARI')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'USUARI')]")
    protected MobileElement tituloUsuario;

    //TODO revisar email
    @iOSXCUITFindBy(accessibility = "Email")//T
    @AndroidFindBy(xpath = "(//*[contains(@text,'Editar')])[1]")
    protected MobileElement botonEmail;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Dirección de correo electrónico actual\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'actual')]")
    protected MobileElement emailActual;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Nueva dirección de correo electrónico\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Nueva dir')]")
    protected MobileElement emailNuevo;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Repetir dirección de correo electrónico\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Repetir')]")
    protected MobileElement repiteEmail;

    @iOSXCUITFindBy(accessibility = "Cambiar contraseña")
    @AndroidFindBy(xpath = "//*[contains(@text,'Cambiar contraseña')]")
    protected MobileElement cambiarPass;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Introduce tu contraseña actual\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Contraseña actual')]")
    protected MobileElement passActual;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Introduce tu contraseña actual']/../XCUIElementTypeButton")
    protected MobileElement passActualVisible;

    @iOSXCUITFindBy(accessibility = "Next:")
    protected MobileElement nextTeclado;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Introduce tu contraseña nueva\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Introduce')]")
    protected MobileElement passNueva;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Introduce tu contraseña nueva']/../XCUIElementTypeButton")
    protected MobileElement passNuevaVisible;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Repite tu contraseña nueva\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Repite')]")
    protected MobileElement repitePass;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repite tu contraseña nueva']/../XCUIElementTypeButton")
    protected MobileElement repitePassVisible;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"GUARDAR\"`]")
    @AndroidFindBy(id = "com.damm.dammbars.pre:id/save_button_view")
    protected MobileElement botonGuardar;

    @iOSXCUITFindBy(xpath = "//*[@name='GUARDAR']")
    protected MobileElement borrameGuardar;

    @iOSXCUITFindBy(accessibility = "Cerrar sesión")
    @AndroidFindBy(xpath = "//*[contains(@text,'Cerrar')]")
    protected MobileElement botonCerrarSesion;

    @iOSXCUITFindBy(accessibility = "Mis Establecimientos")
    @AndroidFindBy(xpath = "//*[contains(@text,'Mis establecimientos')]")
    protected MobileElement misEstablecimientos;

    @iOSXCUITFindBy(accessibility = "BAR AQUI MISMO")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'com.damm.dammbars.pre:id/title_text_view')])[1]")
    protected MobileElement bar1;

    @iOSXCUITFindBy(accessibility = "PIKA PIKA")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'com.damm.dammbars.pre:id/title_text_view')])[2]")
    protected MobileElement otroNegocio;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'com.damm.dammbars.pre:id/image_right_view')])[1]")
    protected MobileElement checkBoxBar1;

    @iOSXCUITFindBy(accessibility = "Atrás")
    @AndroidFindBy(accessibility = "Desplazarse hacia arriba")
    protected MobileElement botonAtras;

    @iOSXCUITFindBy(accessibility = "Atrás")
    @AndroidFindBy(accessibility = "Navega cap a dalt")
    protected MobileElement botonAtrasCat;

    @iOSXCUITFindBy(accessibility = "Idioma")
    @AndroidFindBy(xpath = "//*[contains(@text,'Idioma')]")
    protected MobileElement botonIdioma;

    @iOSXCUITFindBy(accessibility = "Catalán")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'com.damm.dammbars.pre:id/title_text_view')])[2]")
    protected MobileElement idiomaCat;

    @iOSXCUITFindBy(accessibility = "Espanyol")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'com.damm.dammbars.pre:id/title_text_view')])[1]")
    protected MobileElement idiomaEsp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@label,'CEPTAR')]")
    @AndroidFindBy(id = "com.damm.dammbars.pre:id/accept_text_view")
    protected MobileElement aceptarPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Autorización datos de compras\"]/../../XCUIElementTypeSwitch")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'com.damm.dammbars.pre:id/switch_view')])[3]")
    protected MobileElement flagConsumos;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Comunicaciones comerciales\"]/../../XCUIElementTypeSwitch")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'com.damm.dammbars.pre:id/switch_view')])[2]")
    protected MobileElement flagPromociones;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SÍ\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'SÍ')]")
    protected MobileElement popUpSi;

    @iOSXCUITFindBy(accessibility = "Autorización datos de compras")
    @AndroidFindBy(xpath = "//*[contains(@text,'Autorización')]")
    protected MobileElement autorizacionDatos;

    @iOSXCUITFindBy(accessibility = "Comunicaciones comerciales")
    @AndroidFindBy(xpath = "//*[contains(@text,'Comunicaciones')]")
    protected MobileElement comunicacionComercial;


    public void verificarTituloUsuario(){
        waitUntilElementIsVisible(tituloUsuario, 15);
    }

    public void accesoEmail(){
        waitUntilElementIsVisible(botonEmail, 5);
        tap(botonEmail);
    }

    public void cambiarPass(){
        waitUntilElementIsVisible(cambiarPass, 15);
        tap(cambiarPass);
    }

    public void passActual(){
        ReadProperties properties = new ReadProperties();

        boolean isIos = isIOS();
        if(isIos) {
            waitUntilElementIsVisible(passActualVisible, 15);
            tap(passActualVisible);
            waitUntilElementIsVisible(passActual, 15);
            passActual.sendKeys(properties.pasarPass());
            waitUntilElementIsVisible(nextTeclado, 15);
            tap(nextTeclado);
        }else{
            waitUntilElementIsVisible(passActual, 15);
            passActual.sendKeys(properties.pasarPass());
        }
    }

    public void passNueva(){

        boolean isIos = isIOS();
        if(isIos) {
            waitUntilElementIsVisible(passNuevaVisible, 15);
            tap(passNuevaVisible);
            ReadProperties properties = new ReadProperties();
            waitUntilElementIsVisible(passNueva, 15);
            passNueva.sendKeys(properties.pasarPassNueva());
            properties.escribirArchivoProperties();
            properties.cambiarPassNXPassA();
            properties.escribirArchivoProperties();
            waitUntilElementIsVisible(nextTeclado, 15);
            tap(nextTeclado);
        }else{
            ReadProperties properties = new ReadProperties();
            waitUntilElementIsVisible(passNueva, 15);
            passNueva.sendKeys(properties.pasarPassNueva());
            properties.escribirArchivoProperties();
            properties.cambiarPassNXPassA();
            properties.escribirArchivoProperties();
        }
    }

    public void repitePass(){

        boolean isIos = isIOS();
        if(isIos) {
            waitUntilElementIsVisible(repitePassVisible, 15);
            tap(repitePassVisible);
            ReadProperties properties = new ReadProperties();
            waitUntilElementIsVisible(repitePass, 15);
            repitePass.sendKeys(properties.pasarPass());
            waitUntilElementIsVisible(nextTeclado, 15);
            tap(nextTeclado);
        }else{
            ReadProperties properties = new ReadProperties();
            waitUntilElementIsVisible(repitePass, 15);
            repitePass.sendKeys(properties.pasarPass());
        }
    }

    public void emailActual(){
        ReadProperties properties = new ReadProperties();
        waitUntilElementIsVisible(emailActual, 15);
        emailActual.sendKeys(properties.pasarEmail());


        if(isIOS()) {
            waitUntilElementIsVisible(nextTeclado, 15);
            tap(nextTeclado);
        }
    }

    public void emailNuevo(){
        ReadProperties properties = new ReadProperties();
        waitUntilElementIsVisible(emailNuevo, 15);
        emailNuevo.sendKeys(properties.pasarEmailNuevo());
        properties.escribirArchivoProperties();
        properties.cambiarEmailNXEmailA();
        properties.escribirArchivoProperties();


        if(isIOS()) {
            waitUntilElementIsVisible(nextTeclado, 15);
            tap(nextTeclado);
        }
    }

    public void repiteEmail(){
        ReadProperties properties = new ReadProperties();
        waitUntilElementIsVisible(repiteEmail, 15);
        repiteEmail.sendKeys(properties.pasarEmail());


        if(isIOS()) {
            waitUntilElementIsVisible(nextTeclado, 15);
            tap(nextTeclado);
        }

    }

    public void botonGuardar(){
        try {
            waitUntilElementIsVisible(botonGuardar, 15);
            tap(botonGuardar);
        } catch(Exception e) {
            if(isIOS()) {
                tapByCoordinates(725);
            }
        }
    }

    public void cerrarSesion(){
        ScrollToElement(botonCerrarSesion);
        waitUntilElementIsVisible(botonCerrarSesion, 5);
        tap(botonCerrarSesion);
    }

    public void accesoMisEstablecimientos(){
        ScrollToElement(misEstablecimientos);
        waitUntilElementIsVisible(misEstablecimientos, 5);
        tap(misEstablecimientos);
    }

    public void verificarBarDefecto(){
        waitUntilElementIsVisible(bar1,15);
        checkBoxBar1.isSelected();
    }

    public void pulsarAtras(){
        waitUntilElementIsVisible(botonAtras,15);
        tap(botonAtras);
    }

    public void pulsarAtrasCat(){
        waitUntilElementIsVisible(botonAtrasCat,15);
        tap(botonAtrasCat);
    }

    public void pulsarOtroNegocio(){
        waitUntilElementIsVisible(otroNegocio,15);
        tap(otroNegocio);
    }

    public void pulsarBar1(){
        waitUntilElementIsVisible(bar1,15);
        tap(bar1);
    }

    public void accesoIdiomas(){
        ScrollToElement(botonIdioma);
        waitUntilElementIsVisible(botonIdioma, 5);
        tap(botonIdioma);
    }

    public void pulsarCat(){
        waitUntilElementIsVisible(idiomaCat,15);
        tap(idiomaCat);
    }

    public void pulsarEsp(){
        waitUntilElementIsVisible(idiomaEsp,15);
        tap(idiomaEsp);
    }

    public void pulsarAceptar(){
        waitUntilElementIsVisible(aceptarPopUp,15);
        tap(aceptarPopUp);
    }

    public void flagConsumo(){
        ScrollToElement(autorizacionDatos);
        tap(flagConsumos);
        sleep(9000);
    }

    public void aceptarPopUpConsumo(){
        waitUntilElementIsVisible(popUpSi,15);
        tap(popUpSi);
        sleep(8000);
    }

    public void aceptarPopUpIOS(){
        if(isIOS()){
            waitUntilElementIsVisible(popUpSi,15);
            tap(popUpSi);
            sleep(8000);
        }
    }

    public void flagPromociones(){
        ScrollToElement(comunicacionComercial);
        tap(flagPromociones);
        sleep(8000);
    }
}

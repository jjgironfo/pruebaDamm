package com.everis.ct.mobile.view;

import com.everis.ct.mobile.base.MobileBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

public class HomeView extends MobileBase {

    @iOSXCUITFindBy(accessibility = "ÚLTIMAS NOVEDADES")
    @AndroidFindBy(xpath = "//*[contains(@text,'ÚLTIMAS NOVEDADES')]")
    protected MobileElement campoUltNov;

    @iOSXCUITFindBy(accessibility = "ÚLTIMES NOVETATS")
    @AndroidFindBy(xpath = "//*[contains(@text,'ÚLTIMES NOVETATS')]")
    protected MobileElement campoUltNovCat;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"DammBarsPre.HomeView\"`]/XCUIElementTypeButton[1]")
    @AndroidFindBy(accessibility = "Open navigation drawer")
    protected MobileElement menuLateral;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"DammBarsPre.HomeView\"]/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "com.damm.dammbars.pre:id/toolbar_title")
    protected MobileElement encabezado;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Consum') and contains(@name,' total')]")
    @AndroidFindBy(id = "com.damm.dammbars.pre:id/business_title_view")
    protected MobileElement consumoTotalHome;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText")
    @AndroidFindBy(className = "android.widget.TextView")
    protected List <MobileElement> bloquesDom;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[2])[5]")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'com.damm.dammbars.pre:id/image_menu')])[3]")
    protected MobileElement bloqueCartaDigital;

    @iOSXCUITFindBy(accessibility = "CARTA DIGITAL")
    protected MobileElement cartaDigital;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ESTE DISPOSITIVO\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'ESTE DISPOSITIVO')]")
    protected MobileElement botonEsteDispositivo;

    @iOSXCUITFindBy(accessibility = "BAR AQUI MISMO")
    protected MobileElement elRacoItalia;


    public void verificarAcceso(){
        waitUntilElementIsVisible(encabezado, 50);
    }

    public void tapMenuLateral(){
        waitUntilElementIsVisible(menuLateral, 15);
        tap(menuLateral);
    }

    public void desplegarSelectorEstab(){
        waitUntilElementIsVisible(encabezado, 10);
        tap(encabezado);
    }

    public void verificarTituloEncabezado(){
        waitUntilElementIsVisible(encabezado,15);
//            String tituloEncabezado = getText(encabezado,5);
//            boolean condicionTitulo = tituloEncabezado.contains(Titulo);
//            Assert.assertTrue(condicionTitulo, Titulo);
    }



    public void pulsarOtroNegocio(){
        if(isAndroid()) {
            sleep(5000);
            tapByCoordinates(1448);
        } else {
            sleep(5000);
            tapByCoordinates(460);
        }
    }

    public void pulsarElRacoItalia(){
        if(isAndroid()) {
            tapByCoordinates(1361);
        } else {
            waitUntilElementIsVisible(elRacoItalia, 10);
            tap(elRacoItalia);
        }
    }


    public void pulsarCartaDigital(){
        if(isIOS()){
         ScrollToElement(cartaDigital);
         waitUntilElementIsVisible(cartaDigital,15);
         tap(bloqueCartaDigital);
        }else {
            ScrollToElement(bloqueCartaDigital);
            waitUntilElementIsVisible(bloqueCartaDigital, 15);
            tap(bloqueCartaDigital);
        }
    }

    public void pulsarEsteDispositivo(){
        waitUntilElementIsVisible(botonEsteDispositivo,15);
        tap(botonEsteDispositivo);
    }

    public void verificarCat(String Consumo){
        waitUntilElementIsVisible(campoUltNovCat,15);
        ScrollToElement(consumoTotalHome);
        String consumoTotal = getText(consumoTotalHome,5);
        boolean condicionTituloConsumo = consumoTotal.contains(Consumo);
        Assert.assertTrue(Consumo, condicionTituloConsumo);
    }

    public void verificarEsp(String Consumo){
        waitUntilElementIsVisible(encabezado,15);
        ScrollToElement(consumoTotalHome);
        String consumoTotal = getText(consumoTotalHome,5);
        boolean condicionTituloConsumo = consumoTotal.contains(Consumo);
        Assert.assertTrue(Consumo, condicionTituloConsumo);
    }

    public void verificarNoAparece(String texto){
        waitUntilElementIsVisible(campoUltNov,15);
        boolean elemento =  verifyElementInAList(bloquesDom,texto, 15 );
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(elemento);
        softAssertions.assertAll();
    }

    public void verificarAparece(String texto){
        waitUntilElementIsVisible(encabezado,15);
        boolean elemento =  verifyElementInAList(bloquesDom,texto, 15 );
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(elemento);
        softAssertions.assertAll();
    }
}

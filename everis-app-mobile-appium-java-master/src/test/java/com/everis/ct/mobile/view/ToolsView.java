package com.everis.ct.mobile.view;

import com.everis.ct.mobile.base.MobileBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ToolsView extends MobileBase {

    @AndroidFindBy(id = "com.damm.dammbars.pre:id/toolbar_title")
    private MobileElement encabezado;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Consumos\"`]")
    private MobileElement encabezadoConsumos;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Promociones\"`]")
    private MobileElement encabezadoPromociones;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Cerveza\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Producto')]")
    protected MobileElement campoProducto;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Todas las marcas\"`]")
    @AndroidFindBy(xpath = "//*[contains(@text,'marcas')]")
    protected MobileElement campoMarcas;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"TODAS\"`]/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//*[contains(@text,'TODAS')]")
    protected MobileElement campoTodas;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"ME INTERESA\"`]/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//*[contains(@text,'ME INTERESA')]")
    protected MobileElement campoMeInteresa;

//    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//*[contains(@text,'Logo HorecaTec')]")
    protected MobileElement logoWebCartaDigital;

//    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(xpath = "//*[contains(@text,'Visualizar carta')]")
    protected MobileElement botonVerCarta;


    public void  verificarEncabezadoConsumo() {
        if(isAndroid()) {
            verificarTituloEncabezado("Consumos");
        } else {
            waitUntilElementIsVisible(encabezadoConsumos,15);
        }
    }

    public void  verificarEncabezadoPromociones() {
        if(isAndroid()) {
            verificarTituloEncabezado("Promo");
        } else {
            waitUntilElementIsVisible(encabezadoPromociones,15);
        }
    }

    private void verificarTituloEncabezado(String Titulo){
        String tituloEncabezado = getText(encabezado,5);
        boolean condicionTitulo = tituloEncabezado.contains(Titulo);
        Assert.assertTrue(Titulo, condicionTitulo);
    }

    public void textoProducto(){
        waitUntilElementIsVisible(campoProducto,15);
    }

    public void textoMarcas(){
        waitUntilElementIsVisible(campoMarcas,15);
    }

    public void textoTodas(){
        waitUntilElementIsVisible(campoTodas,15);
    }

    public void textoMeInteresa(){
        waitUntilElementIsVisible(campoMeInteresa,15);
    }

    public void logoHoreca(){
        waitUntilElementIsVisible(logoWebCartaDigital,15);
    }

    public void botonVerCarta(){
        waitUntilElementIsVisible(botonVerCarta,15);
    }
}

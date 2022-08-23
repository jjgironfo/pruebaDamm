package com.everis.ct.mobile.glue;

import com.everis.ct.mobile.MobileAutomationApplication;
import com.everis.ct.mobile.lib.MobileDriverManager;
import com.everis.ct.mobile.step.*;
import com.everis.ct.mobile.utils.MailUtility;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MobileAutomationApplication.class)
public class SettingsStepDefinition {
    @Autowired
    private SettingStep settingStep;
    @Autowired
    private LoginStep loginStep;

    @Autowired
    private HomeStep homeStep;

    @Autowired
    private MenuLateralStep menuLateralStep;

    @Autowired
    private MobileDriverManager manager;

    @Autowired
    private AccesoStep accesoStep;

    @Cuando("cambio la pass antigua por la pass nueva")
    public void cambioLaPass() {
        settingStep.accesoCambioPass();
        settingStep.introducirPassActual();
        settingStep.introducirPassNueva();
        settingStep.repetirPassNueva();
        settingStep.tapGuardar();
    }

    @Cuando("cambio el email antiguo por el nuevo email")
    public void cambioElEmail() {
        settingStep.introducirEmailActual();
        settingStep.introducirEmailNuevo();
        settingStep.repetirEmailNuevo();
        settingStep.tapGuardar();
        settingStep.tapAceptar();
    }

    @Y("recibo y valido el email")
    public void reciboYValidoMail() {
        //Espera para que llegue el mail
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ignore) { }

        MailUtility.leerEmailYAccederAUrl();
    }

    @Entonces("hago logout y login con el email y la pass")
    public void hagoLogoutYLoginConElEmailYLaPass() {
        settingStep.pulsarCerrarSesion();
        settingStep.tapPopUpIOS();
        accesoStep.accederConCuenta();
        Boolean scenario4 = manager.getScenario().contains("4.barTools");
        loginStep.introducirEmail(scenario4);
        loginStep.introducirPass(scenario4);
        loginStep.accederHome();
        loginStep.verificarHome();
    }

    @Dado("que accedo al menu de configuracion")
    public void queAccedoAlMenuDeConfiguracion() {
        homeStep.tapMenuHamburguesa();
        menuLateralStep.tapConfiguracion();
        settingStep.verificarMenuConfig();
    }

    @Cuando("accedo a mis establecimientos")
    public void accedoAMisEstablecimientos() {
        settingStep.pulsarMisEstablecimientos();
    }

    @Y("verifico el establecimiento por defecto")
    public void verificoElEstablecimientoPorDefecto() {
        settingStep.verificacionBarDefecto();
    }

    @Y("cambio el establecimiento predeterminado")
    public void cambioElEstablecimientoPredeterminado() {
        settingStep.tapOtroNegocio();
        settingStep.tapGuardar();
    }

    @Y("hago logout, login y se reestablece el establecimiento por defecto")
    public void hagoLogoutLoginYSeReestableceElEstablecimientoPorDefecto() {
        homeStep.tapMenuHamburguesa();
        menuLateralStep.tapConfiguracion();
        settingStep.verificarMenuConfig();
        settingStep.pulsarCerrarSesion();
        settingStep.tapPopUpIOS();
        accesoStep.accederConCuenta();
        Boolean scenario4 = manager.getScenario().contains("4.barTools");
        loginStep.introducirEmail(scenario4);
        loginStep.introducirPass(scenario4);
        loginStep.accederHome();
        loginStep.verificarHome();
        homeStep.tapMenuHamburguesa();
        menuLateralStep.tapConfiguracion();
        settingStep.verificarMenuConfig();
        settingStep.pulsarMisEstablecimientos();
        settingStep.tapBar1();
        settingStep.tapGuardar();
        homeStep.verificarEstDefecto();
    }

    @Cuando("accedo a idiomas")
    public void accedoAIdiomas() {
        settingStep.tapIdioma();
    }

    @Cuando("accedo al email")
    public void accedoAlEmail() {
        settingStep.tapEmail();
    }

    @Entonces("cambio el idioma de la aplicacion")
    public void cambioElIdiomaDeLaAplicacion() {
        settingStep.tapCat();
        settingStep.tapGuardar();
        settingStep.tapAceptar();
        settingStep.tapAtrasCat();
        homeStep.verificacionCat();
    }

    @Y("reestablezco el idioma por defecto")
    public void reestablezcoElIdiomaPorDefecto() {
        homeStep.tapMenuHamburguesa();
        menuLateralStep.tapConfiguracion();
        settingStep.verificarMenuConfig();
        settingStep.tapIdioma();
        settingStep.tapEsp();
        settingStep.tapGuardar();
        settingStep.tapAceptar();
        settingStep.tapAtras();
        homeStep.verificacionEsp();
    }

    @Y("activo el flag de consumo")
    public void activoElFlagDeConsumo() {
        homeStep.tapMenuHamburguesa();
        menuLateralStep.tapConfiguracion();
        settingStep.tapFlagConsumo();
        settingStep.tapAtras();
        homeStep.verificarAparece("MI NEGOCIO");
    }

    @Cuando("desactivo el flag de consumo")
    public void desactivoElFlagDeConsumo() {
        settingStep.tapFlagConsumo();
        settingStep.tapPopUpSi();
        settingStep.tapAtras();
        homeStep.verificacionNoAparece("MI NEGOCIO");
    }

    @Cuando("desactivo el flag de promociones")
    public void desactivoElFlagDePromociones() {
        settingStep.tapFlagPromociones();
        settingStep.tapAtras();
        homeStep.verificacionNoAparece("PROMOCIONES");
    }

    @Y("activo el flag de promociones")
    public void activoElFlagDePromociones() {
        homeStep.tapMenuHamburguesa();
        menuLateralStep.tapConfiguracion();
        settingStep.tapFlagPromociones();
        settingStep.tapAtras();
        homeStep.verificarAparece("PROMOCIONES");
    }
}



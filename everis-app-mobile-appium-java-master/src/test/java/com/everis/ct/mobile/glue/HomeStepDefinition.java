package com.everis.ct.mobile.glue;

import com.everis.ct.mobile.MobileAutomationApplication;
import com.everis.ct.mobile.lib.MobileDriverManager;
import com.everis.ct.mobile.step.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MobileAutomationApplication.class)
public class HomeStepDefinition {

    @Autowired
    private SettingStep settingStep;

    @Autowired
    private ToolsStep toolsStep;

    @Autowired
    private HomeStep homeStep;

    @Autowired
    private MenuLateralStep menuLateralStep;

    @Autowired
    private MobileDriverManager manager;

    @Autowired
    private AccesoStep accesoStep;

    @Entonces("retrocedo a la home y confirmo los datos del bar")
    public void retrocedoALaHomeYConfirmoLosDatosDelBar() {
        settingStep.tapAtras();
        settingStep.tapAtras();
        homeStep.verificarEstDefecto();
    }

    @Dado("que pulso el selector de establecimiento")
    public void quePulsoElSelectorDeEstablecimiento() {
        homeStep.cambioEst();
    }

    @Cuando("cambio de negocio")
    public void cambioDeNegocio() {
        homeStep.tapOtroNegocio();
    }

    @Entonces("verifico que se ha realizado el cambio")
    public void verificoQueSeHaRealizadoElCambio() {
        homeStep.verificarOtroNegocio();
    }

    @Entonces("accedo a Carta digital")
    public void accedoACartaDigital() {
        homeStep.tapCartaDigital();
        homeStep.tapEsteDispositivo();
//        toolsStep.verificarCartaDigital();
    }
}

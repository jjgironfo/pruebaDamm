package com.everis.ct.mobile.glue;

import com.everis.ct.mobile.MobileAutomationApplication;
import com.everis.ct.mobile.lib.MobileDriverManager;
import com.everis.ct.mobile.step.*;
import io.cucumber.java.es.Entonces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MobileAutomationApplication.class)
public class MenuLateralStepDefinition {

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

    @Autowired
    private ToolsStep toolsStep;

    @Entonces("entro al consumo desde el menu lateral")
    public void entroAlConsumoDesdeElMenuLateral() {
        homeStep.tapMenuHamburguesa();
        menuLateralStep.tapMiNegocio();
        menuLateralStep.tapConsumo();
        toolsStep.verificarConsumo();
    }

    @Entonces("entro a promociones desde el menu lateral")
    public void entroAPromocionesDesdeElMenuLateral() {
        homeStep.tapMenuHamburguesa();
        menuLateralStep.tapMiNegocio();
        menuLateralStep.tapPromociones();
        toolsStep.verificarPromociones();
    }
}

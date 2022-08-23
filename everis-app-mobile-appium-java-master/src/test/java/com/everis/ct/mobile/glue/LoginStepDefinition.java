package com.everis.ct.mobile.glue;

import com.everis.ct.mobile.MobileAutomationApplication;
import com.everis.ct.mobile.lib.MobileDriverManager;
import com.everis.ct.mobile.step.AccesoStep;
import com.everis.ct.mobile.step.HomeStep;
import com.everis.ct.mobile.step.LoginStep;
import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;


@SpringBootTest(classes = MobileAutomationApplication.class)
public class LoginStepDefinition {

    @Autowired
    private AccesoStep accesoStep;

    @Autowired
    private LoginStep loginStep;

    @Autowired
    private HomeStep homeStep;

    @Autowired
    private MobileDriverManager manager;

    @Dado("que ya estoy registrado")
    public void queYaEstoyRegistrado() {
        accesoStep.accederConCuenta();
    }

    @Cuando("hago login con el email y la pass")
    public void queHagoLoginConElEmailYLaPass() {
        System.out.println("Scenario: " + manager.getScenario());
        Boolean scenario4 = manager.getScenario().contains("(USER PROMO)");
        loginStep.introducirEmail(scenario4);
        loginStep.introducirPass(scenario4);
        loginStep.accederHome();
    }

    @Entonces("validar que se accede a la home")
    public void validarQueSeAccedeALaHome() {
        loginStep.verificarHome();
    }
}

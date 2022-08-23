package com.everis.ct.mobile.glue;

import com.everis.ct.mobile.MobileAutomationApplication;
import com.everis.ct.mobile.lib.MobileDriverManager;
import com.everis.ct.mobile.step.AccesoStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;

import static com.everis.ct.mobile.service.util.UtilMobile.getValueFromDataTable;

@CucumberContextConfiguration
@SpringBootTest(classes = MobileAutomationApplication.class)
public class AccesoStepDefinition {

    @Autowired
    private AccesoStep accesoStep;

    @Autowired
    private MobileDriverManager manager;

    @Dado("que abro la aplicacion mobile en:")
    public void queAbroLaAplicacionMobileEn(DataTable dataTable) {
        var port = getValueFromDataTable(dataTable, "port");
        var udid = getValueFromDataTable(dataTable, "udid");
        var platformName = getValueFromDataTable(dataTable, "platformName");
        manager.setUpDriver(port, udid, platformName);
    }

    @Dado("^que abro la aplicacion mobile$")
    public void abroLaAplicacionMobile() {
        manager.setUpDriver();
        manager.driverOnDetails();
        manager.clearCacheApp("com.android.chrome");
    }

    @Dado("^que abro la aplicacion$")
    public void queAbroLaAplicacion() throws MalformedURLException {
        //Parametros del sistema enviado en la llamada al script
        String port = System.getProperty("port","443");
        String udid = System.getProperty("udid","Google_Pixel_3a_real");
        String platformName = System.getProperty("platformName","android");
        manager.setUpDriver(port, udid, platformName);
        manager.driverOnDetails();


        if(platformName.equalsIgnoreCase("iOS")) {
            accesoStep.aceptarNotificaciones();
        }
    }

    @Dado("que registro mi establecimiento")
    public void queRegistroMiEstablecimiento() throws InterruptedException {
        accesoStep.avanceTutorial();
    }

    @Cuando("informo el pincode invalido")
    public void informoElPincodeInvalido() {
        accesoStep.introducirPincode();
    }

    @Entonces("validar que aparece un mensaje de error indicando que el pincode no es valido")
    public void validarQueApareceUnMensajeDeErrorIndicandoQueElPincodeNoEsValido() {
        accesoStep.verificarErrorCodigo();
    }


}

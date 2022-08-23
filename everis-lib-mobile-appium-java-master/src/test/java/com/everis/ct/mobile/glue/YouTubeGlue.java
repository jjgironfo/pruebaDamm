package com.everis.ct.mobile.glue;

import com.everis.ct.mobile.lib.MobileDriverManager;
import com.everis.ct.mobile.service.util.UtilMobile;
import com.everis.ct.mobile.step.youtube.SearchVideoStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.es.Dado;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.everis.ct.mobile.service.util.UtilMobile.getValueFromDataTable;
import static org.junit.Assert.assertTrue;

@CucumberContextConfiguration
@SpringBootTest
public class YouTubeGlue {

    @Autowired
    private SearchVideoStep searchVideoStep;
    @Autowired
    private MobileDriverManager mobileDriverManager;

    @Dado("que abro la aplicacion mobile en:")
    public void queAbroLaAplicacionMobileEn(DataTable dataTable) {
        var port = getValueFromDataTable(dataTable, "port");
        var udid = getValueFromDataTable(dataTable, "udid");
        var platformName = getValueFromDataTable(dataTable, "platformName");
        mobileDriverManager.setUpDriver(port, udid, platformName);
    }

    @Dado("^que abro la aplicacion mobile$")
    public void abroLaAplicacionMobileAuna() {
        mobileDriverManager.setUpDriver();
        mobileDriverManager.driverOnDetails();
    }

    @Given("que busco el nuevo video {string}")
    public void queBuscoElNuevoVideo(String nombreVideo) {
        searchVideoStep.searchVideo(nombreVideo);
    }

    @Then("validar si hay mas de un resultado")
    public void validarSiHayMasDeUnResultado() {
        assertTrue(searchVideoStep.getSizeResult() > 0);
        UtilMobile.waitForSeconds(5);
    }

}
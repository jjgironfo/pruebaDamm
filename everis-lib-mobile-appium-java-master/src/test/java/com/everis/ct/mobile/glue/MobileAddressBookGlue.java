package com.everis.ct.mobile.glue;

import com.everis.ct.mobile.lib.MobileDriverManager;
import com.everis.ct.mobile.step.addressbook.AddNewContactStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class MobileAddressBookGlue {

    @Autowired
    private MobileDriverManager mobileDriverManager;
    @Autowired
    private AddNewContactStep addNewContactStep;

    @Given("^que abro la aplicacion MobileAddressBook")
    public void abroLaAplicacionMobileAddressBookGlue() {
        mobileDriverManager.setUpDriver();
        mobileDriverManager.driverOnDetails();
    }

    @Given("que me encuentro en la seccion de agregar un nuevo usuario")
    public void queMeEncuentroEnLaSeccionDeAgregarUnNuevoUsuario() {
        addNewContactStep.goAddContact();
    }

    @When("ingreso los datos del nuevo contacto y lo agrego")
    public void ingresoLosDatosDelNuevoContactoYLoAgrego() {
        addNewContactStep.createContact();
    }

}

package com.everis.ct.mobile.view.addressBook;

import com.everis.ct.mobile.base.MobileBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddContactView extends MobileBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Nombre\"]")
    private MobileElement name;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Apellidos\"]")
    private MobileElement lastName;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Listo\"]")
    private MobileElement done;

    public void typeName(){
        type(name, "Percy");
    }

    public void typeLastName(){
        type(lastName, "Mendoza");
    }

    public void createContact(){
        tap(done);
    }
}

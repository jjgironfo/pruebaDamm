package com.everis.ct.mobile.view.addressBook;

import com.everis.ct.mobile.base.MobileBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ContactListView extends MobileBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Agregar\"]")
    private MobileElement addNewContactButton;

    public void addContact(){
        tap(addNewContactButton);
    }
}

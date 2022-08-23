package com.everis.ct.mobile.step.addressbook;

import com.everis.ct.mobile.step.AddressBookViews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddNewContactStep {

    @Autowired
    private AddressBookViews views;

    public void goAddContact() {
        views.contactListView().addContact();
    }

    public void createContact() {
        views.addContactView().typeName();
        views.addContactView().typeLastName();
        views.addContactView().createContact();
    }
}

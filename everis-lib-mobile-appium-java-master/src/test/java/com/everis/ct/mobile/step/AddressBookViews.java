package com.everis.ct.mobile.step;

import com.everis.ct.mobile.view.addressBook.AddContactView;
import com.everis.ct.mobile.view.addressBook.ContactListView;
import org.springframework.stereotype.Component;

@Component
public class AddressBookViews {

    public ContactListView contactListView(){
        return new ContactListView();
    }

    public AddContactView addContactView(){
        return new AddContactView();
    }
}

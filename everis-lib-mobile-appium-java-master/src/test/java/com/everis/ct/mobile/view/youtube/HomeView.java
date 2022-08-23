package com.everis.ct.mobile.view.youtube;

import com.everis.ct.mobile.base.MobileBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomeView extends MobileBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='id.ui.navigation.search.button']")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Search' or @content-desc='Buscar']")
    protected MobileElement searchButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name='id.navigation.search.text_field']")
    @AndroidFindBy(id = "com.google.android.youtube:id/search_edit_text")
    protected MobileElement inputSearch;

    public void searchVideo() {
        waitUntilElementIsVisible(searchButton, 15);
        tap(searchButton);
    }

    public void writeAndSearch(String data) {
        waitUntilElementIsVisible(inputSearch, 15);
        type(inputSearch, data);
        if (isAndroid())
            android().pressKey(AndroidKey.ENTER);
        else
            ios().iosDriver().getKeyboard().pressKey("\n");
    }

}

package com.everis.ct.mobile.view;

import com.everis.ct.mobile.base.MobileBase;
import com.everis.ct.mobile.service.util.UtilMobile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.List;
import java.util.logging.Level;

public class ResultsView extends MobileBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.view.ViewGroup")
    protected List<MobileElement> resulList;

    public int getResults() {
        waitUntilElementIsVisible(resulList.get(0), 15);
        UtilMobile.logger(this.getClass()).log(Level.INFO, "Cantidad de items en resultado: {0}.", resulList.size());
        return resulList.size();
    }
}

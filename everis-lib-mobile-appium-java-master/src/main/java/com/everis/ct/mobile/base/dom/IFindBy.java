package com.everis.ct.mobile.base.dom;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public interface IFindBy {

    MobileElement geElementBy(By locator);

    List<MobileElement> geElementsBy(By locator);

    MobileElement getElementByXPath(String xpath);

    List<MobileElement> getElementsByXPath(String xpath);

    MobileElement getElementById(String id);

    List<MobileElement> getElementsById(String id);

    MobileElement getElementByCss(String css);

    List<MobileElement> getElementsByCss(String css);

}

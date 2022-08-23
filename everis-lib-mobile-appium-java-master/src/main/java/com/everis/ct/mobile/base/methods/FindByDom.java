package com.everis.ct.mobile.base.methods;

import com.everis.ct.mobile.base.dom.IFindBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.everis.ct.mobile.lib.MobileDriverManager.getDriver;

public class FindByDom implements IFindBy {

    @Override
    public MobileElement geElementBy(By locator) {
        return getDriver().findElement(locator);
    }

    @Override
    public List<MobileElement> geElementsBy(By locator) {
        return getDriver().findElements(locator);
    }

    @Override
    public MobileElement getElementByXPath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    @Override
    public List<MobileElement> getElementsByXPath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    @Override
    public MobileElement getElementById(String id) {
        return getDriver().findElement(By.id(id));
    }

    @Override
    public List<MobileElement> getElementsById(String id) {
        return getDriver().findElements(By.id(id));
    }

    @Override
    public MobileElement getElementByCss(String css) {
        return getDriver().findElement(By.cssSelector(css));
    }

    @Override
    public List<MobileElement> getElementsByCss(String css) {
        return getDriver().findElements(By.cssSelector(css));
    }

}

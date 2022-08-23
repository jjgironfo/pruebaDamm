package com.everis.ct.mobile.base.dom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public interface ICommonsActions {

    void tap(MobileElement mobileElement);

    void tap(MobileElement mobileElement,  int timeOutOnSeconds);

    void type(MobileElement mobileElement, String charSequences);

    void type(MobileElement mobileElement, String charSequences, int timeOutOnSeconds);

    String getText(MobileElement mobileElement);

    String getText(MobileElement mobileElement, int timeOutOnSeconds);

    String getAttribute(MobileElement mobileElement, String attributeName);

    String getAttribute(MobileElement mobileElement, String attributeName, int timeOutOnSeconds);

    void tapElementInAList(List<MobileElement> listElement, String value);

    void tapElementInAList(List<MobileElement> listElement, String value, int timeOutOnSeconds);

    boolean isEnabled(MobileElement mobileElement);

    boolean isEnabled(MobileElement mobileElement, int timeOutOnSeconds);

    boolean isDisplayed(MobileElement mobileElement);

    boolean isDisplayed(MobileElement mobileElement, int timeOutOnSeconds);

    boolean isSelected(MobileElement mobileElement);

    boolean isSelected(MobileElement mobileElement, int timeOutOnSeconds);

    MobileElement waitUntilElementIsVisible(MobileElement mobileElement, int timeOutInSeconds);

    MobileElement waitUntilElementIsClickable(MobileElement mobileElement, int timeOutInSeconds);

    MobileElement waitUntilElement(ExpectedCondition<MobileElement> expectedCondition, int duration);

    List<MobileElement> waitUntilElements(ExpectedCondition<List<MobileElement>> expectedCondition, int duration);

    void swipeToBottom(double topY, double bottonY);

    void ScrollToElement(MobileElement elemento) throws InterruptedException;

}
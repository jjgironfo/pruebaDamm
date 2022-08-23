package com.everis.ct.mobile.base;

import com.everis.ct.mobile.base.dom.IAndroid;
import com.everis.ct.mobile.base.dom.IFindBy;
import com.everis.ct.mobile.base.dom.IIOS;
import com.everis.ct.mobile.base.dom.IMobileActions;
import com.everis.ct.mobile.base.methods.AndroidDom;
import com.everis.ct.mobile.base.methods.CommonsActionsDom;
import com.everis.ct.mobile.base.methods.FindByDom;
import com.everis.ct.mobile.base.methods.IOSDriverDom;
import com.everis.ct.mobile.service.constans.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.PageFactory;

import static com.everis.ct.mobile.lib.MobileDriverManager.getDriver;

public class MobileBase extends CommonsActionsDom implements IMobileActions {

    public MobileBase() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    protected AppiumDriver<MobileElement> driver() {
        return getDriver();
    }

    protected String getPlatformName() {
        return driver().getCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME).toString();
    }

    protected boolean isAndroid() {
        return driver().getCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME).toString().equalsIgnoreCase(Platform.ANDROID);
    }

    protected boolean isIOS() {
        return driver().getCapabilities().getCapability(MobileCapabilityType.PLATFORM_NAME).toString().equalsIgnoreCase(Platform.IOS);
    }

    @Override
    public IAndroid android() {
        return new AndroidDom();
    }

    @Override
    public IIOS ios() {
        return new IOSDriverDom();
    }

    @Override
    public IFindBy find() {
        return new FindByDom();
    }
}

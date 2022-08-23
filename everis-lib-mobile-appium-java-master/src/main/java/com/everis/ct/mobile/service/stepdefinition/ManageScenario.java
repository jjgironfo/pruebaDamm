package com.everis.ct.mobile.service.stepdefinition;

import com.everis.ct.mobile.lib.MobileDriverManager;
import com.everis.ct.mobile.service.io.ManageFiles;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.springframework.stereotype.Component;

@Component
public class ManageScenario {

    private static final ThreadLocal<Scenario> threadLocal = new ThreadLocal<>();

    public void setScenario(Scenario scenario) {
        threadLocal.set(scenario);
    }

    public Scenario getScenario() {
        return threadLocal.get();
    }

    public void printFullView() {
        if (getScenario() == null)
            throw new IllegalArgumentException(ManageFiles.readAsString("logs/log-no-scenario-declared.txt"));
        if (MobileDriverManager.getDriver() == null)
            throw new IllegalArgumentException("MobileDriver dosen't exist. Please, check the application properties file.");
        byte[] screenshot = MobileDriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
        getScenario().attach(screenshot, "image/jpeg", "evidencia");
    }

    public void shotWhenFail() {
        if (getScenario().isFailed())
            printFullView();
    }

}
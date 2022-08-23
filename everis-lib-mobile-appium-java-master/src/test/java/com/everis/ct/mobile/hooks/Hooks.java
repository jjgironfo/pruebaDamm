package com.everis.ct.mobile.hooks;

import com.everis.ct.mobile.lib.MobileDriverManager;
import com.everis.ct.mobile.service.stepdefinition.ManageScenario;
import io.cucumber.java.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private MobileDriverManager manager;

    @Autowired
    private ManageScenario scenario;

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }

    @ParameterType(value = "true|false")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }

    @Before
    public void handleScenario(Scenario scenario) {
        this.scenario.setScenario(scenario);
    }

    @After(order = 0)
    public void afterScenario() {
        manager.quitDriver();
    }

    @After(order = 1)
    public void tearDown() {
        scenario.shotWhenFail();
    }

}
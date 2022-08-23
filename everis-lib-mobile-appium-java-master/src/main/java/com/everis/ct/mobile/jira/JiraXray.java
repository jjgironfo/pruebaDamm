package com.everis.ct.mobile.jira;

import com.everis.ct.mobile.service.constans.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JiraXray {

    private static JiraXrayIntegration jiraXrayIntegration;

    @Autowired
    public JiraXray(JiraXrayIntegration jiraXrayIntegration) {
        JiraXray.jiraXrayIntegration = jiraXrayIntegration;
    }

    public static void importResults() {
        jiraXrayIntegration.importJXrayExecutionResults(Constants.NOT_DEFINED);
    }

    public static void importResults(String cucumberJsonPath) {
        jiraXrayIntegration.importJXrayExecutionResults(cucumberJsonPath);
    }

}
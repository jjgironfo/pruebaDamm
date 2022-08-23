package com.everis.ct.mobile.service.util;

import com.everis.ct.mobile.legacy.datasession.SessionData;
import io.cucumber.datatable.DataTable;
import org.apache.commons.lang3.NotImplementedException;

import java.util.logging.Logger;

public final class UtilMobile {

    private static final Class<? extends UtilMobile> THIS_CLASS = UtilMobile.class;

    public static Logger logger(Class className) {
        return Logger.getLogger(className.getName());
    }

    public static void waitForSeconds(int tiemOnSeconds) {
        try {
            Thread.sleep(tiemOnSeconds * 1000L);
        } catch (InterruptedException e) {
            UtilMobile.logger(THIS_CLASS).throwing(THIS_CLASS.getName(), "waitForSeconds", e);
        }
    }

    public static void saveVariableOnSession(String key, Object value) {
        SessionData.setSessionVariable(key).to(value);
    }

    public static <T> T getVariableOnSession(String key) {
        return SessionData.sessionVariableCalled(key);
    }

    public static String getValueFromDataTable(DataTable dataTable, String title) {
        if (dataTable.getTableConverter().getClass().getSimpleName().equalsIgnoreCase("DataTableTypeRegistryTableConverter"))
            return (String) dataTable.asMaps(String.class, String.class).get(0).get(title);
        else if (dataTable.getTableConverter().getClass().getSimpleName().equalsIgnoreCase("NoConverterDefined"))
            return dataTable.asMaps().get(0).get(title);
        else
            throw new NotImplementedException("DataTable getTableConverter() not implemented.");
    }

    public static String replaceBlank(String value) {
        return value.replace("[blank]", "");
    }

}
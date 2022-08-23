package com.everis.ct.mobile.service.config;

import com.everis.ct.mobile.service.constans.Constants;

public final class CheckProperties {

    public static boolean isDefinided(String property) {
        return !property.equals(Constants.NOT_DEFINED);
    }

    public static boolean isNotDefinided(String property) {
        return property.equals(Constants.NOT_DEFINED);
    }
}

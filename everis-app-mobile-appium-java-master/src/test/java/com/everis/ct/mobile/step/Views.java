package com.everis.ct.mobile.step;

import com.everis.ct.mobile.view.*;
import org.springframework.stereotype.Component;

@Component
public class Views {

    protected AccesoView acceso() {
        return new AccesoView();
    }

    protected LoginView login() {
        return new LoginView();
    }

    protected SettingView setting() {
        return new SettingView();
    }

    public HomeView home() {
        return new HomeView();
    }

    public MenuLateralView menuLateral() {
        return new MenuLateralView();
    }

    public ToolsView tools() {
        return new ToolsView();
    }
}


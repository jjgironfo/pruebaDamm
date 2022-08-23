package com.everis.ct.mobile.step;

import com.everis.ct.mobile.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ScreenShot
public class LoginStep {

    @Autowired
    private Views view;

    public void accesoPantallaLogin() {
        view.acceso().tapYaTengoCuenta();
    }

    public void aceptarTerminosGoogle(){
        view.login().tapTerminosGoogle();
    }

    public void aceptarSync(){
        view.login().tapSync();
    }

    public void introducirEmail(boolean scenario4){
        view.login().sendEmail(scenario4);
    }

    public void introducirPass(boolean scenario4) {
        view.login().sendPass(scenario4);
    }

    public void accederHome() {
        view.login().tapAcceder();
    }

    public void verificarHome(){
        view.home().verificarAcceso();
    }

}
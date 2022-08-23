package com.everis.ct.mobile.step;

import com.everis.ct.mobile.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ScreenShot
public class AccesoStep {

    @Autowired
    private Views view;

    public void aceptarNotificaciones() {
        view.acceso().tapAllowNotifications();
    }

    public void avanceTutorial() throws InterruptedException {
        view.acceso().verificarAperturaAplicacion();
        view.acceso().tapSiguiente();
        view.acceso().tapSiguiente();
        view.acceso().tapRegistrarEstablecimiento();
    }

    public void introducirPincode() {
        view.acceso().verificarPantallaIntroduccionCodigo();
        view.acceso().sendCodigoAcceso();
        view.acceso().tapSiguiente();
    }

    public void verificarErrorCodigo() {
        view.acceso().verificarErrorCodigo();
        view.acceso().tapAceptar();
    }

    public void accederConCuenta(){
        view.acceso().tapYaTengoCuenta();
    }

}
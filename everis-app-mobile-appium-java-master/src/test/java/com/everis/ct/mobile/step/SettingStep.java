package com.everis.ct.mobile.step;

import com.everis.ct.mobile.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@ScreenShot
public class SettingStep {


    @Autowired
    private Views view;

    public void verificarMenuConfig(){
        view.setting().verificarTituloUsuario();
    }

    public void accesoCambioPass(){
        view.setting().cambiarPass();
    }

    public void introducirPassActual(){
        view.setting().passActual();
    }

    public void introducirPassNueva(){
        view.setting().passNueva();
    }

    public void repetirPassNueva(){
        view.setting().repitePass();
    }

    public void introducirEmailActual(){
        view.setting().emailActual();
    }

    public void introducirEmailNuevo(){
        view.setting().emailNuevo();
    }

    public void repetirEmailNuevo(){
        view.setting().repiteEmail();
    }

    public void tapGuardar(){
        view.setting().botonGuardar();
    }

    public void pulsarCerrarSesion(){
        view.setting().cerrarSesion();
    }
    public void pulsarMisEstablecimientos(){
        view.setting().accesoMisEstablecimientos();
    }

    public void verificacionBarDefecto(){
        view.setting().verificarBarDefecto();
    }
    public void tapAtras(){
        view.setting().pulsarAtras();
    }

    public void tapAtrasCat(){
        view.setting().pulsarAtrasCat();
    }

    public void tapOtroNegocio(){
        view.setting().pulsarOtroNegocio();
    }

    public void tapBar1(){
        view.setting().pulsarBar1();
    }

    public void tapIdioma(){
        view.setting().accesoIdiomas();
    }

    public void tapEmail(){
        view.setting().accesoEmail();
    }

    public void tapCat(){
        view.setting().pulsarCat();
    }

    public void tapEsp(){
        view.setting().pulsarEsp();
    }

    public void tapAceptar(){
        view.setting().pulsarAceptar();
    }

    public void tapFlagConsumo(){
        view.setting().flagConsumo();
    }

    public void tapFlagPromociones(){
        view.setting().flagPromociones();
    }

    public void tapPopUpSi(){
        view.setting().aceptarPopUpConsumo();
    }

    public void tapPopUpIOS(){
        view.setting().aceptarPopUpIOS();
    }
}

package com.everis.ct.mobile.step;

import com.everis.ct.mobile.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ScreenShot
public class ToolsStep {

    @Autowired
    private Views view;

    public void verificarConsumo(){
        view.tools().verificarEncabezadoConsumo();
        view.tools().textoProducto();
        view.tools().textoMarcas();
    }

    public void verificarPromociones(){
        view.tools().verificarEncabezadoPromociones();
        view.tools().textoTodas();
        view.tools().textoMeInteresa();
    }

    public void verificarCartaDigital(){
        view.tools().logoHoreca();
        view.tools().botonVerCarta();
    }
}

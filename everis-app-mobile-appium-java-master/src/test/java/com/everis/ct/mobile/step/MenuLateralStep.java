package com.everis.ct.mobile.step;

import com.everis.ct.mobile.service.aspect.evidence.ScreenShot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ScreenShot
public class MenuLateralStep {

    @Autowired
    private Views view;

    public void tapConfiguracion(){
        view.menuLateral().tapBotonConfig();
    }

    public void tapMiNegocio(){view.menuLateral().pulsarMiNegocio();}

    public void tapConsumo(){view.menuLateral().pulsarConsumo();}

    public void tapPromociones(){view.menuLateral().pulsarPromociones();}
}

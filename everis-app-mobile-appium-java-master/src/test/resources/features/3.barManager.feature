#language: es
  #@Test
Característica: Regresion Damm - Bar Manager

  Antecedentes:
    Dado que abro la aplicacion
    Y que ya estoy registrado
    Entonces hago login con el email y la pass
    Y validar que se accede a la home

  Escenario: Caso5- Acceso a Bar Manager
    Dado que accedo al menu de configuracion
    Cuando accedo a mis establecimientos
    Y verifico el establecimiento por defecto
    Entonces retrocedo a la home y confirmo los datos del bar
    Y activo el flag de consumo


  Escenario: Caso6- Cambio de establecimiento
    Dado que pulso el selector de establecimiento
    Cuando cambio de negocio
    Entonces verifico que se ha realizado el cambio
    Y activo el flag de consumo


  Escenario: Caso7- Cambio de establecimiento predeterminado
    Dado que accedo al menu de configuracion
    Cuando accedo a mis establecimientos
    Y cambio el establecimiento predeterminado
    Entonces verifico que se ha realizado el cambio
    Y activo el flag de consumo
    Y hago logout, login y se reestablece el establecimiento por defecto
    Y activo el flag de consumo

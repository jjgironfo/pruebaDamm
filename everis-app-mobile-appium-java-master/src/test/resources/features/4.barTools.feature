#language: es
 # @Test
Característica: Regresion Damm - Bar Tools

  Antecedentes:
    Dado que abro la aplicacion
    Y que ya estoy registrado
    Entonces hago login con el email y la pass
    Y validar que se accede a la home


  Escenario: Caso8- Flag Consumos (USER PROMO)
    Dado que accedo al menu de configuracion
    Cuando desactivo el flag de consumo
    Y activo el flag de consumo
    Entonces entro al consumo desde el menu lateral


  Escenario: Caso9- Flag Promociones (USER PROMO)
    Dado que accedo al menu de configuracion
    Cuando desactivo el flag de promociones
    Y activo el flag de promociones
    Entonces entro a promociones desde el menu lateral


  Escenario: Caso10- Carta Digital (USER PROMO)
##     Se utiliza cuando la carta digital esta en el segundo establecimiento
    Dado que pulso el selector de establecimiento
    Cuando cambio de negocio
    Entonces accedo a Carta digital
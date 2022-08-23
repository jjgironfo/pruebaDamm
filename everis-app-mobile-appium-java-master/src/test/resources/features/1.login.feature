#language: es
#  @Test
Característica: Regresion Damm - Login

  Antecedentes:
    Dado que abro la aplicacion

  Escenario: Caso1- Alta pincode no válido
    Dado que registro mi establecimiento
    Cuando informo el pincode invalido
    Entonces validar que aparece un mensaje de error indicando que el pincode no es valido


  Escenario: Caso2- Log in - user activo
    Dado que ya estoy registrado
    Cuando hago login con el email y la pass
    Entonces validar que se accede a la home

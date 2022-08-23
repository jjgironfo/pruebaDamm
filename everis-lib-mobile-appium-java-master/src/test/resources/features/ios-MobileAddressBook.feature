@DEMO_IOS_GRID
Feature: MobileAddressBook

  Background:
    Given que abro la aplicacion MobileAddressBook

  @MobileAddressBook
  Scenario: caso1- Registrar un nuevo contacto
    Given que me encuentro en la seccion de agregar un nuevo usuario
    When ingreso los datos del nuevo contacto y lo agrego

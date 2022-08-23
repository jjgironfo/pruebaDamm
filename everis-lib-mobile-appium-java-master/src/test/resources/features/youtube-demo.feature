@DEMO
Feature: Regresion Youtube

  Background:
    Given que abro la aplicacion mobile

  @SEARCH_YOUTUBE
  Scenario Outline: caso1- Buscar video
    Given que busco el nuevo video "<video>"
    Then validar si hay mas de un resultado
    Examples:
      | video                 |
      | Spiderman Home Coming |

  @SEARCH_YOUTUBE
  Scenario Outline: caso2- Buscar video
    Given que busco el nuevo video "<video>"
    Then validar si hay mas de un resultado
    Examples:
      | video          |
      | Kenobi trailer |
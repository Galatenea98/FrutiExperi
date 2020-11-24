Feature: COMO cliente
  QUIERO poder comprar la membresía
  PARA poder publicar mis servicios en la plataforma

  Scenario: Comprar Membresía
    Given el cliente quiere publicar sus servicios
    When se registre
    Then deberá pagar la membresía del aplicativo

  Scenario: Cancelar Membresía
    Given el cliente quiere publicar servicios
    When se esté registrando
    Then deberá retroceder o dar click en "Cancelar" la opción que se muestra en la misma ventana

  Scenario: Pagar membresía
    Given el cliente haya adquirido una membresía
    When terminó de registrarse
    Then cada fin de mes deberá cancelar con la tarjta registrada
    And le llegará una notificación con el día de pago
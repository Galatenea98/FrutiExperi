Feature: COMO cliente
  QUIERO pagar el servicio ofrecido por un proveedor específico
  PARA culminar con el servicio solicitado

  Scenario: Pago Proveedor
    Given el cliente quiere realizar el pago respectivo por el servicio daodo
    When le de click a la parte superior y seleccione su perfil
    And aparecerá un botón que diga "Mis Registros"
    Then al darle click a ese botón, tendrá que darle click al servicio que desee pagar

  Scenario: Procesando pago
    Given el cliente se encuentre en el servicio a pagar
    When le de click al botón "Realizar pago"
    Then le aparecerá el siguiente mensaje "Procesando pago"

  Scenario: Envío de boleta de pago a correo electrónico
    Given el cliente se encuentre realizando el pago respectivo
    When oricese el pago
    Then se le mandará la boleta de pago a su correo electrónico
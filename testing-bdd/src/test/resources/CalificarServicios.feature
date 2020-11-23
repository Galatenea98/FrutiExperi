Feature: COMO cliente
  QUIERO calificar la experiencia que tuve al solicitar un servicio
  PARA que los demás puedan ver la calidad de ese servicio

  Scenario: Calificar Servicio
    Given el cliente quiere calificar un servicio
    When haya terminado el proveedor con su trabajo
    Then deberá ingresar al perfil del proveedor
    And en la sección de "Calificar" se encuentran estrellas en color blanco
    And debe hacer click en las estrellas donde 5 estrellas de color amarillo es Excelente

  Scenario: Revisar la calificación
    Given el cliente ya ha calificado un servicio
    When el proveedor termino su trabajo
    Then deberá revisar el perfil del proveeedor donde solo se va a mostrar un promedio de todas las calificaciones

  Scenario: Revisar calificación del servicio
    Given el cliente ha calificado el servicio de un proveedor
    When ingrese al perfil de dicho proveedor
    Then se le mostrará solo el promedio de todas las calificaciones
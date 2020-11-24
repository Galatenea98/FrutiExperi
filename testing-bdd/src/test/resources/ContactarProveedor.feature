Feature: COMO cliente
  QUIERO contactar con el proveedor del servicio que solicito
  PARA coordinar el horario de encuentro

  Scenario: Contactar servicio
    Given el cliente quiere contactar al proveedor
    When haya encontrado el servicio que requiere en el filtro de búsqueda
    Then deberá hacer click en el servicio
    And lo dirigirá a una vista para que pueda contactar al proveedor

  Scenario: Registrar reserva
    Given el cliente ya ha contactado al proveedor
    When hizo click en servicio
    Then deberá ingresar la fecha para requerir del servicio, una vez terminado la notificación
    And será enviada al proveedor para que lo tenga presente

  Scenario: Error al registrar solicitud
    Given el cliente ya se contactó con el proveedor del servicio seleccionado
    When registre la solicitud con información inválida
    Then se le mostrará un mensaje "Error al registrar solicitud"
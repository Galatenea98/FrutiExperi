Feature: COMO cliente
  QUIERO poder buscar servicios filtrados por servicios más solicitados
  PARA hacer más eficiente la búsqueda

  Scenario: Buscar un servicio de acuerdo a su popularidad
    Given el cliente quiere buscar un servicio que sea popular
    When busque un servicio
    Then deberá elegir la opción de filtrar los servicios por popularidad en el aplicativo

  Scenario: Visualización de los servicios de acuerdo con la popularidad
    Given el cliente ha filtrado servicios por popularidad
    When ingresa a la opción
    Then se muestra un página con todos los servicios en el aplicativo

  Scenario: Seleccionar servicio por servicios solicitados
    Given el cliente visualiza los servicios de acuerdo a la popularidad del proveedor
    When seleccine un servicio
    Then podrá gestionar la solicitud del servicio
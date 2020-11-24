Feature: COMO cliente
  QUIERO poder buscar servicios filtrados por tipo de servicio
  PARA para hacer más eficiente la búsqueda

  Scenario: Buscar un servicio por su tipo
    Given el cliente quiere encontrar un proveedor
    When busque un servicio determinado
    Then deberá elegir la opción de filtrar servicios por tipo de servicio en el buscador del aplicativo

  Scenario: Visualización del servicio buscado
    Given el cliente ha filtrado por tipo de servicio
    When omgresa eñ servocop qie desea buscar
    Then se muiestran una página con el servicio buscado por el cliente y sus diferentes proveedores

  Scenario: Seleccionar servicio por tipo de servicio
    Given el cliente visualiza los servicios del acuerdo a su tipo
    When selecciona un servicio
    Then podrá gestionar la solicitud de este
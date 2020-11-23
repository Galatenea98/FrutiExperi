Feature: COMO usuario
  QUIERO poder crearme una cuenta
  PARA poder insertar mi información personal y las descripciones correspondientes.

  Scenario: Cliente
    Given el usuario quiere buscar servicios
    When ingrese a la aplicación
    Then debe registrarse como cliente y rellenar los datos requeridos

  Scenario: Proveedor
    Given el usuario quiere publicar servicios
    When ingrese a la aplicación y ingrese
    Then debe registrarse como proveedor y rellenar los datos requeridos

  Scenario: Datos Incorrectos
    Given el usuario ha registrado los datos requeridos
    When le seleccione la opción registrarse sis su datos no son correctos
    Then se motrará el siguiente mensaje "sus datos no son válidos"
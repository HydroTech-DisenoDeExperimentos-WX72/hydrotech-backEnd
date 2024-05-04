Feature: Crear Trend

  Scenario: Crear un nuevo trend
    Given tengo acceso a la API REST
    When envío una solicitud POST para crear un nuevo trend con el nombre "Nuevo Trend"
    Then debería recibir una respuesta con código de estado 201 y el nuevo trend creado

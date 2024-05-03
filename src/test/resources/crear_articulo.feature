Feature: Crear Artículo a través de la API
  Como usuario de la API
  Quiero poder crear un nuevo artículo
  Para compartir información con otros usuarios

  Scenario: Crear un nuevo artículo a través de la API REST
    Given que tengo acceso a la API REST
    When envío una solicitud POST para crear un nuevo artículo con título "Curso de plantacion de papas" y descripcion "Contenido del artículo..." y fecha "03/05/24" y enlace "papasperuanas.com"
    Then debería recibir una respuesta con código de estado 201 y el nuevo artículo creado

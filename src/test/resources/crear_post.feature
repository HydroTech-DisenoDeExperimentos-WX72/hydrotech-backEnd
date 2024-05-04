Feature: Crear Post

  Scenario: Crear un nuevo post
    Given tengo acceso a la API REST
    When envío una solicitud POST para crear un nuevo post con los siguientes datos:
      | title       | author   | date       | image         | description   | views | likes | comments | tag     |
      | Nuevo Post  | Autor    | 2024-05-03 | imagen1.jpg   | Descripción...| 0     | 0     | 0        | Etiqueta|
    Then debería recibir una respuesta con código de estado 201 y el nuevo post creado

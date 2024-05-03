Feature: Crear Curso a través de la API REST
  Como administrador de la plataforma
  Quiero poder crear un nuevo curso
  Para ofrecer contenido educativo a los usuarios

  Scenario: Crear un nuevo curso a través de la API REST
    Given que tengo acceso a la API REST
    When envío una solicitud POST para crear un nuevo curso con los siguientes datos:
      | name        | image        | description    | price | rating | duration | category  | date        |
      | Curso Test  | imagen1.jpg  | Descripción... | 100   | 4.5    | 3 meses  | Informática| 2024-05-10  |
    Then debería recibir una respuesta con código de estado 201 y el nuevo curso creado

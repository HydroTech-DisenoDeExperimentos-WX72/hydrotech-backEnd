package com.hydrotech.backend;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import com.google.gson.Gson;

public class CrearArticuloRestSteps {
    private Response response;
    private RequestSpecification request;

    @Given("que tengo acceso a la API REST")
    public void checarAccesso() {
        RestAssured.baseURI = "http://localhost:8080/api/hydro-tech/v1"; 
    }

    @When("envío una solicitud POST para crear un nuevo artículo con título {string} y descripcion {string} y fecha {string} y enlace {string} y imagen {string}")
    public void enviarSolicitudCrearArticulo(String titulo, String descripcion, String fecha, String enlace, String imagen) {

        JSONObject requestBody = new JSONObject();
        requestBody.put("titulo",titulo);
        requestBody.put("descripcion", descripcion);
        requestBody.put("fecha", fecha);
        requestBody.put("enlace", enlace);
        requestBody.put("imagen", imagen);

        request = given().contentType("application/json").body(requestBody.toString());
        response = request.when().post("/articles");
    }

    @Then("debería recibir una respuesta con código de estado {int} y el nuevo artículo creado")
    public void verificarRespuestaCrearArticulo(int statusCode) {
        response.then().statusCode(statusCode).body("titulo", equalTo("Curso de plantacion de papas")).body("descripcion", equalTo("Contenido del artículo..."));
    }
}


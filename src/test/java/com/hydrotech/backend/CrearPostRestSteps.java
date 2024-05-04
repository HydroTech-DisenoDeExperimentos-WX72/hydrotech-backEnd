package com.hydrotech.backend;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import com.google.gson.Gson;

public class CrearPostRestSteps {
    private Response response;
    private RequestSpecification request;

    @Given("tengo acceso a la API REST")
    public void checarAccesso() {
         RestAssured.baseURI = "http://localhost:8080/api/hydro-tech/v1"; 
    }

    @When("envío una solicitud POST para crear un nuevo post con los siguientes datos:")
    public void enviarSolicitudCrearPost(Map<String, String> datosPost) {
        Gson gson = new Gson();
        String requestBody = gson.toJson(datosPost);

        request = given().contentType("application/json").body(requestBody);
        response = request.when().post("/posts");
    }

    @Then("debería recibir una respuesta con código de estado {int} y el nuevo post creado")
    public void verificarRespuestaCrearPost(int statusCode) {
        response.then().statusCode(statusCode);
    }
}

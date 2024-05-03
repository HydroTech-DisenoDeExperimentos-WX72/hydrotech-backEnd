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

public class CrearCursoRestSteps {
    private Response response;
    private RequestSpecification request;

    @Given("que tengo acceso a la API REST")
    public void checarAccesso() {
         RestAssured.baseURI = "http://localhost:8080/api/hydro-tech/v1"; 
    }

    @When("envío una solicitud POST para crear un nuevo curso con los siguientes datos:")
    public void enviarSolicitudCrearCurso(Map<String, String> datosCurso) {
        Gson gson = new Gson();
        String requestBody = gson.toJson(datosCurso);

        request = given().contentType("application/json").body(requestBody);
        response = request.when().post("/courses");
    }

    @Then("debería recibir una respuesta con código de estado {int} y el nuevo curso creado")
    public void verificarRespuestaCrearCurso(int statusCode) {
        response.then().statusCode(statusCode);
    }
}
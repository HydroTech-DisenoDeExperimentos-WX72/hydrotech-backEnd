package com.hydrotech.backend;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CrearTrendRestSteps {
    private Response response;
    private RequestSpecification request;

    @Given("tengo acceso a la API REST")
    public void checarAccesso() {
         RestAssured.baseURI = "http://localhost:8080/api/hydro-tech/v1"; 
    }

    @When("envío una solicitud POST para crear un nuevo trend con el nombre {string}")
    public void enviarSolicitudCrearTrend(String nombreTrend) {
        request = given().contentType("application/json").body("{\"name\": \"" + nombreTrend + "\"}");
        response = request.when().post("/trends");
    }

    @Then("debería recibir una respuesta con código de estado {int} y el nuevo trend creado")
    public void verificarRespuestaCrearTren(int statusCode) {
        response.then().statusCode(statusCode);
    }
}

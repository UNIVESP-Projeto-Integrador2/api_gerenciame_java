package com.gerenciame.api.tests;

import com.gerenciame.api.core.Constantes;
import com.gerenciame.api.utils.MassaDeDadosTarefas;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class TarefasPost {

    private RequestSpecification request;
    private ValidatableResponse response;

    @Before("@TarefasPost")
    public void setup(){
        RestAssured.baseURI = Constantes.BASE_URI;
        response = null;
    }

    @Dado("que estamos realizando uma chamada para o endpoint TarefasPost")
    public void queEstamosRealizandoUmaChamadaParaOEndpointTarefasPost() {
        request = null;
    }
    @Quando("preenchermos o body {string} do endpoint TarefasPost")
    public void preenchermosOBodyDoEndpointTarefasPost(String body) {
        if (body.equals("valido")){
            request = RestAssured.given().body(MassaDeDadosTarefas.bodyValidoPost);
        } else if (body.equals("tipoDif")) {
            request = RestAssured.given().body(MassaDeDadosTarefas.bodyTipagemDiferente);
        } else if (body.equals("limites")) {
            request = RestAssured.given().body(MassaDeDadosTarefas.bodyLimite);
        } else if (body.equals("obg")) {
            request = RestAssured.given().body(MassaDeDadosTarefas.bodyObrigatoriedade);
        } else if (body.equals("vazio")) {
            request = RestAssured.given().body(MassaDeDadosTarefas.bodyVazio);
        } else {
            request = RestAssured.given().body(MassaDeDadosTarefas.bodyNulo);
        }
    }
    @E("realizarmos a chamada do endpoint TarefasPost")
    public void realizarmosAChamadaDoEndpointTarefasPost() {
        request = request.header("Content-Type", "application/json");
        response = request.when().post("/tarefas").then();
    }
    @Entao("o resultado da chamada sera {int} do endpoint TarefasPost")
    public void oResultadoDaChamadaSeraDoEndpointTarefasPost(Integer status) {
        response.statusCode(status);
    }
    @E("o retorno sera {string} do endpoint TarefasPost")
    public void oRetornoSeraDoEndpointTarefasPost(String resposta) {
        switch (resposta) {
            default:
                break;

            case "badRequest":
                response.body("error",
                        equalTo("Bad Request"));
                break;
        }
    }
}
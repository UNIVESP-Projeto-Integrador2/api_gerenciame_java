package com.gerenciame.api.tests;

import com.gerenciame.api.core.Constantes;
import com.gerenciame.api.utils.MassaDeDadosSubtarefas;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class SubtarefasPost {

    private RequestSpecification request;
    private ValidatableResponse response;

    @Before("@SubtarefasPost")
    public void setup(){
        RestAssured.baseURI = Constantes.BASE_URI;
        response = null;
    }

    @Dado("que estamos realizando uma chamada para o endpoint SubtarefasPost")
    public void queEstamosRealizandoUmaChamadaParaOEndpointSubtarefasPost() {
        request =  null;
    }
    @Quando("preenchermos o body {string} do endpoint SubtarefasPost")
    public void preenchermosOBodyDoEndpointSubtarefasPost(String body) {
        if (body.equals("valido")){
            request = RestAssured.given().body(MassaDeDadosSubtarefas.bodyValidoPost);
        } else if (body.equals("tipoDif")) {
            request = RestAssured.given().body(MassaDeDadosSubtarefas.bodyTipagemDiferente);
        } else if (body.equals("limites")) {
            request = RestAssured.given().body(MassaDeDadosSubtarefas.bodyLimite);
        } else if (body.equals("obg")) {
            request = RestAssured.given().body(MassaDeDadosSubtarefas.bodyObrigatoriedade);
        } else if (body.equals("vazio")) {
            request = RestAssured.given().body(MassaDeDadosSubtarefas.bodyVazio);
        } else {
            request = RestAssured.given().body(MassaDeDadosSubtarefas.bodyNulo);
        }
    }
    @Quando("realizarmos a chamada do endpoint SubtarefasPost")
    public void realizarmosAChamadaDoEndpointSubtarefasPost() {
        request = request.header("Content-Type", "application/json");
        response = request.when().post("/subtarefas").then();
    }
    @Entao("o resultado da chamada sera {int} do endpoint SubtarefasPost")
    public void oResultadoDaChamadaSeraDoEndpointSubtarefasPost(Integer status) {
        response.statusCode(status);
    }
    @Entao("o retorno sera {string} do endpoint SubtarefasPost")
    public void oRetornoSeraDoEndpointSubtarefasPost(String resposta) {
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

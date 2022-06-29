package com.gerenciame.api.tests;

import com.gerenciame.api.core.Constantes;
import com.gerenciame.api.utils.MassaDeDadosSubtarefas;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class SubtarefasPut {
    private RequestSpecification request;
    private ValidatableResponse response;

    @Before("@SubtarefasPut")
    public void setup(){
        RestAssured.baseURI = Constantes.BASE_URI;
        response = null;
    }

    @Dado("que estamos realizando uma chamada para o endpoint SubtarefasPut")
    public void queEstamosRealizandoUmaChamadaParaOEndpointSubtarefasPut() {
        request = null;
    }
    @Quando("preenchermos o body {string} do endpoint SubtarefasPut")
    public void preenchermosOBodyDoEndpointSubtarefasPut(String body) {
        if (body.equals("valido")){
            request = RestAssured.given().body(MassaDeDadosSubtarefas.bodyValidoPut);
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
    @Quando("realizarmos a chamada do endpoint SubtarefasPut com {string}")
    public void realizarmosAChamadaDoEndpointSubtarefasPutCom(String idSubtarefa) {
        request = request.header("Content-Type", "application/json");
        response = request.when().put("/subtarefas/" + idSubtarefa).then();
    }
    @Entao("o resultado da chamada sera {int} do endpoint SubtarefasPut")
    public void oResultadoDaChamadaSeraDoEndpointSubtarefasPut(Integer status) {
        response.statusCode(status);
    }
    @E("o retorno sera {string} do endpoint SubtarefasPut")
    public void oRetornoSeraDoEndpointSubtarefasPut(String resposta) {
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

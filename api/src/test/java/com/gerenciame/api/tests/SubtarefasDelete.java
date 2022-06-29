package com.gerenciame.api.tests;

import com.gerenciame.api.core.Constantes;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;


public class SubtarefasDelete {

    private RequestSpecification request;
    private ValidatableResponse response;

    @Before("@SubtarefasDelete")
    public void setup(){
        RestAssured.baseURI = Constantes.BASE_URI;
        response = null;
    }

    @Dado("que estamos realizando uma chamada para o endpoint SubtarefasDelete")
    public void queEstamosRealizandoUmaChamadaParaOEndpointSubtarefasDelete() {
        request =  null;
    }

    @Quando("realizarmos a chamada do endpoint SubtarefasDelete com {string}")
    public void realizarmosAChamadaDoEndpointSubtarefasDeleteCom(String idSubtarefa) {
        request = RestAssured.given().header("Content-Type", "application/json");
        response = request.when().delete("/subtarefas/" + idSubtarefa).then();
    }

    @Entao("o resultado da chamada sera {int} do endpoint SubtarefasDelete")
    public void oResultadoDaChamadaSeraDoEndpointSubtarefasDelete(Integer status) {
        response.statusCode(status);
    }

    @E("o retorno sera {string} do endpoint SubtarefasDelete")
    public void oRetornoSeraDoEndpointSubtarefasDelete(String resposta) {
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

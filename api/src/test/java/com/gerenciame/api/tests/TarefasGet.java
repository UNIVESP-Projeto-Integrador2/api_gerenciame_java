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

public class TarefasGet {
    private RequestSpecification request;
    private ValidatableResponse response;

    @Before("@TarefasGet")
    public void setup(){
        RestAssured.baseURI = Constantes.BASE_URI;
        response = null;
    }

    @Dado("que estamos realizando uma chamada para o endpoint TarefasGet")
    public void queEstamosRealizandoUmaChamadaParaOEndpointTarefasGet() {
        request = RestAssured.given();
    }
    @Quando("realizarmos a chamada do endpoint TarefasGet")
    public void realizarmosAChamadaDoEndpointTarefasGet() {
        request = request.header("Content-Type", "application/json");
        response = request.when().get("/tarefas").then();
    }
    @Entao("o resultado da chamada sera {int} do endpoint TarefasGet")
    public void oResultadoDaChamadaSeraDoEndpointTarefasGet(Integer status) {
        response.statusCode(status);
    }
    @E("o retorno sera ok do endpoint TarefasGet")
    public void oRetornoSeraOkDoEndpointTarefasGet() {
        response.body("id_tarefa[0]", is(1));
        response.body("nome_tarefa[0]", containsString("tarefa 1"));
        response.body("data_inicial[0]", equalTo("2022-06-30"));
        response.body("data_limite[0]", equalTo("2022-07-29"));
        response.body("hora[0]", equalTo("10:30:00"));
        response.body("status[0]", equalTo("A_FAZER"));
        response.body("descricao[0]", equalTo("testando o post 1"));
        response.body("subtarefas[0]", is(notNullValue()));
        response.body("subtarefas[0].id_subtarefa[0]", is(notNullValue()));
        response.body("subtarefas[0].id_tarefa[0]", is(1));
        response.body("subtarefas[0].nome_subtarefa[0]", containsString("nome teste"));
        response.body("subtarefas[0].status_subtarefa[0]", equalTo("A_FAZER"));

    }



}

package com.gerenciame.api.utils;

public class MassaDeDadosTarefas {

    public static final String bodyValidoPost = "{\n" +
            "    \"nome_tarefa\":\"tarefa teste\",\n" +
            "    \"data_inicial\":\"2022-06-27\",\n" +
            "    \"data_limite\":\"2022-06-30\",\n" +
            "    \"status\": \"A_FAZER\",\n" +
            "    \"hora\":\"10:30:00\",\n" +
            "    \"descricao\":\"testando o post\"\n" +
            "}";
    public static final String bodyValidoPut = "{\n" +
            "    \"nome_tarefa\":\"tarefa teste modificada\",\n" +
            "    \"data_inicial\":\"2022-03-25\",\n" +
            "    \"data_limite\":\"2022-03-28\",\n" +
            "    \"status\": \"FAZENDO\",\n" +
            "    \"hora\":\"10:32:00\",\n" +
            "    \"descricao\":\"testando o put\"\n" +
            "}";
    public static final String bodyTipagemDiferente = "{\n" +
            "    \"nome_tarefa\":123456,\n" +
            "    \"data_inicial\":\"20/05/2022\",\n" +
            "    \"data_limite\":\"21/05/2022\",\n" +
            "    \"status\": 123,\n" +
            "    \"hora\": 1030,\n" +
            "    \"descricao\": 1234567\n" +
            "}";
    public static final String bodyLimite = "{\n" +
            "    \"nome_tarefa\":\"123456789012345678901234567890123456789012345678901\",\n" +
            "    \"data_inicial\":\"12345678901\",\n" +
            "    \"data_limite\":\"12345678901\",\n" +
            "    \"status\": \"A_FAZER\",\n" +
            "    \"hora\":\"99:99:99\",\n" +
            "    \"descricao\":\"12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901\"\n" +
            "}";
    public static final String bodyObrigatoriedade = "{\n" +
            "    \"nome_tarefa\":\"tarefa teste\",\n" +
            "    \"data_inicial\":\"2022-06-27\",\n" +
            "    \"data_limite\":\"2022-06-30\",\n" +
            "    \"hora\":\"10:30:00\",\n" +
            "    \"descricao\":\"testando o post\"\n" +
            "}";
    public static final String bodyNulo = "{\n" +
            "    \"nome_tarefa\": null,\n" +
            "    \"data_inicial\": null,\n" +
            "    \"data_limite\": null,\n" +
            "    \"status\":  null,\n" +
            "    \"hora\": null,\n" +
            "    \"descricao\": null\n" +
            "}";

    public static final String bodyVazio = "{}";
}

package com.gerenciame.api.utils;

public class MassaDeDadosSubtarefas {

    public static final String bodyValidoPost = "{\n" +
            "  \"id_tarefa\": 1,\n" +
            "  \"nome_subtarefa\": \"nome teste subtarefa\",\n" +
            "  \"anexo_subtarefa\": \"teste\",\n" +
            "  \"status_subtarefa\": \"A_FAZER\"\n" +
            "}";
    public static final String bodyValidoPut = "{\n" +
            "  \"id_tarefa\": 1,\n" +
            "  \"nome_subtarefa\": \"nome alterado subtarefa\",\n" +
            "  \"anexo_subtarefa\": \"teste2\",\n" +
            "  \"status_subtarefa\": \"FAZENDO\"\n" +
            "}";
    public static final String bodyTipagemDiferente = "{\n" +
            "  \"id_tarefa\": \"teste\",\n" +
            "  \"nome_subtarefa\": ,\n" +
            "  \"anexo_subtarefa\": 1.45,\n" +
            "  \"status_subtarefa\": \"done\"\n" +
            "}";
    public static final String bodyLimite = "{\n" +
            "  \"id_tarefa\": \"teste\",\n" +
            "  \"nome_subtarefa\": \"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901\",\n" +
            "  \"anexo_subtarefa\": 1.45,\n" +
            "  \"status_subtarefa\": \"12345678\"\n" +
            "}";
    public static final String bodyObrigatoriedade = "{\n" +
            "    \"id_tarefa\": \"1\",\n" +
            "    \"nome_subtarefa\": \"nome teste\",\n" +
            "    \"status_subtarefa\": \"FAZENDO\"\n" +
            "}";
    public static final String bodyVazio = "{}";
    public static final String bodyNulo = "{\n" +
            "  \"id_tarefa\": null,\n" +
            "  \"nome_subtarefa\": null,\n" +
            "  \"anexo_subtarefa\": null,\n" +
            "  \"status_subtarefa\": null\n" +
            "}";
}

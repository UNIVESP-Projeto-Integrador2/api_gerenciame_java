package com.gerenciame.api.controller.response;

import java.io.File;

public class SubtarefaResponse {

    private Long id_subtarefa;

    private Long id_tarefa;

    private String nome_subtarefa;

    private File anexo_subtarefa;

    private String status_subtarefa;

    public SubtarefaResponse(Long id_subtarefa, Long id_tarefa, String nome_subtarefa, File anexo_subtarefa, String status_subtarefa) {
        this.id_subtarefa = id_subtarefa;
        this.id_tarefa = id_tarefa;
        this.nome_subtarefa = nome_subtarefa;
        this.anexo_subtarefa = anexo_subtarefa;
        this.status_subtarefa = status_subtarefa;
    }

    public Long getId_subtarefa() {
        return id_subtarefa;
    }

    public Long getId_tarefa() {
        return id_tarefa;
    }

    public String getNome_subtarefa() {
        return nome_subtarefa;
    }

    public File getAnexo_subtarefa() {
        return anexo_subtarefa;
    }

    public String getStatus_subtarefa() {
        return status_subtarefa;
    }
}

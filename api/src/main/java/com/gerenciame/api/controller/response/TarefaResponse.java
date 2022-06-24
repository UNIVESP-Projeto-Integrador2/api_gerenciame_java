package com.gerenciame.api.controller.response;

import com.gerenciame.api.controller.response.SubtarefaResponse;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;

public class TarefaResponse {

    private Long id_tarefa;

    private String nome_tarefa;

    private LocalDate data_inicial;

    private LocalDate data_limite;

    private Time hora;

    private String status;

    private String descricao;

    private Set<SubtarefaResponse> subtarefas;

    @Deprecated
    public TarefaResponse(){}

    public TarefaResponse(Long id_tarefa, String nome_tarefa, LocalDate data_inicial, LocalDate data_limite, Time hora,
                          String status, String descricao, Set<SubtarefaResponse> subtarefas) {
        this.id_tarefa = id_tarefa;
        this.nome_tarefa = nome_tarefa;
        this.data_inicial = data_inicial;
        this.data_limite = data_limite;
        this.hora = hora;
        this.status = status;
        this.descricao = descricao;
        this.subtarefas = subtarefas;
    }

    public Long getId_tarefa() {
        return id_tarefa;
    }

    public String getNome_tarefa() {
        return nome_tarefa;
    }

    public LocalDate getData_inicial() {
        return data_inicial;
    }

    public LocalDate getData_limite() {
        return data_limite;
    }

    public Time getHora() {
        return hora;
    }

    public String getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public Set<SubtarefaResponse> getSubtarefas() {
        return subtarefas;
    }
}



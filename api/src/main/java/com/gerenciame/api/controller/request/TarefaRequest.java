package com.gerenciame.api.controller.request;

import com.gerenciame.api.model.Tarefa;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalDate;

public class TarefaRequest {
    @NotBlank
    @Size(max = 50)
    private String nome_tarefa;

    @NotBlank
    private LocalDate data_inicial;

    @NotBlank
    @Future
    private LocalDate data_limite;

    @NotBlank
    private Time hora;

    @Size(max = 100)
    private String descricao;

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

    public String getDescricao() {
        return descricao;
    }

    public static Tarefa toModel (TarefaRequest request){
        return new Tarefa(request.getNome_tarefa(), request.getData_inicial(), request.getData_limite(),
                request.getHora(), request.getDescricao());
    }
}

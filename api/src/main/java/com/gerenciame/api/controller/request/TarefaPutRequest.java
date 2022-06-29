package com.gerenciame.api.controller.request;

import com.gerenciame.api.model.StatusTarefa;

import javax.validation.constraints.*;
import java.sql.Time;
import java.time.LocalDate;

public class TarefaPutRequest {

    @Size(max = 50) @NotNull @NotBlank
    private String nome_tarefa;

    @NotNull @NotBlank
    private LocalDate data_inicial;

    @Future @NotNull @NotBlank
    private LocalDate data_limite;

    private Time hora;

    @NotNull @NotBlank
    private StatusTarefa status;

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

    public StatusTarefa getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }
}

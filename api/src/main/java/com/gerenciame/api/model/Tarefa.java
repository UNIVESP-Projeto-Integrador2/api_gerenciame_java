package com.gerenciame.api.model;

import com.gerenciame.api.controller.request.TarefaPutRequest;
import com.gerenciame.api.controller.response.TarefaResponse;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tarefa;

    @Size(max = 50)
    @Column(nullable = false)
    private String nome_tarefa;

    @Column(nullable = false)
    private LocalDate data_inicial;

    @Column(nullable = false)
    private LocalDate data_limite;

    private Time hora;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @Size(max = 50)
    private String descricao;

    @OneToMany(mappedBy = "tarefa", cascade = CascadeType.ALL)
    private Set<Subtarefa> subtarefas = new HashSet<>();

    @Deprecated // nao usar, existe por causa do JPA
    public Tarefa() {}

    public Tarefa(String nome_tarefa,
                  LocalDate data_inicial, LocalDate data_limite, Time hora,
                  String descricao) {
        this.nome_tarefa = nome_tarefa;
        this.data_inicial = data_inicial;
        this.data_limite = data_limite;
        this.hora = hora;
        this.status = StatusTarefa.A_FAZER;
        this.descricao = descricao;
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

    public StatusTarefa getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public Set<Subtarefa> getSubtarefas() {
        return subtarefas;
    }

    public void setNome_tarefa(String nome_tarefa) {
        this.nome_tarefa = nome_tarefa;
    }

    public void setData_inicial(LocalDate data_inicial) {
        this.data_inicial = data_inicial;
    }

    public void setData_limite(LocalDate data_limite) {
        this.data_limite = data_limite;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void atualiza(TarefaPutRequest tarefa) {
        if(tarefa.getNome_tarefa() != null){
            this.setNome_tarefa(tarefa.getNome_tarefa());
        }

        if(tarefa.getData_inicial() != null){
            this.setData_inicial(tarefa.getData_inicial());
        }

        if (tarefa.getData_limite() != null){
            this.setData_limite(tarefa.getData_limite());
        }

        if(tarefa.getHora() != null){
            this.setHora(tarefa.getHora());
        }

        if(tarefa.getStatus() != null){
            this.setStatus(tarefa.getStatus());
        }

        if(tarefa.getDescricao() != null){
            this.setDescricao(tarefa.getDescricao());
        }
    }

    public static List<TarefaResponse> toListResponse(List<Tarefa> tarefas) {
        return tarefas.stream().map(Tarefa::toResponse).collect(Collectors.toList());
    }

    public static TarefaResponse toResponse(Tarefa tarefa){
        return new TarefaResponse(tarefa.getId_tarefa(),tarefa.getNome_tarefa(),
                tarefa.getData_inicial(), tarefa.getData_limite(),
                tarefa.getHora(), tarefa.getStatus().name(), tarefa.getDescricao(), Subtarefa.toSetResponse(tarefa.getSubtarefas()));
    }
}

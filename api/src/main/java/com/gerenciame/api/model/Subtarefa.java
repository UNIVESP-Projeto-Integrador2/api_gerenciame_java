package com.gerenciame.api.model;

import com.gerenciame.api.controller.request.SubtarefaPutRequest;
import com.gerenciame.api.controller.response.SubtarefaResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Subtarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_subtarefa;

    @ManyToOne
    @Column(nullable = false)
    private Tarefa tarefa;

    @Size(max = 200)
    @Column(nullable = false)
    private String nome_subtarefa;

    private File anexo_subtarefa; //MultipartFile??

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusSubtarefa status_subtarefa;

    public Subtarefa(String nome_subtarefa, File anexo_subtarefa) {
        this.nome_subtarefa = nome_subtarefa;
        this.anexo_subtarefa = anexo_subtarefa;
        this.status_subtarefa = StatusSubtarefa.A_FAZER;
    }

    public Subtarefa() {}

    public Long getId_subtarefa() {
        return id_subtarefa;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public String getNome_subtarefa() {
        return nome_subtarefa;
    }

    public File getAnexo_subtarefa() {
        return anexo_subtarefa;
    }

    public void setNome_subtarefa(String nome_subtarefa) {
        this.nome_subtarefa = nome_subtarefa;
    }

    public void setAnexo_subtarefa(File anexo_subtarefa) {
        this.anexo_subtarefa = anexo_subtarefa;
    }

    public void setStatus_subtarefa(StatusSubtarefa status_subtarefa) {
        this.status_subtarefa = status_subtarefa;
    }

    public void setTarefa(Tarefa tarefa){
        this.tarefa = tarefa;
    }

    public StatusSubtarefa getStatus_subtarefa() {
        return status_subtarefa;
    }

    public void atualiza(SubtarefaPutRequest subtarefa) {
        if(subtarefa.getNome_subtarefa() != null){
            this.setNome_subtarefa(subtarefa.getNome_subtarefa());
        }

        if(subtarefa.getAnexo_subtarefa() != null){
            this.setAnexo_subtarefa(subtarefa.getAnexo_subtarefa());
        }

        if (subtarefa.getStatus_subtarefa() != null){
            this.setStatus_subtarefa(subtarefa.getStatus_subtarefa());
        }

    }

    public static Set<SubtarefaResponse> toSetResponse(Set<Subtarefa> subtarefas) {
        return subtarefas.stream().map(Subtarefa::toResponse).collect(Collectors.toSet());
    }

    public static SubtarefaResponse toResponse(Subtarefa subtarefa){
        return new SubtarefaResponse(subtarefa.getId_subtarefa(),
                subtarefa.getTarefa().getId_tarefa(), subtarefa.getNome_subtarefa(),
                subtarefa.getAnexo_subtarefa(), subtarefa.getStatus_subtarefa().name());
    }
}

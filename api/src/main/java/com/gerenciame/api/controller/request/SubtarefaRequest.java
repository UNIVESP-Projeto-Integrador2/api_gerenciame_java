package com.gerenciame.api.controller.request;

import com.gerenciame.api.model.Subtarefa;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;

public class SubtarefaRequest {

    @NotNull
    private Long id_tarefa;

    @NotBlank
    @Size(max = 200)
    private String nome_subtarefa;

    private File anexo_subtarefa;

    public static Set<Subtarefa> toSetModel(Set<SubtarefaRequest> subtarefas) {
                return subtarefas.stream().map(SubtarefaRequest::toModel).collect(Collectors.toSet());
    }

    public static Subtarefa toModel(SubtarefaRequest request){
        return new Subtarefa(request.getNome_subtarefa(), request.getAnexo_subtarefa());
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

}

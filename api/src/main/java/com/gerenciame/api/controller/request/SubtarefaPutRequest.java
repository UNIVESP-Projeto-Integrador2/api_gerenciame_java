package com.gerenciame.api.controller.request;

import com.gerenciame.api.model.StatusSubtarefa;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.File;

public class SubtarefaPutRequest {

    @Size(max = 200) @NotBlank
    private String nome_subtarefa;

    private File anexo_subtarefa;

    @NotNull
    private StatusSubtarefa status_subtarefa;

    public String getNome_subtarefa() {
        return nome_subtarefa;
    }

    public File getAnexo_subtarefa() {
        return anexo_subtarefa;
    }

    public StatusSubtarefa getStatus_subtarefa() {
        return status_subtarefa;
    }

}

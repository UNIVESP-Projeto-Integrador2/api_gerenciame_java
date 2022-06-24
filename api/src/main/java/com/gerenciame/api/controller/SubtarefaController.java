package com.gerenciame.api.controller;

import com.gerenciame.api.controller.request.SubtarefaPutRequest;
import com.gerenciame.api.controller.request.SubtarefaRequest;
import com.gerenciame.api.model.Subtarefa;
import com.gerenciame.api.model.Tarefa;
import com.gerenciame.api.repository.SubtarefaRepository;
import com.gerenciame.api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/subtarefas")
public class SubtarefaController {

    @Autowired // injeção de dependência (o controller depende do repository)
    SubtarefaRepository repository;
    @Autowired
    TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<?> postSubtarefa(@RequestBody SubtarefaRequest request){
        //valida se tarefa existe
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(request.getId_tarefa());
        if(!tarefaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().body("ID tarefa não existe");
        }
        Tarefa tarefa = tarefaOptional.get();

        Subtarefa subtarefa= SubtarefaRequest.toModel(request);
        subtarefa.setTarefa(tarefa);

        repository.save(subtarefa);

        return ResponseEntity.status(201).build();
    }

    @Transactional
    @PutMapping("/{id_subtarefa}")
    public ResponseEntity<?> putSubtarefa(@PathVariable Long id_subtarefa, @RequestBody SubtarefaPutRequest request) {
        Optional<Subtarefa> subtarefaOptional = repository.findById(id_subtarefa);
        if (!subtarefaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Subtarefa subtarefa = subtarefaOptional.get();
        subtarefa.atualiza(request);

        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id_subtarefa}")
    public ResponseEntity<?> deleteTarefa(@PathVariable Long id_subtarefa){

        Optional<Subtarefa> subtarefaOptional = repository.findById(id_subtarefa);

        if(!subtarefaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id_subtarefa);

        return ResponseEntity.ok().build();
    }
}

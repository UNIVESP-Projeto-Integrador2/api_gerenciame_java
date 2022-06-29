package com.gerenciame.api.controller;

import com.gerenciame.api.controller.request.TarefaPutRequest;
import com.gerenciame.api.controller.request.TarefaRequest;
import com.gerenciame.api.controller.response.TarefaResponse;
import com.gerenciame.api.model.Tarefa;
import com.gerenciame.api.repository.SubtarefaRepository;
import com.gerenciame.api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired// injeção de dependência (o controller depende do repository)
    private TarefaRepository repository;
    @Autowired
    private SubtarefaRepository subtarefaRepository;

    @GetMapping
    public ResponseEntity<List<TarefaResponse>> getAllTarefas(){
        List<Tarefa> tarefas = repository.findAll();

        List<TarefaResponse> response = Tarefa.toListResponse(tarefas);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<TarefaResponse> postTarefa(@Validated @RequestBody TarefaRequest request){
        Tarefa tarefa = TarefaRequest.toModel(request);

        repository.save(tarefa);

        TarefaResponse tarefaResponse = Tarefa.toResponse(tarefa);
        return ResponseEntity.status(201).body(tarefaResponse);
    }

    @Transactional
    @PutMapping("/{id_tarefa}")
    public ResponseEntity<?> putTarefa(@Validated @PathVariable Long id_tarefa, @RequestBody TarefaPutRequest request){
        Optional<Tarefa> tarefaOptional= repository.findById(id_tarefa);
        if(!tarefaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Tarefa tarefa = tarefaOptional.get();
        tarefa.atualiza(request);

        return ResponseEntity.status(200).build();

//        //valida se id tarefa existe
//        boolean idExiste = repository.existsById(id_tarefa);
//        if(!idExiste){
//            return ResponseEntity.notFound().build();
//        }
//
//        //busca tarefa no banco
//        Tarefa tarefa = repository.findById(id_tarefa).get();
//
//        List<Subtarefa> listaCriaSubtarefa = new ArrayList<>();
//        List<Subtarefa> listaAtualizaSubtarefa = new ArrayList<>();
//
//        //valida se ids subtarefas existem
//        for(Subtarefa sub : tarefa.getSubtarefas()){
//            Optional<Subtarefa> subtarefaOptional = subtarefaRepository.findById(sub.getId_subtarefa());
//            if(!subtarefaOptional.isPresent()){
//                listaCriaSubtarefa.add(sub);
//            }
//            listaAtualizaSubtarefa.add(sub);
//        }
    }

    @Transactional
    @DeleteMapping("/{id_tarefa}")
    public ResponseEntity<?> deleteTarefa(@Validated @PathVariable Long id_tarefa){

        Optional<Tarefa> tarefaOptional = repository.findById(id_tarefa);

        if(!tarefaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id_tarefa);

        return ResponseEntity.ok().build();

    }





}


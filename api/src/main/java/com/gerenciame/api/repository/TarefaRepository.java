package com.gerenciame.api.repository;

import com.gerenciame.api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository <Tarefa, Long> { //<entidade, tipagem id>

}

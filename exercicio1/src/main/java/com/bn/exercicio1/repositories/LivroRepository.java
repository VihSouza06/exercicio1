package com.bn.exercicio1.repositories;

import com.bn.exercicio1.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {

}

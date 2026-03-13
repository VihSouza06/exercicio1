package com.bn.exercicio1.services;

import com.bn.exercicio1.models.LivroModel;
import com.bn.exercicio1.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }

    public LivroModel criarLivro(LivroModel livroModel){
        return livroRepository.save(livroModel);
    }

    public void deletarLivro(Long id){
       livroRepository.deleteById(id);
    }

    public LivroModel buscarLivroPorId(Long id){
        return livroRepository.findById(id).get();
    }

    public LivroModel atualizarLivro(Long id, LivroModel livroModel){
        LivroModel newLivroModel = livroRepository.findById(id).get();
        return livroRepository.save(livroModel);
    }
}

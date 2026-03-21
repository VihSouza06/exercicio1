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
        LivroModel novoLivro = livroRepository.findById(id).get();
        novoLivro.setAutor(livroModel.getAutor());
        novoLivro.setTitulo(livroModel.getTitulo());
        novoLivro.setAnoPublicacao(livroModel.getAnoPublicacao());
        return livroRepository.save(novoLivro);
    }
}

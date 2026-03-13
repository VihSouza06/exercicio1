package com.bn.exercicio1.controllers;

import com.bn.exercicio1.models.LivroModel;
import com.bn.exercicio1.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")

public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>>findAll(){
        List<LivroModel> requeste = livroService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livroModel){
        LivroModel requeste = livroService.criarLivro(livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(livroModel.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public LivroModel buscarLivroPorId(@PathVariable Long id){
        return livroService.buscarLivroPorId(id);
    }

    @PutMapping("/{id}")
    public LivroModel atualizarLivro(@PathVariable Long id, LivroModel livroModel){
        return livroService.atualizarLivro(id, livroModel);
    }

}

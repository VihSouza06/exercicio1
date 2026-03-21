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
        List<LivroModel> livros = livroService.findAll();
        return ResponseEntity.ok().body(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarLivroPorId(@PathVariable Long id){
        LivroModel livro = livroService.buscarLivroPorId(id);
        return ResponseEntity.ok(livro);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livroModel){
        LivroModel livroCriado = livroService.criarLivro(livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(livroModel.getId()).toUri();
        return ResponseEntity.created(uri).body(livroCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> atualizarLivro
            (@PathVariable Long id, @RequestBody LivroModel livroModel){
        LivroModel livroAtualizado = livroService.atualizarLivro(id, livroModel);
        return ResponseEntity.ok(livroAtualizado);
    }

}

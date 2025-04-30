package locadora.filmes.controller;

import locadora.filmes.DTO.EntradaDeDados;
import locadora.filmes.model.Filme;
import locadora.filmes.model.Locacao;
import locadora.filmes.service.FilmeService;
import locadora.filmes.service.LocacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locadora")
public class Controller {
    @Autowired
    FilmeService serviceFilme;

    @Autowired
    LocacaoService serviceLocacao;

    @PostMapping
    public ResponseEntity<EntradaDeDados> post(@RequestBody EntradaDeDados dados){
        EntradaDeDados filmeSalvo = serviceFilme.inserirFilme(dados);
        return ResponseEntity.status(200).body(filmeSalvo);
    }

    @GetMapping("/locacao")
    public ResponseEntity<List<Locacao>> get(){
        List<Locacao> locacao = serviceLocacao.listarLocacao();
        return ResponseEntity.status(200).body(locacao);
    }

    @GetMapping("/filme")
    public ResponseEntity<List<Filme>> listarFilmes(){
        List<Filme> filmes = serviceFilme.listarFilmes();
        return ResponseEntity.status(200).body(filmes);
    }




}

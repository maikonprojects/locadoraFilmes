package locadora.filmes.controller;

import locadora.filmes.DTO.EntradaDeDados;
import locadora.filmes.service.LocadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locadora")
public class Controller {
    @Autowired
    LocadoraService service;

    @PostMapping
    public ResponseEntity<EntradaDeDados> post(@RequestBody EntradaDeDados dados){
        EntradaDeDados filmeSalvo = service.inserirFilme(dados);
        return ResponseEntity.status(200).body(filmeSalvo);
    }
}

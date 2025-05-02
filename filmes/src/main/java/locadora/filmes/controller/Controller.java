package locadora.filmes.controller;

import locadora.filmes.DTO.EntradaDadosCliente;
import locadora.filmes.DTO.EntradaDadosLocacao;
import locadora.filmes.DTO.EntradaDeDados;
import locadora.filmes.model.Cliente;
import locadora.filmes.model.Filme;
import locadora.filmes.model.Locacao;
import locadora.filmes.service.ClienteService;
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

    @Autowired
    ClienteService serviceCliente;

    @PostMapping
    public ResponseEntity<EntradaDeDados> post(@RequestBody EntradaDeDados dados){
        EntradaDeDados filmeSalvo = serviceFilme.inserirFilme(dados);
        return ResponseEntity.status(200).body(filmeSalvo);
    }

    @PostMapping("/clientePost")
    public ResponseEntity<EntradaDadosCliente> postCliente(@RequestBody EntradaDadosCliente dadosCliente){
        EntradaDadosCliente clienteSalvo = serviceCliente.inserirCliente(dadosCliente);
        return ResponseEntity.status(200).body(clienteSalvo);
    }

    @PostMapping("/locacaoPost")
    public ResponseEntity<EntradaDadosLocacao> postLocacao(@RequestBody EntradaDadosLocacao dadosLocacao){
        EntradaDadosLocacao locacaoSalvo = serviceLocacao.inserirLocacao(dadosLocacao);
        return ResponseEntity.status(200).body(locacaoSalvo);
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity<Locacao> devolverLocacao(@PathVariable Long id){
        Locacao locacao = serviceLocacao.devolverFilme(id);
        return ResponseEntity.status(200).body(locacao);
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

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> listarCliente(){
        List<Cliente> clientes = serviceCliente.listarCliente();
        return ResponseEntity.status(200).body(clientes);
    }






}

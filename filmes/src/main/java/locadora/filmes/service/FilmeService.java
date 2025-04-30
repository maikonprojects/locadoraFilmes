package locadora.filmes.service;

import locadora.filmes.DTO.EntradaDeDados;
import locadora.filmes.model.Filme;
import locadora.filmes.model.Locacao;
import locadora.filmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository repositorio;

    public EntradaDeDados inserirFilme(EntradaDeDados dados){
        try {
            Filme filme = new Filme(dados);
            Filme filmeSalvo = repositorio.save(filme);
            return new EntradaDeDados(filmeSalvo.getTitulo(), filmeSalvo.getGenero(), filmeSalvo.getDiretor());
        } catch (RuntimeException se){
            throw new RuntimeException();
        }
    }


    public List<Filme> listarFilmes() {
        return repositorio.findAll();
    }
}

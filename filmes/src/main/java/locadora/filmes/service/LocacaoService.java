package locadora.filmes.service;

import locadora.filmes.DTO.EntradaDeDados;
import locadora.filmes.model.Locacao;
import locadora.filmes.repository.LocacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    LocacaoRepositorio repositorio;

    public List<Locacao> listarLocacao(){
       List<Locacao> locacao = repositorio.findAll();
       return locacao;
    }


}

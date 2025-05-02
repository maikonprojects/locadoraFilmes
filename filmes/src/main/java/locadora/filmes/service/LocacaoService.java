package locadora.filmes.service;

import locadora.filmes.DTO.EntradaDadosLocacao;
import locadora.filmes.DTO.EntradaDeDados;
import locadora.filmes.model.Filme;
import locadora.filmes.model.Locacao;
import locadora.filmes.repository.LocacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    LocacaoRepositorio repositorio;

    public EntradaDadosLocacao inserirLocacao(EntradaDadosLocacao dados){
        try {

            Locacao locacao = new Locacao(dados);
            Locacao locacaoSalvo = repositorio.save(locacao);
            return new EntradaDadosLocacao(locacaoSalvo.getCliente(),locacaoSalvo.getFilme(),locacaoSalvo.getDataLocacao(),locacaoSalvo.getDataDevolucao(),locacaoSalvo.isDevolvido());



        } catch (RuntimeException se){
            throw new RuntimeException();
        }
    }

    public Locacao devolverFilme(Long id) {
        Locacao locacao = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Locação não encontrada"));

        if (locacao.getDataDevolucao() != null) {
            throw new RuntimeException("Filme já devolvido");
        }

        locacao.setDataDevolucao(LocalDate.now());
        locacao.setDevolvido(true);

        return repositorio.save(locacao);
    }


    public List<Locacao> listarLocacao(){
        List<locadora.filmes.model.Locacao> locacao = repositorio.findAll();
        return locacao;
    }

}






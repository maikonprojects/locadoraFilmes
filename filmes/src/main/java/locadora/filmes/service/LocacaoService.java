package locadora.filmes.service;

import locadora.filmes.DTO.EntradaDadosLocacao;
import locadora.filmes.model.Locacao;
import locadora.filmes.repository.ClienteRepository;
import locadora.filmes.repository.FilmeRepository;
import locadora.filmes.repository.LocacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    LocacaoRepositorio locacaoRepositorio;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    FilmeRepository filmeRepository;

    public EntradaDadosLocacao inserirLocacao(EntradaDadosLocacao dados){
        var cliente = clienteRepository.findByNome(dados.cliente().getNome());
        var filme = filmeRepository.findByTitulo(dados.filme().getTitulo());

        System.out.println(filme);

        if (locacaoRepositorio.verificaFilmeAlugado(filme.getId()).isPresent()){
            throw new RuntimeException("Este filme já está alugado");
        }

            Locacao locacao = new Locacao(cliente,filme);
           Locacao locacaoSalvo = locacaoRepositorio.save(locacao);
            return new EntradaDadosLocacao(locacaoSalvo.getCliente(),locacaoSalvo.getFilme());


    }

    public Locacao devolverFilme(Long id) {
        Locacao locacao = locacaoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Locação não encontrada"));


        locacao.setDataDevolucao(LocalDate.now());
        locacao.setDevolvido(true);

        return locacaoRepositorio.save(locacao);
    }


    public List<Locacao> listarLocacao(){
        List<locadora.filmes.model.Locacao> locacao = locacaoRepositorio.findAll();
        return locacao;
    }

}






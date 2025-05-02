package locadora.filmes.repository;

import locadora.filmes.model.Cliente;
import locadora.filmes.model.Filme;
import locadora.filmes.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepositorio extends JpaRepository<Locacao, Long> {
    boolean existsByFilmeAndDevolvidoFalse(Filme filme);
    Cliente findByNome(String nome);
}

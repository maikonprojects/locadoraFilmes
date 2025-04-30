package locadora.filmes.repository;

import locadora.filmes.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepositorio extends JpaRepository<Locacao, Long> {
}

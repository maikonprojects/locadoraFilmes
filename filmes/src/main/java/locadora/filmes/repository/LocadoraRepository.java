package locadora.filmes.repository;

import locadora.filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocadoraRepository extends JpaRepository<Filme, Integer> {
}

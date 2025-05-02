package locadora.filmes.repository;

import locadora.filmes.model.Cliente;
import locadora.filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    Filme findByTitulo(String nome);
}

package locadora.filmes.repository;

import locadora.filmes.model.Cliente;
import locadora.filmes.model.Filme;
import locadora.filmes.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LocacaoRepositorio extends JpaRepository<Locacao, Long> {
    @Query("Select l from Locacao l JOIN l.filme f WHERE f.id = :filmeId AND l.devolvido = false")
    Optional<Locacao> verificaFilmeAlugado(@Param("filmeId") long id);




}

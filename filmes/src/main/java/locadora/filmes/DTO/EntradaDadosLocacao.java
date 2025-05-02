package locadora.filmes.DTO;

import locadora.filmes.model.Cliente;
import locadora.filmes.model.Filme;

import java.time.LocalDate;

public record EntradaDadosLocacao(Cliente cliente, Filme filme, LocalDate dataLocacao, LocalDate dataDevolucao, boolean devolvido) {
}

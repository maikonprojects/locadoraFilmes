package locadora.filmes.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "locacao")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Filme filme;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public Locacao(Cliente cliente, Filme filme, LocalDate dataLocacao, LocalDate dataDevolucao, boolean devolvido) {
        this.cliente = cliente;
        this.filme = filme;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}

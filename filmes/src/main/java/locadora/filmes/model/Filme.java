package locadora.filmes.model;

import jakarta.persistence.*;
import locadora.filmes.DTO.EntradaDeDados;

@Entity
@Table(name = "filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String genero;
    private String diretor;

    public Filme(EntradaDeDados dados) {
        this.titulo = dados.titulo();
        this.genero = dados.genero();
        this.diretor = dados.diretor();
    }

    public Filme() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}

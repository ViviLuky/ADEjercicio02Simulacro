package modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name="libros")

public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "id autor")

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }
@OneToMany(mappedBy = "librp",cascade = CascadeType.ALL, orphanRemoval = true)
    public ArrayList<Alquiler> getAlquilers() {
        return alquilers;
    }

    public void setAlquilers(ArrayList<Alquiler> alquilers) {
        this.alquilers = alquilers;
    }

    private Autores autores;

    private ArrayList<Alquiler>alquilers;

    public Libro() {
        alquilers=new ArrayList<>();
    }

    public Libro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        alquilers=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

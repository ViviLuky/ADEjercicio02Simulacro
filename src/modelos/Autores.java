package modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
@Entity
@Table(name= "autores")
public class Autores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL,orphanRemoval = true)
    private ArrayList<Libro>libros;

    public Autores() {
        libros=new ArrayList<>();
    }

    public Autores(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        libros=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

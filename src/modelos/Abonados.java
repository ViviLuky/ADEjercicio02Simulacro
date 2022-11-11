package modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
@Entity
@Table(name = "abonados")
public class Abonados implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @OneToMany(mappedBy = "abonado" ,cascade = CascadeType.ALL,orphanRemoval = true)
    private ArrayList<Alquiler> alquileres;

    public Abonados() {
        alquileres =new ArrayList<>();
    }

    public ArrayList<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(ArrayList<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    public Abonados(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        alquileres=new ArrayList<>();
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

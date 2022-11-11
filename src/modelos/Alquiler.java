package modelos;

import jakarta.persistence.*;

import java.awt.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "alquileres")
public class Alquiler implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Date  fecha;
    @ManyToOne
    @JoinColumn(name = "id_abonado")
    private Abonados abonados;
    @ManyToOne
    @JoinColumn(name = "id_libros")
    private Libro libro;

    public Abonados getAbonados() {
        return abonados;
    }

    public void setAbonados(Abonados abonados) {
        this.abonados = abonados;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public Alquiler() {
    }

    public Alquiler(int id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

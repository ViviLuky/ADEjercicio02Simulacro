import modelos.Abonados;
import modelos.Alquiler;
import modelos.Autores;
import modelos.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Abonados abonados=new Abonados();
        abonados.setNombre("MAnolito");
        Autores autores=new Autores();
        autores.setNombre("Javier");
        Libro libro= new Libro();
        libro.setTitulo("POR QUE NO");
        libro.setAutores(autores);
        Alquiler alquiler=new Alquiler();
        alquiler.setFecha(Date.valueOf(LocalDate.now()));

        abonados.getAlquileres().add(alquiler);
        libro.getAlquilers().add(alquiler);
        autores.getLibros().add(libro);

        // crea la variable
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();


        session.persist(abonados);
        session.persist(autores);
        session.persist(libro);
        session.persist(alquiler);

        session.getTransaction().commit();
        session.close();
    }
}
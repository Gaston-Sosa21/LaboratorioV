package biblioteca;
import biblioteca.entidad.Autor;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Genero;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Nacionalidad;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class AppBiblioteca 
{
    public static void main( String[] args )
    {
      
    	SessionFactory sessionFactory;
    	
    	Configuration configuration = new Configuration();
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
 
    	session.beginTransaction();
    	
    	//1ro se crea la ancionalidad del autor para luego relacionarlo
    	Nacionalidad nacionalidad = new Nacionalidad();
    	nacionalidad.setDescripcion("Argentina");
    	//luego los datos del autor
    	Autor autor = new Autor();
    	autor.setNombre("Diego");
    	autor.setApellido("Maradona");    	
    	autor.setNacionalidad(nacionalidad);
    	autor.setEmail("diego.maradona@hotmail.com");    
    	
    	Genero genero = new Genero();
    	genero.setDescripcion("Drama");
      	
    	//luego los libros
    	Libro libro = new Libro();  
    	libro.setAutor(autor);
    	//FALTA ASOCIAR LOS GENEROS
    	
    	//y por ultimo se asocian en una lista los libros creados a una biblioteca
    	Biblioteca biblioteca = new Biblioteca();
    	biblioteca.setLibro("La naranja mecanica");
    	//biblioteca.setFecha_alta();
    	biblioteca.setEstado(true);    	 	
    	
    	//orden en los que se debe generar la instancia
    	session.save(nacionalidad);
    	session.save(autor); 
    	session.save(genero); 
    	session.save(libro); 
    	session.save(biblioteca);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	sessionFactory.close();
        
    }
}

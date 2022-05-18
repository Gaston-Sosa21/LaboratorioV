package biblioteca;
import biblioteca.entidad.Autor;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Genero;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Nacionalidad;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

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
    	
    	//1ro se crea la nacionalidad del autor para luego relacionarlo
    	Nacionalidad nacionalidad = new Nacionalidad();
    	nacionalidad.setDescripcion("Argentina");
    	
    	
    	//luego los datos del autor
    	Autor autor = new Autor();
    	autor.setNombre("Diego");
    	autor.setApellido("Maradona");    	
    	autor.setNacionalidad(nacionalidad);
    	autor.setEmail("diego.maradona@hotmail.com");    
    	
    	//se crean generos
    	Genero genero1 = new Genero();
    	genero1.setDescripcion("Drama");
    	
    	Genero genero2 = new Genero();
    	genero2.setDescripcion("Suspenso");
      	
    	//luego los libros
    	Libro libro = new Libro();
    	libro.setISBN("TIT");
    	libro.setTitulo("Titanic");
    	libro.setFecha_lanzamiento(LocalDate.now());
    	libro.setIdioma("Español");
    	libro.setCantidad_paginas(500);
    	libro.setAutor(autor);
    	libro.setDescripcion("Se hunde");
    	
    	ArrayList<Libro> listaLibros = new ArrayList<Libro>();
    	listaLibros.add(libro);
    	
    	HashSet<Genero> listaGeneros = new HashSet<Genero>();
    	listaGeneros.add(genero1);
    	listaGeneros.add(genero2);
    	
    	libro.setListaGeneros(listaGeneros);

    	Biblioteca biblioteca = new Biblioteca();
    	biblioteca.setLibro(listaLibros);
    	biblioteca.setFecha_alta(LocalDate.now());
    	biblioteca.setEstado(true);  
    	
    	
    	
    	//orden en los que se debe generar la instancia
    	/*session.save(nacionalidad);
    	session.save(autor); 
    	session.save(genero); 
    	session.save(libro); */
    	session.save(biblioteca);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	sessionFactory.close();
        
    }
}

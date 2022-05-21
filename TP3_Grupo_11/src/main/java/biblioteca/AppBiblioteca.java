package biblioteca;

import biblioteca.dao.daoHibernate;
import biblioteca.entidad.Autor;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Genero;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Nacionalidad;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    	
    	//Nacionalidades
    	Nacionalidad nacionalidad = new Nacionalidad();
    	nacionalidad.setDescripcion("Argentina");
    
    	Nacionalidad nacionalidad2 = new Nacionalidad();
    	nacionalidad2.setDescripcion("Peruana");
    	
    	Nacionalidad nacionalidad3 = new Nacionalidad();
    	nacionalidad3.setDescripcion("Italiana");
    	
    	//Datos personales del autor
    	Autor autor = new Autor();
    	autor.setNombre("Diego");
    	autor.setApellido("Maradona");    	
    	autor.setNacionalidad(nacionalidad);
    	autor.setEmail("diego.maradona@hotmail.com");    
    	
    	Autor autor2 = new Autor();
    	autor2.setNombre("José");
    	autor2.setApellido("Vargas");    	
    	autor2.setNacionalidad(nacionalidad2);
    	autor2.setEmail("Josecito.vargas@yahoo.com.ar");    
    	
    	Autor autor3 = new Autor();
    	autor3.setNombre("Antonio");
    	autor3.setApellido("Caravaggio");    	
    	autor3.setNacionalidad(nacionalidad3);
    	autor3.setEmail("Caravaggio.artista@gmail.com");    
    	
    	
    	//se crean generos
    	Genero genero1 = new Genero();
    	genero1.setDescripcion("Drama");
    	
    	Genero genero2 = new Genero();
    	genero2.setDescripcion("Suspenso");
      	
    	Genero genero3 = new Genero();
    	genero3.setDescripcion("Romance");
    	
    	Genero genero4 = new Genero();
    	genero4.setDescripcion("Terror");
    	
    	
    	//luego los libros
    	Libro libro = new Libro();
    	libro.setISBN("TIT");
    	libro.setTitulo("Titanic");
    	libro.setFecha_lanzamiento(java.sql.Date.valueOf("1912-04-15"));
    	libro.setIdioma("Español");
    	libro.setCantidad_paginas(500);
    	libro.setAutor(autor);
    	libro.setDescripcion("Se hunde");
    	
    	Libro libro2 = new Libro();
    	libro2.setISBN("ET28");
    	libro2.setTitulo("La visita");
    	libro2.setFecha_lanzamiento(java.sql.Date.valueOf("2005-03-05"));
    	libro2.setIdioma("Español");
    	libro2.setCantidad_paginas(96);
    	libro2.setAutor(autor2);
    	libro2.setDescripcion("Inesperada visita de quien traumó su vida");
    	
    	Libro libro3 = new Libro();
    	libro3.setISBN("LP32");
    	libro3.setTitulo("El teatro");
    	libro3.setFecha_lanzamiento(java.sql.Date.valueOf("1957-10-05"));
    	libro3.setIdioma("Italiano");
    	libro3.setCantidad_paginas(300);
    	libro3.setAutor(autor3);
    	libro3.setDescripcion("Historia del teatro, desde sus comienzos.");
    	
    	
    	
    	ArrayList<Libro> listaLibros = new ArrayList<Libro>();
    	listaLibros.add(libro);
    	ArrayList<Libro> listaLibros2 = new ArrayList<Libro>();
    	listaLibros2.add(libro2);
    	ArrayList<Libro> listaLibros3 = new ArrayList<Libro>();
    	listaLibros3.add(libro3);
    	
    	
    	HashSet<Genero> listaGeneros = new HashSet<Genero>();
    	listaGeneros.add(genero1);
    	listaGeneros.add(genero2);
    	listaGeneros.add(genero3);
    	listaGeneros.add(genero4);
    	
    	libro.setListaGeneros(listaGeneros);

    
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    	String DateHoy = sdf.format(new Date(0));
    	//Supuestamente con esto toma la fecha actual pero no me esta dejando

    	Biblioteca biblioteca = new Biblioteca();
    	biblioteca.setLibro(listaLibros);
    	biblioteca.setFecha_alta(java.sql.Date.valueOf("2022-01-08"));
    	biblioteca.setEstado(1);  
    	
    	Biblioteca biblioteca2 = new Biblioteca();
    	biblioteca2.setLibro(listaLibros2);
    	biblioteca2.setFecha_alta(java.sql.Date.valueOf("2021-11-05"));
    	biblioteca2.setEstado(1);  
   
    	Biblioteca biblioteca3 = new Biblioteca();
    	biblioteca3.setLibro(listaLibros2);
    	biblioteca3.setFecha_alta(java.sql.Date.valueOf("2021-10-05"));
    	biblioteca3.setEstado(2);  
   
    	
    	
    	//orden en los que se debe generar la instancia
    	/*session.save(nacionalidad);
    	session.save(autor); 
    	session.save(genero); 
    	session.save(libro); */
     	session.save(biblioteca);
    	session.save(biblioteca2);
    	session.save(biblioteca3);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	sessionFactory.close(); 
    	    	
    	// Modificamos el registro

    	Biblioteca bbta = new Biblioteca();
    	bbta.setId(1);
    	//bbta.setLibro(listaLibros);
    	bbta.setEstado(2);
    	bbta.setFecha_alta(java.sql.Date.valueOf("2022-05-20"));
    	
    	 daoHibernate.UpdateBiblioteca(bbta); 

    //	 System.out.println("Hasta donde llegaré? ");
    	
    	// Le damos de baja
    	
        //Listamos lo que tenemos

    	
    }
}

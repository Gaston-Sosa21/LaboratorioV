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
    	
    	
    	
    	Biblioteca biblioteca = new Biblioteca();
    	biblioteca.setFecha_alta(java.sql.Date.valueOf("2022-01-08"));
    	biblioteca.setEstado(1);
    	Biblioteca biblioteca2 = new Biblioteca();
    	biblioteca2.setFecha_alta(java.sql.Date.valueOf("2022-04-08"));
    	biblioteca2.setEstado(2);
    	Biblioteca biblioteca3 = new Biblioteca();
    	biblioteca3.setFecha_alta(java.sql.Date.valueOf("2022-09-03"));
    	biblioteca3.setEstado(1);
    	Biblioteca biblioteca4 = new Biblioteca();
    	biblioteca4.setFecha_alta(java.sql.Date.valueOf("2022-10-04"));
    	biblioteca4.setEstado(1);
    	Biblioteca biblioteca5 = new Biblioteca();
    	biblioteca5.setFecha_alta(java.sql.Date.valueOf("2022-11-12"));
    	biblioteca5.setEstado(2);
    	
    	
    	ArrayList<Biblioteca> listaBibliotecas = new ArrayList<Biblioteca>();
    	listaBibliotecas.add(biblioteca);
    	listaBibliotecas.add(biblioteca2);
    	
    	ArrayList<Biblioteca> listaBibliotecas2 = new ArrayList<Biblioteca>();
    	listaBibliotecas2.add(biblioteca4);
    	listaBibliotecas2.add(biblioteca3);
    	
    	ArrayList<Biblioteca> listaBibliotecas3 = new ArrayList<Biblioteca>();
    	listaBibliotecas3.add(biblioteca5);
    	
	
    	//luego los libros
    	Libro libro = new Libro();
    	libro.setISBN("TIT");
    	libro.setTitulo("Titanic");
    	libro.setFecha_lanzamiento(java.sql.Date.valueOf("1912-04-15"));
    	libro.setIdioma("Español");
    	libro.setCantidad_paginas(500);
    	libro.setAutor(autor);
    	libro.setDescripcion("Se hunde");
    	libro.setBiblioteca(listaBibliotecas);
    	
    	Libro libro2 = new Libro();
    	libro2.setISBN("ET28");
    	libro2.setTitulo("La visita");
    	libro2.setFecha_lanzamiento(java.sql.Date.valueOf("2005-03-05"));
    	libro2.setIdioma("Español");
    	libro2.setCantidad_paginas(96);
    	libro2.setAutor(autor2);
    	libro2.setDescripcion("Inesperada visita de quien traumó su vida");
    	libro2.setBiblioteca(listaBibliotecas2);
    	
    	Libro libro3 = new Libro();
    	libro3.setISBN("LP32");
    	libro3.setTitulo("El teatro");
    	libro3.setFecha_lanzamiento(java.sql.Date.valueOf("1957-10-05"));
    	libro3.setIdioma("Italiano");
    	libro3.setCantidad_paginas(300);
    	libro3.setAutor(autor3);
    	libro3.setDescripcion("Historia del teatro, desde sus comienzos.");
    	libro3.setBiblioteca(listaBibliotecas3);
    	
    	
    	HashSet<Genero> listaGeneros = new HashSet<Genero>();
    	listaGeneros.add(genero1);
    	listaGeneros.add(genero2);
    	listaGeneros.add(genero3);
    	listaGeneros.add(genero4);
    	
    	libro.setListaGeneros(listaGeneros);
    	
    	HashSet<Genero> listaGeneros2 = new HashSet<Genero>();
    	listaGeneros2.add(genero3);
    	listaGeneros2.add(genero2);
    	libro2.setListaGeneros(listaGeneros2);
    	
    	HashSet<Genero> listaGeneros3 = new HashSet<Genero>();
    	listaGeneros3.add(genero1);
    	listaGeneros3.add(genero4);
    	libro3.setListaGeneros(listaGeneros3);


     	session.save(libro);
     	session.save(libro2);
     	session.save(libro3);

    	session.getTransaction().commit();
    	
    	daoHibernate.InsertBiblioteca("TIT", "2022-09-07", 1, session);
    	
    	biblioteca.setEstado(2);
    	biblioteca.setFecha_alta(java.sql.Date.valueOf("2022-05-20"));
    	daoHibernate.UpdateBiblioteca(biblioteca, session);
	
    	Biblioteca bib = daoHibernate.ListarBiblioteca(biblioteca, session);
    	System.out.println(bib);
  
    	session.close();
    	
    	
    	
    	sessionFactory.close(); 


    	//daoHibernate.DeleteBiblioteca(biblio);
    }
}

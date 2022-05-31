package biblioteca;

import java.util.List;

import org.hibernate.Session;
import biblioteca.dao.ConfigHibernate;
import biblioteca.entidad.Autor;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Genero;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Nacionalidad;


public class AppBiblioteca2 {

	public static void main(String[] args) {
		
		Punto1();
		Punto2();
		Punto3();
		Punto4();
		Punto5();
		Punto6();
	}

	public static void Punto1()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
        List<Libro> listaLibros= (List<Libro>) session.createQuery("FROM Libro l order by l.ISBN desc").list();
       
        
        
        System.err.println("Lecturas:");
        
        System.out.println("---------PUNTO 1---------");
        
        
        for (Libro libro : listaLibros) {
        	
        	String listaGeneros = ", Generos: ";
        	
            for (Genero gen : libro.getListaGeneros()) {
            	
            	
            	listaGeneros+= gen.getDescripcion() + ", ";
            }
            
        	  System.out.println(" ISBN: "+ libro.getISBN()+", Titulo:  " + libro.getTitulo() + ", Fecha de lanzamiento: "+ libro.getFecha_lanzamiento() + 
        			  				", Idioma: "+ libro.getIdioma() + ", Cantidad de páginas: "+ libro.getCantidad_paginas()+
        			  				", Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellido() + ", Descripción: "+ 
        			  				libro.getDescripcion() + listaGeneros.substring(0, listaGeneros.length()-2));	
		}
    
        
        ch.cerrarSession();
	}
	
	public static void Punto2()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
        List<Object[]> listaObject= (List<Object[]>) session.createQuery("FROM Libro l inner join l.biblioteca bib where bib.estado = 2 ").list();
       
        
        System.out.println();
        System.out.println("---------PUNTO 2---------");
        for (Object[] obj : listaObject) {
	        
        	Libro lib = (Libro) obj[0];
	        Biblioteca bib = (Biblioteca) obj[1];
        	System.out.println("ID Biblioteca: "+ bib.getId()+ ", Fecha de alta: "+ bib.getFecha_alta()+ ", Libro: " + lib.getTitulo());	
		}
    
        
        ch.cerrarSession();
	}
	
	public static void Punto3()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
        List<Object[]> listaObject= (List<Object[]>) session.createQuery("FROM Autor a inner join a.nacionalidad n where n.id = 1").list();
       
        
        System.out.println();
        System.out.println("---------PUNTO 3---------");
        for (Object[] obj : listaObject) {
        	
        	Autor aut = (Autor)obj[0];
        	Nacionalidad nac = (Nacionalidad) obj[1];
        	System.out.println("ID Autor: "+ aut.getId()+ ", Nombre: "+ aut.getNombre()+ " "+ aut.getApellido()+ ", Nacionalidad: " + nac.getDescripcion() + ", Email: "+ aut.getEmail());	
		}
    
        
        ch.cerrarSession();
	}
	
	public static void Punto4()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
		System.out.println();
        System.out.println("---------PUNTO 4---------");
        
        Libro libro= (Libro) session.createQuery("FROM Libro l where l.ISBN = '12345'").uniqueResult();
        
        String listaGeneros = ", Generos: ";
        for (Genero gen : libro.getListaGeneros()) {
        	
        	
        	listaGeneros+= gen.getDescripcion() + ", ";
        }
        
        System.out.println(" ISBN: "+ libro.getISBN()+", Titulo:  " + libro.getTitulo() + ", Fecha de lanzamiento: "+ libro.getFecha_lanzamiento() + 
			  				", Idioma: "+ libro.getIdioma() + ", Cantidad de páginas: "+ libro.getCantidad_paginas()+
			  				", Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellido() + ", Descripción: "+ 
			  				libro.getDescripcion() + listaGeneros.substring(0, listaGeneros.length()-2) );	
        

        ch.cerrarSession();
	}
	
	public static void Punto5()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
		System.out.println();
        System.out.println("---------PUNTO 5---------");
        
        String maximo= (String) session.createQuery("Select max(l.ISBN) FROM Libro l").uniqueResult();
        
        
        System.out.println("El máximo ISBN es: " + maximo);	
        

        ch.cerrarSession();
	}
	
	public static void Punto6()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
		System.out.println();
        System.out.println("---------PUNTO 6---------");
        
        List<Object[]> listaObject= (List<Object[]>) session.createQuery("SELECT g.id, g.descripcion, COUNT(g.id) FROM Libro l inner join l.listaGeneros g group by g.id, g.descripcion ").list();
        
		for (Object[] obj : listaObject) {
		        	
        	int id = Integer.parseInt(obj[0].toString());
        	String descripcion = obj[1].toString();
        	int cantidadLibros = Integer.parseInt(obj[2].toString());
        	System.out.println("ID Género: "+ id + ", Descripcion: "+ descripcion + ", Cantidad de libros: "+ cantidadLibros);	
		}
        
        	
        ch.cerrarSession();
	}
		
}

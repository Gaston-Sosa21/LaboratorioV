package biblioteca;

import java.util.List;

import org.hibernate.Session;
import biblioteca.dao.ConfigHibernate;
import biblioteca.entidad.Genero;
import biblioteca.entidad.Libro;


public class AppBiblioteca2 {

	public static void main(String[] args) {
		
		Punto1();
		Punto5();
		Punto6();
	}

	public static void Punto1()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
        List<Libro> listaLibros= session.createQuery("FROM Libro l order by l.ISBN desc").list();        
        
        System.err.println("Lecturas:");
        
        System.out.println("---------PUNTO 1---------");
        for (Libro libro : listaLibros) {
        	  System.out.println(" ISBN: "+ libro.getISBN()+", Titulo:  " + libro.getTitulo() + ", Fecha de lanzamiento: "+ libro.getFecha_lanzamiento() + 
        			  				", Idioma: "+ libro.getIdioma() + ", Cantidad de páginas: "+ libro.getCantidad_paginas()+
        			  				", Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellido() + ", Descripción: "+ 
        			  				libro.getDescripcion() + ", Géneros: "+ libro.getListaGeneros());	
		}   
        
        ch.cerrarSession();
	}
	
	public static void Punto5()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
		Libro libro = new Libro();
		libro.setISBN((String)session.createQuery("SELECT MAX(ISBN) AS ISBN FROM Libro").uniqueResult());		
		System.out.println("---------PUNTO 5---------");
		System.err.println("El ISBN mayor es: :" + libro.getISBN());               
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

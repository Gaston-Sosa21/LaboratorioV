package biblioteca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import biblioteca.dao.ConfigHibernate;
import biblioteca.entidad.Libro;

public class AppBiblioteca2 {

	public static void main(String[] args) {
		
		Punto1();

	}

	public static void Punto1()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
        List<Libro> listaLibros= (List<Libro>) session.createQuery("FROM Libro l order by l.ISBN desc").list();
       
        
        
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
}

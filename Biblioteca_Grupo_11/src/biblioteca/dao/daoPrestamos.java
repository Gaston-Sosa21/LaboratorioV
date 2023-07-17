package biblioteca.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Prestamo;
import resources.Config;

public class daoPrestamos {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	
public Boolean CargarPrestamo(Biblioteca biblioteca, String fecha_prestamo, Integer cantidad_dias, Clientes cliente) {

		try {

			 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();
			 Prestamo prestamo = (Prestamo)appContext.getBean("PrestamoBean");		
			 prestamo.setBiblioteca(biblioteca);
			 prestamo.setFecha_prestamo(java.sql.Date.valueOf(fecha_prestamo));
			 prestamo.setCantidad_dias(cantidad_dias);
			 prestamo.setCliente(cliente);
		     session.save(prestamo);
		     session.getTransaction().commit();
		     session.close();

		     return true;		     
		}		
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage().toString());
			return false;
		}	

	 }


public Boolean ModificarPrestamo(String IdPrestamo, int CantidadDias) {
	
	try {
		
		 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();
	     
	     Prestamo p = BuscarPrestamo(IdPrestamo);	     
	     p.setCantidad_dias(CantidadDias);
	     
	     SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	     Date date = new Date(System.currentTimeMillis());
	     
	     System.out.println(formatter.format(date));
	     
	     p.setFecha_prestamo(date);
    
	     session.update(p);	
	     session.getTransaction().commit();	     
	     session.close();	     
	     return true;
	     
	}
	
	catch(Exception e) {
		System.out.println("Error: " + e.toString());
		return false;
	}
	 
 }

public Boolean EliminarPrestamo(String idPrestamo) {

	try {

		 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();
	    
	     Prestamo prestamo = BuscarPrestamo(idPrestamo);
	     
	     prestamo.setBiblioteca(null);
	     prestamo.setCliente(null);
	     session.delete(prestamo);
	     session.getTransaction().commit();
	     session.close();

	     return true;
	}

	catch(Exception e) {
		System.out.println("Error: " + e.toString());
		return false;
	}


 }


	public List<Object[]> ListarObjPrestamos() {
		
		try {

		 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();

	     //Buscamos los prestamos con los clientes
	     List<Object[]> listaObject = (List<Object[]>)session.createQuery("FROM Prestamo p inner join p.Clientes").list();

	     session.close();

	     return listaObject;
	     
		}catch(Exception ex) {
			System.out.println("Error: "+ ex.toString());
		    return null;
		}
	 }

	public List<Prestamo> ListarPrestamos() {
		
		try {

		 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();

	     List<Prestamo> listaPrestamos = (List<Prestamo>)session.createQuery("FROM Prestamo p ").list();	  
	     
	     session.close();	    
	     return listaPrestamos;
	     
		}catch(Exception ex) {			
		    System.out.println("Error: "+ ex.toString());
		    return null;
		}
	 }
	
	public List<Object[]> ListarPrestamosCompuestos() {
		
		try {
		
		 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();

	     List<Prestamo> listaPrestamos = (List<Prestamo>)session.createQuery("FROM Prestamo p ").list();

	     session.close();
	     
	     List<Object[]> listaCompuesta = new ArrayList<Object[]>();
	     
	     daoBiblioteca dbib = (daoBiblioteca) appContext.getBean("daoBibliotecaBean");	     
	     Libro libro = new Libro();
	     Biblioteca bib = (Biblioteca) appContext.getBean("BibliotecaBean");
	     int idLibro = -1;
	 
	     for (Prestamo prestamo : listaPrestamos) {

	    	 idLibro = prestamo.getBiblioteca().getId();
	    	 libro = (Libro)dbib.BuscarBiblioteca( String.valueOf(idLibro) )[0];
	    	 bib = (Biblioteca)dbib.BuscarBiblioteca( String.valueOf(idLibro) )[1];
	    	 
	    	 Object[] o = new Object[3];

	    	 o[0] = prestamo;
	    	 o[1] = libro;
	    	 o[2] = bib;
	    	 
	    	 listaCompuesta.add(o);  
	     }
	     
	     return listaCompuesta;
	     
		}catch(Exception ex) {			
		    System.out.println("Error: "+ ex.toString());
		    return null;
		   }
	 }
	
	public List<Libro> ObtenerLibrosDeBiblioteca()	{
		
		try {
		
		daoBiblioteca dbib = (daoBiblioteca) appContext.getBean("daoBibliotecaBean");		
		List<Object[]> listaCompuesta = dbib.ListarBibliotecas();	     	     
	    List<Libro> listLibros = new ArrayList<Libro>();
	 
	    for (Object[] obj : listaCompuesta) {	     

		    if ( ((Biblioteca)obj[1]).getEstado() == 0 && !listLibros.contains((Libro)obj[0]))
		       listLibros.add((Libro)obj[0]);     
	
	     }	 
	     
	   return listLibros;	
	   
		}catch(Exception ex) {			
		    System.out.println("Error: "+ ex.toString());
		    return null;
		}
	}
	
	

	public Prestamo BuscarPrestamo(String id) {		
		try {

		 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
		 Session session = daoSession.AbrirSession();
	     session.beginTransaction();

	     Prestamo prestamo = (Prestamo)session.createQuery("FROM Prestamo p where p.id = " + id + "").uniqueResult();

	     session.close();
	     return prestamo;
	     
		}catch(Exception ex) {			
		    System.out.println("Error: "+ ex.toString());
		    return null;
		}
	 }

	public Object[] BuscarObjPrestamo(String idPrestamo) {		
		try {

		 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();

	     Object[] listaObject = (Object[])session.createQuery("FROM Prestamo p where p.id = " + idPrestamo + "").uniqueResult();

	     session.close();
	     return listaObject;
	     
		}catch(Exception ex) {			
		    System.out.println("Error: "+ ex.toString());
		    return null;
		}
	 }
}
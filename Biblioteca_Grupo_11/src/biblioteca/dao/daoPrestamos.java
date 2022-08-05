package biblioteca.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Prestamo;

public class daoPrestamos {

public Boolean CargarPrestamo(Biblioteca biblioteca, String fecha_prestamo, Integer cantidad_dias, Clientes cliente) {

		try {

			 DaoSession daoSession = new DaoSession();
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();

		     Prestamo prestamo = new Prestamo(biblioteca,java.sql.Date.valueOf(fecha_prestamo),cantidad_dias,cliente);	

		     session.save(prestamo);
		     session.getTransaction().commit();
		     session.close();

		     return true;		     
		}		
		catch(Exception e) {
			System.out.println("Error: " + e.toString());
			return false;
		}	

	 }


public Boolean ModificarPrestamo(String IdPrestamo, int CantidadDias) {
	
	try {
		
		 DaoSession daoSession = new DaoSession();
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

		 DaoSession daoSession = new DaoSession();
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

		 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();

	     //Buscamos los prestamos con los clientes
	     List<Object[]> listaObject = (List<Object[]>)session.createQuery("FROM Prestamo p inner join p.Clientes").list();

	     session.close();

	     return listaObject;
	 }

	public List<Prestamo> ListarPrestamos() {

		 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();

	     List<Prestamo> listaPrestamos = (List<Prestamo>)session.createQuery("FROM Prestamo p ").list();	  
	     
	     session.close();	    
	     return listaPrestamos;
	 }
	
	public List<Object[]> ListarPrestamosCompuestos() {
		
		 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();

	     List<Prestamo> listaPrestamos = (List<Prestamo>)session.createQuery("FROM Prestamo p ").list();

	     session.close();
	     
	     List<Object[]> listaCompuesta = new ArrayList<Object[]>();
	     
	     daoBiblioteca dbib = new daoBiblioteca();	     
	     Libro libro = new Libro();
	     int idLibro = -1;
	 
	     for (Prestamo prestamo : listaPrestamos) {

	    	 idLibro = prestamo.getBiblioteca().getId();
	    	 libro = (Libro)dbib.BuscarBiblioteca( String.valueOf(idLibro) )[0];
	    	 
	    	 Object[] o = new Object[2];

	    	 o[0] = prestamo;
	    	 o[1] = libro;
	    	 
	    	 listaCompuesta.add(o);  
	     }
	     
	     return listaCompuesta;
	 }
	
	public List<Libro> ObtenerLibrosDeBiblioteca()
	{
		daoBiblioteca dbib = new daoBiblioteca();		
		List<Object[]> listaCompuesta = dbib.ListarBibliotecas();	     	     
	    List<Libro> listLibros = new ArrayList<Libro>();
	 
	    for (Object[] obj : listaCompuesta) {	     

		    if ( ((Biblioteca)obj[1]).getEstado() == 0)
		       listLibros.add((Libro)obj[0]);   
	     }	    
	     
	   return listLibros;	 
	}
	
	

	public Prestamo BuscarPrestamo(String id) {

		 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
	     session.beginTransaction();

	     Prestamo prestamo = (Prestamo)session.createQuery("FROM Prestamo p where p.id = " + id + "").uniqueResult();

	     session.close();
	     return prestamo;
	 }

	public Object[] BuscarObjPrestamo(String idPrestamo) {

		 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();

	     Object[] listaObject = (Object[])session.createQuery("FROM Prestamo p where p.id = " + idPrestamo + "").uniqueResult();

	     session.close();

	     return listaObject;
	 }
	
	

}
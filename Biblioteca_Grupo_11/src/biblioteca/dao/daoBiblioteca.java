package biblioteca.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Libro;

public class daoBiblioteca {

	public Boolean CargarBiblioteca(String ISBN, String FechaAlta, int Estado) {
		
		try {
			
			 DaoSession daoSession = new DaoSession();
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();
		     
		     Biblioteca bbta = new Biblioteca();
		     bbta.setFecha_alta(java.sql.Date.valueOf(FechaAlta.toString()));
		     bbta.setEstado(Estado);		     
		     
		     Libro lib = (Libro)session.get(Libro.class, ISBN);
		     
		     ArrayList<Biblioteca> lb= new ArrayList<Biblioteca>();
		     lb.add(bbta);
		
		     lib.setBiblioteca(lb);		     
		     session.save(lib);		
		     session.getTransaction().commit();		     
		     session.close();		     
		     return true;		     
		}
		
		catch(Exception e) {
			System.out.println("Error: " + e.toString());
			return false;
		}
		 

	 }
	
	public Boolean ModificarBiblioteca(String id, String ISBN, String FechaAlta) {
		
		try {
			
			 DaoSession daoSession = new DaoSession();
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();		     
		     
		     Object[] obj = BuscarBiblioteca(id);
		     Libro lib = BuscarLibro(ISBN);
		     Biblioteca bbta = (Biblioteca)obj[1];		     
		     
		     bbta.setFecha_alta(java.sql.Date.valueOf(FechaAlta.toString()));		     
		     
		     ArrayList<Biblioteca> lb= new ArrayList<Biblioteca>();
		     lb.add(bbta);
		
		     lib.setBiblioteca(lb);		     
		     session.update(lib);		
		     session.getTransaction().commit();		     
		     session.close();		     
		     return true;
		     
		}
		
		catch(Exception e) {
			System.out.println("Error: " + e.toString());
			return false;
		}
		 

	 }
	
	public Boolean EliminarBiblioteca(String id) {
		
		try {
			
			 DaoSession daoSession = new DaoSession();
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();		     
		     
		     Object[] obj = BuscarBiblioteca(id);
		     Biblioteca bbta = (Biblioteca)obj[1];

		     session.delete(bbta);		
		     session.getTransaction().commit();		     
		     session.close();		     
		     return true;
		     
		}
		
		catch(Exception e) {
			System.out.println("Error: " + e.toString());
			return false;
		}
		 

	 }
	
	public Biblioteca ObtenerBiblioteca(String ISBN) {
		
		try {
		
	 	 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();
		 
		 List<Object[]> listaObject = (List<Object[]>)session.createQuery("FROM Libro l inner join l.biblioteca b where l.ISBN ='"+ISBN+"' and b.estado = 0 ").list();

	     Biblioteca bib = (Biblioteca)listaObject.get(0)[1];
	     
	     session.close();	    
	     return bib;
		
		}catch(Exception ex) {
		
	    System.out.println("Error: "+ ex.toString());
	    return null;
		}
	}
	
	
	public List<Object[]> ListarBibliotecas() {
		 
		 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();
	     
	     List<Object[]> listaObject = (List<Object[]>)session.createQuery("FROM Libro l inner join l.biblioteca").list();
	     
	     session.close();	     
	     return listaObject;
	 }
	
	public List<Libro> ListarLibros() {
		 
	 	DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();
	     
	     List<Libro> listaLibros = (List<Libro>)session.createQuery("FROM Libro l").list();
	     
	     session.close();	     
	     return listaLibros;
	 }
	
	public Libro BuscarLibro(String ISBN) {
		 
		 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();
	     
	     Libro lib = (Libro)session.createQuery("FROM Libro l where l.ISBN = '" + ISBN + "'").uniqueResult();
	     
	     session.close();	     
	     return lib;
	 }
	

	
	public Object[] BuscarBiblioteca(String id) {
		 
		 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();
	     
	     Object[] listaObject = (Object[])session.createQuery("FROM Libro l inner join l.biblioteca b where b.id = '" + id + "'").uniqueResult();
	     
	     session.close();	     
	     return listaObject;
	 }
	
	public boolean ActualizarEstadoBiblioteca(String idBiblioteca, int estado) {
		 // estado --> 0 : en biblioteca y 1 : prestado
		
		 DaoSession daoSession = new DaoSession();
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();

	     Object[] obj = BuscarBiblioteca(idBiblioteca);
	     Biblioteca bbta = (Biblioteca)obj[1];	
	     
	     //bbta.setFecha_alta(java.sql.Date.valueOf(  ));
	     
	     bbta.setEstado(estado);
	     session.update(bbta);
	     session.getTransaction().commit();	     
	     session.close();
	     
	     return true;
	 }
}

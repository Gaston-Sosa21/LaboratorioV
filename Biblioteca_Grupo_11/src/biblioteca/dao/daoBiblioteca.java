package biblioteca.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Libro;

public class daoBiblioteca {

	public Boolean CargarBiblioteca(String ISBN, String FechaAlta, int Estado) {
		
		try {
			
			SessionFactory sessionFactory;
	    	
	    	 Configuration configuration = new Configuration();
	    	 configuration.configure();	
	    	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	 Session session = sessionFactory.openSession();
	 
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
	
	public Boolean ModificarBiblioteca(String id, String ISBN, String FechaAlta, int Estado) {
		
		try {
			
			SessionFactory sessionFactory;
	    	
	    	 Configuration configuration = new Configuration();
	    	 configuration.configure();	
	    	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	 Session session = sessionFactory.openSession();
	 
		     session.beginTransaction();
		     
		     
		     Object[] obj = BuscarBiblioteca(id);
		     Libro lib = BuscarLibro(ISBN);
		     Biblioteca bbta = (Biblioteca)obj[1];
		     
		     
		     bbta.setFecha_alta(java.sql.Date.valueOf(FechaAlta.toString()));
		     bbta.setEstado(Estado);
		     
		     
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
			
			SessionFactory sessionFactory;
	    	
	    	 Configuration configuration = new Configuration();
	    	 configuration.configure();	
	    	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	 Session session = sessionFactory.openSession();
	 
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
	
	
	public List<Object[]> ListarBibliotecas() {
		 
		 SessionFactory sessionFactory;
    	
	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();
	     
	     List<Object[]> listaObject = (List<Object[]>)session.createQuery("FROM Libro l inner join l.biblioteca").list();
	     
	     session.close();
	     
	     return listaObject;
	 }
	
	public List<Libro> ListarLibros() {
		 
		 SessionFactory sessionFactory;
   	
	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();
	     
	     List<Libro> listaLibros = (List<Libro>)session.createQuery("FROM Libro l").list();
	     
	     session.close();
	     
	     return listaLibros;
	 }
	
	public Libro BuscarLibro(String ISBN) {
		 
		 SessionFactory sessionFactory;
  	
	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();
	     
	     Libro lib = (Libro)session.createQuery("FROM Libro l where l.ISBN = '" + ISBN + "'").uniqueResult();
	     
	     session.close();
	     
	     return lib;
	 }
	
	public Object[] BuscarBiblioteca(String id) {
		 
		 SessionFactory sessionFactory;
 	
	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();
	     
	     Object[] listaObject = (Object[])session.createQuery("FROM Libro l inner join l.biblioteca b where b.id = '" + id + "'").uniqueResult();
	     
	     session.close();
	     
	     return listaObject;
	 }
}

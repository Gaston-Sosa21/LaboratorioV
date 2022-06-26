package biblioteca.dao;
import javax.persistence.Entity;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Libro;

public class daoHibernate {

	/*
	private SessionFactory sessionFactory;
	
	public static void abrirConexion() {
		
		
    	
	    Configuration configuration = new Configuration();
	    configuration.configure();	
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	  
	     Session session = sessionFactory.openSession();
	     
	     session.beginTransaction();
	}*/
	
	public static void InsertBiblioteca(String ISBN, String FechaAlta, int Estado, Session session) {
		 

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

	 }
	
	public static void DeleteBiblioteca(Biblioteca biblio, ArrayList<Biblioteca> listaBibliotecas4, Session session) {
		 
		session.beginTransaction();
		listaBibliotecas4.remove(biblio);
		session.delete(biblio);
	    session.getTransaction().commit();
	    
	    
	 }
	
	public static Biblioteca ListarBiblioteca(Biblioteca biblioteca, Session session) {
		 
	     
	     Biblioteca bib = (Biblioteca)session.get(Biblioteca.class, biblioteca.getId());
	     
	     return bib;
	 }
	
	 public static void UpdateBiblioteca(Biblioteca biblioteca, Session session) {
		 
		
    
	     session.beginTransaction();
	     session.update(biblioteca);
	     session.getTransaction().commit();

	 }


	 
}

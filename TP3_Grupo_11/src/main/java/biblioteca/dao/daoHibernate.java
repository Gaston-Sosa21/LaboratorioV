package biblioteca.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import biblioteca.entidad.Biblioteca;

public class daoHibernate {

	
	
	 public static void UpdateBiblioteca(Biblioteca biblioteca) {
		 
		SessionFactory sessionFactory;
	    	
	    Configuration configuration = new Configuration();
	    configuration.configure();	
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	  
	     Session session = sessionFactory.openSession();
	     
	     session.beginTransaction();
	     session.update(biblioteca);
	     session.getTransaction().commit();
	     
	     session.close();
	 }
	 
}

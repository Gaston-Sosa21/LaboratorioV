package biblioteca.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DaoSession {
	
	 private SessionFactory sessionFactory;
	 private Configuration configuration;
	 private ServiceRegistry serviceRegistry;
	 
	 DaoSession()
	 {
		  	this.configuration = new Configuration();
		  	this.configuration.configure();	
		  	this.serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		  	this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	 }
	 
	 public Session AbrirSession()
	 {
	  	return sessionFactory.openSession();
	 }	  

}

package biblioteca.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import biblioteca.entidad.Cliente;
import biblioteca.dao.daoHibernate;

public class daoCliente {

	
	
	public static void CargarCliente(Cliente clientedatos) {
		 

		SessionFactory sessionFactory;
    	
    	Configuration configuration = new Configuration();
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
 
    	session.beginTransaction();
		
	     
	    System.out.println("Recibí datos del cliente " + clientedatos.getApellidos() + " " + clientedatos.getNombres());
	    
	    session.save(clientedatos);
	    
	    session.getTransaction().commit();

	 }
	
}

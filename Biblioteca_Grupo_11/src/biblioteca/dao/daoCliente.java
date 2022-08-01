package biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import biblioteca.entidad.Cliente;
import biblioteca.entidad.Libro;
import biblioteca.dao.daoHibernate;

public class daoCliente {

	
	
	public int CargarCliente(Cliente clientedatos) {
		 
		try {
			
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

		    return 1;
		    
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
			return 0;
		}
		
	 }
	
	public List<Cliente> ListarClientes() {
		 
		 SessionFactory sessionFactory;
  	
	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();
	     
	     List<Cliente> listaClientes = (List<Cliente>)session.createQuery("FROM Cliente l").list();
	     
	     session.close();
	     
	     return listaClientes;
	 }
	
}

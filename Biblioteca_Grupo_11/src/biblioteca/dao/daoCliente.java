package biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.dao.daoHibernate;

import biblioteca.entidad.Nacionalidad;

public class daoCliente {

	
	
	public int CargarCliente(Clientes clientedatos) {
		 
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
	

	public List<Object[]> ListarClientes() {
		
	 try {
		
		 SessionFactory sessionFactory;
	    	
	    	Configuration configuration = new Configuration();
	    	configuration.configure();	
	    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	Session session = sessionFactory.openSession();
	 
	    	session.beginTransaction();
			
		    List<Object[]> CL = (List<Object[]>) session.createQuery("FROM Clientes").list();
		    
		    session.close();
		    return CL;

	 }catch(Exception ex) {
			System.out.println("Error: " + ex.toString());

		 return null;
	 }
				
	}
	
	
	public Clientes BuscarClienteID(String ID) {
		
		try {
			
			 SessionFactory sessionFactory;
			
		   	 Configuration configuration = new Configuration();
		   	 configuration.configure();	
		   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		   	 Session session = sessionFactory.openSession();

		     session.beginTransaction();
		     
		     
		     Clientes Cli = (Clientes)session.createQuery("FROM Clientes c where c.id = '" + ID + "'").uniqueResult();
		     
		     session.close();
		     
		     return Cli;
		 }catch(Exception ex) {
				System.out.println("Error: " + ex.toString());

			 return null;
		 }		 
	}
	
	
	public int ActualizarDatosCliente(Clientes cli) {
		try {
			 SessionFactory sessionFactory;
				
		   	 Configuration configuration = new Configuration();
		   	 configuration.configure();	
		   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		   	 Session session = sessionFactory.openSession();

		     session.beginTransaction();
		     
		     session.update(cli);
		     session.getTransaction().commit();
		     session.close();
		     
		     return 1;
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());

			return 0;
		}
	}

	public int BorrarCliente(Clientes cli) {
		try {
			
		   	 SessionFactory sessionFactory;
	    	
	    	 Configuration configuration = new Configuration();
	    	 configuration.configure();	
	    	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	 Session session = sessionFactory.openSession();
	 
	    	 cli.setNacionalidad(null);
		     session.beginTransaction();
		     
		     session.delete(cli);
		     session.getTransaction().commit();  
		     session.close();
		     
			 return 1;
		}catch(Exception ex) {
			return 0;
		}
	}
	
	public List<Object[]> ListarNacionalidades() {
		try {
			SessionFactory sessionFactory;
	    	
	    	Configuration configuration = new Configuration();
	    	configuration.configure();	
	    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	Session session = sessionFactory.openSession();
	 
	    	session.beginTransaction();
			
		    List<Object[]> LN = (List<Object[]>) session.createQuery("FROM Nacionalidad n order by n.descripcion").list();
		  
		    session.close();
			sessionFactory.close();

		    return LN;
		    
		}catch(Exception ex) {
			System.out.println("Error en daocliente: " + ex.toString());
			return null;
		}
		
	   
	}
	public Nacionalidad BuscarIdNacionalidad(int Naci) {
		try {
			
			 SessionFactory sessionFactory;
			
		   	 Configuration configuration = new Configuration();
		   	 configuration.configure();	
		   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		   	 Session session = sessionFactory.openSession();

		     session.beginTransaction();
		     
		     
		     Nacionalidad ND = (Nacionalidad)session.createQuery("SELECT c FROM Nacionalidad c where c.id = '"+Naci+"'").uniqueResult();
		     
		     session.close();
		     
		     return ND;
		 }catch(Exception ex) {
				System.out.println("Error: " + ex.toString());

			 return null;
		 }	
	}
	

}

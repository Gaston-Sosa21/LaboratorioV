package biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.dao.daoHibernate;

import biblioteca.entidad.Nacionalidad;
import resources.Config;

public class daoCliente {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	
	public int CargarCliente(Clientes clientedatos) {
		 
		try {
			
			 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();
					     
		     System.out.println("Recib� datos del cliente " + clientedatos.getApellidos() + " " + clientedatos.getNombres());
		    
		     session.save(clientedatos);		    
		     session.getTransaction().commit();
		     session.close();
		     return 1;
		    
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
			return 0;
		}
		
	 }
	

	public List<Object[]> ListarClientes() {
		
	 try {
		
		 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
		 Session session = daoSession.AbrirSession();
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
			
		 	DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
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
			DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
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
			
			DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();
	 
	    	 cli.setNacionalidad(null);	
		     
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
			
			 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();
			
		    List<Object[]> LN = (List<Object[]>) session.createQuery("FROM Nacionalidad n order by n.descripcion").list();
		  
		    session.close();
		    return LN;
		    
		}catch(Exception ex) {
			System.out.println("Error en daocliente: " + ex.toString());
			return null;
		}
		
	   
	}
	public Nacionalidad BuscarIdNacionalidad(int Naci) {
		try {
			
			 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();		     
		     
		     Nacionalidad ND = (Nacionalidad)session.createQuery("SELECT c FROM Nacionalidad c where c.id = '"+Naci+"'").uniqueResult();
		     
		     session.close();
		     return ND;
		     
		 }catch(Exception ex) {
				System.out.println("Error: " + ex.toString());

			 return null;
		 }	
	}
	
	public int ExisteDNI(int dni) {
		
		try {
			
			 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();		     
		     
		     Long cantidad = (Long)session.createQuery("SELECT count(c.id) FROM Clientes c where c.dni = "+ dni ).uniqueResult();
		     
		     int existe = Math.toIntExact(cantidad);		     
		     session.close();		     
		     return existe;
		     
		 }catch(Exception ex) {
				System.out.println("Error: " + ex.toString());

			 return 0;
		 }		 
	}
	
	public int VerificarNuevoDNI(Clientes cli) {
		try {
			
			 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();		     
		     
		     Long cantidad = (Long)session.createQuery("SELECT count(c.id) FROM Clientes c where c.dni = "+ cli.getDni() ).uniqueResult();
		     
		     int existe = Math.toIntExact(cantidad);		     
		     session.close();		     
		     return 1;
		     
		 }catch(Exception ex) {
				System.out.println("Error: " + ex.toString());

			 return 0;
		 }
	}
	
	public int ClienteConPrestamos(int id) {
		try {
			
			 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
			 Session session = daoSession.AbrirSession();
			 session.beginTransaction();		     
		     
		     Long cantidad = (Long)session.createQuery("SELECT count(*) FROM Prestamo p inner join p.cliente as c where c.id="+id ).uniqueResult();
		     
		     int existe = Math.toIntExact(cantidad);		     
		     session.close();		     
		     return existe;
		     
		 }catch(Exception ex) {
				System.out.println("Error: " + ex.toString());

			 return 0;
		 }
	}

}

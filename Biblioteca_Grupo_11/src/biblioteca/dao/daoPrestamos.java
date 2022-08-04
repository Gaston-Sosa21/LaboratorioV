package biblioteca.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Prestamo;

public class daoPrestamos {

public Boolean CargarPrestamo(Biblioteca biblioteca, Date fecha_prestamo, Integer cantidad_dias, Clientes cliente) {

		try {

			SessionFactory sessionFactory;	    	
	    	 Configuration configuration = new Configuration();
	    	 configuration.configure();	
	    	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    	 Session session = sessionFactory.openSession();	 
		     session.beginTransaction();

		     Prestamo prestamo = new Prestamo(biblioteca,fecha_prestamo,cantidad_dias,cliente);	     

		     //Agregamos el nuevo prestamos a la lista
		     ArrayList<Prestamo> Lprestamos = new ArrayList<Prestamo>();		     
		     Lprestamos.add(prestamo);	
		     //lo guardamos en la sesion
		     session.save(Lprestamos);
		     //comiteamos los cambios
		     session.getTransaction().commit();
		     //cerramos la sesion
		     session.close();
		     //OK
		     return true;		     
		}		
		catch(Exception e) {
			System.out.println("Error: " + e.toString());
			return false;
		}	

	 }
/*
public Boolean ModificarBiblioteca(int Id, String ISBN, String FechaAlta, int Estado) {
	
	try {
		
		SessionFactory sessionFactory;
    	
    	 Configuration configuration = new Configuration();
    	 configuration.configure();	
    	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	 Session session = sessionFactory.openSession();
 
	     session.beginTransaction();
	     
	     
	     Object[] obj = BuscarPrestamo(Id);
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
*/
public Boolean EliminarPrestamo(int Id) {

	try {

		SessionFactory sessionFactory;

    	 Configuration configuration = new Configuration();
    	 configuration.configure();	
    	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	 Session session = sessionFactory.openSession();

	     session.beginTransaction();


	     Object[] obj = BuscarObjPrestamo(Id);
	     Prestamo prestamo = (Prestamo)obj[1];

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

		 SessionFactory sessionFactory;

	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();

	     //Buscamos los prestamos con los clientes
	     List<Object[]> listaObject = (List<Object[]>)session.createQuery("FROM Prestamo p inner join p.Clientes").list();

	     session.close();

	     return listaObject;
	 }

	public List<Prestamo> ListarPrestamos() {

		 SessionFactory sessionFactory;

	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();

	     List<Prestamo> listaPrestamos = (List<Prestamo>)session.createQuery("FROM Prestamo p").list();

	     session.close();

	     return listaPrestamos;
	 }

	public Prestamo BuscarPrestamo(int Id) {

		 SessionFactory sessionFactory;

	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();

	     Prestamo prestamo = (Prestamo)session.createQuery("FROM Prestamo p where p.Id = " + Id + "").uniqueResult();

	     session.close();

	     return prestamo;
	 }

	public Object[] BuscarObjPrestamo(int Id) {

		 SessionFactory sessionFactory;

	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();

	     Object[] listaObject = (Object[])session.createQuery("FROM Prestamo p where p.Id = " + Id + "").uniqueResult();

	     session.close();

	     return listaObject;
	 }

}
package biblioteca.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import biblioteca.entidad.Nacionalidad;
import biblioteca.dao.daoHibernate;

public class daoNacionalidad {	
	
	
	public List<Nacionalidad> ListarNacionalidades() {
		 
		 SessionFactory sessionFactory;
	
	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	     session.beginTransaction();
	     
	     List<Nacionalidad> listaNacionalidades = (List<Nacionalidad>)session.createQuery("FROM Nacionalidad n").list();
	     
	     session.close();
	     
	     return listaNacionalidades;
	 }
}

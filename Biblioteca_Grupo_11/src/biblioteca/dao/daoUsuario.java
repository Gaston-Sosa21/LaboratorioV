package biblioteca.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import biblioteca.entidad.Usuario;

public class daoUsuario {

	public boolean ValidarUsuario(String nombre, String clave) {
		Usuario usuarios = null;
		 SessionFactory sessionFactory;
	   	 Configuration configuration = new Configuration();
	   	 configuration.configure();	
	   	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	   	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   	 Session session = sessionFactory.openSession();

	   	 session.beginTransaction();
	   	 
	   	usuarios = (Usuario)session.createQuery("FROM Usuario U WHERE U.nombre = '"+ nombre +"'").uniqueResult();
	   	
	   	session.close();		
	   	
	   	if (usuarios != null && usuarios.getClave().equals(clave)) {
	   				
	                return true;
	            }
	   			else {	
	   				return false;
	   			}
	   			
    }

	
}

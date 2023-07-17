package biblioteca.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biblioteca.entidad.Usuario;
import resources.Config;

public class daoUsuario {

	//SI NO ANDAN LOS BEANS DEL Config.JAVA dejar esta de abajo y borrar el otro context
	ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
	//ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	
	public boolean ValidarUsuario(String nombre, String clave) {
		Usuario usuarios = null;
		
		 DaoSession daoSession = (DaoSession) appContext.getBean("daoSession");
		 Session session = daoSession.AbrirSession();
		 session.beginTransaction();
	   	 
	   	usuarios = (Usuario)session.createQuery("FROM Usuario U WHERE U.nombre = '"+ nombre +"'").uniqueResult();
	   	
	   	session.close();		
	   	
	   	if (usuarios != null && usuarios.getClave().equals(clave))	   				
	       return true;
	   else 
		   return false;
	   			
    }
}

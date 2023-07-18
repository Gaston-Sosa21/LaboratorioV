package biblioteca.negocio;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biblioteca.dao.DaoSession;
import biblioteca.dao.daoUsuario;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Usuario;
import resources.Config;

public class NegocioUsuario {
	
	//SI NO ANDAN LOS BEANS DEL Config.JAVA dejar esta de abajo y borrar el otro context
	//ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
	//ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);	
	//daoUsuario udao = new daoUsuario(); //(daoUsuario) appContext.getBean("daoUsuarioBean");

	public Boolean AltaUsuario(String nombre,String clave) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		daoUsuario udao = (daoUsuario) appContext.getBean("daoUsuarioBean");
		
   try {    
		 return udao.ValidarUsuario(nombre, clave);			
		}catch(Exception ex){			
			System.out.println("Error: " + ex.toString());
			return false;
		}
	}
}

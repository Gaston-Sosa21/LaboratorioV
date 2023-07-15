package biblioteca.negocio;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import biblioteca.dao.DaoSession;
import biblioteca.dao.daoUsuario;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Usuario;
import resources.Config;

public class NegocioUsuario {
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	
	daoUsuario udao = new daoUsuario();//(daoUsuario) appContext.getBean("daoUsuariobean");

	public Boolean AltaUsuario(String nombre,String clave) {	
		
   try {	    
		    
			return udao.ValidarUsuario(nombre, clave);
			
		}catch(Exception ex){
			
			System.out.println("Error: " + ex.toString());
			return false;
		}
	}
}

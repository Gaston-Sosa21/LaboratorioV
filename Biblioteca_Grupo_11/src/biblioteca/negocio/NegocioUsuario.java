package biblioteca.negocio;

import java.sql.Date;

import biblioteca.dao.daoUsuario;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Usuario;

public class NegocioUsuario {
	
	daoUsuario udao = new daoUsuario();

	public Boolean AltaUsuario(String nombre,String clave) {	
		
   try {	    
		    
			return udao.ValidarUsuario(nombre, clave);
			
		}catch(Exception ex){
			
			System.out.println("Error: " + ex.toString());
			return false;
		}
	}
}

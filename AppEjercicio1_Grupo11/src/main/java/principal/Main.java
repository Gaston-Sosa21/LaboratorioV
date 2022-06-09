package principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidad.Usuario;
import negocio.UsuarioNegocio;

public class Main {

	static ApplicationContext appContext;
	
	public static void main(String[] args) {
		
		appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");		
		
		//Los atributos se completaron en el XML
		//usuario.setUsuario("Pepe");
	    //usuario.setContrasenia("123");
		
		//Obtener usuarioArturo objeto que retorna el Bean
		Usuario usuarioArturo = (Usuario) appContext.getBean("usuarioArturo");
		//actualizo el password del objeto desde el main con el set
		usuarioArturo.setContrasenia("#"+usuarioArturo.getContrasenia()+"#");
		//Obtener usuarioArturo objeto que retorna el Bean
		Usuario usuarioJose = (Usuario) appContext.getBean("usuarioJose");
		//actualizo el password del objeto desde el main con el set
		usuarioJose.setContrasenia("#"+usuarioJose.getContrasenia()+"#");  
	    
	    UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("usuarioNegocio") ;
	    boolean estadoArturo= usuarioNegocio.agregarUsuario(usuarioArturo);
	    boolean estadoJose= usuarioNegocio.agregarUsuario(usuarioJose);
	    if(estadoArturo)
	    	System.out.println("Se agrego correctamente a Arturo");
	    else
	    	System.out.println("No se pudo agregar a Arturo, el usuario ya existe en la BD");
	    
	    if(estadoJose)
	    	System.out.println("Se agrego correctamente a Jose");
	    else
	    	System.out.println("No se pudo agregar a Jose, el usuario ya existe en la BD");
		   
	    ((ConfigurableApplicationContext)(appContext)).close();
	}	
}

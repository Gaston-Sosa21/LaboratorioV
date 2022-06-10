package negocio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.UsuarioDao;
import entidad.Usuario;
import resources.Config;

public class UsuarioNegocio {

	private UsuarioDao usuarioDao;
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	
	public boolean agregarUsuario(Usuario usuario)
	{
		usuarioDao = (UsuarioDao) appContext.getBean("usuarioDao");
		boolean existe = usuarioDao.Exist(usuario.getUsuario());
		if(existe ==false)
		{
			usuarioDao.Add(usuario);
			return true;
		}
		return false;
	}
}

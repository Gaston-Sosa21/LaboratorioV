package negocio;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UsuarioDao;
import entidad.Usuario;

public class UsuarioNegocio {

	private UsuarioDao usuarioDao;
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("Resources/Beans.xml");
	
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

package resources;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import dao.UsuarioDao;
import entidad.Usuario;
import negocio.UsuarioNegocio;

@Configuration
public class Config {

	@Bean(initMethod="initUsuario", destroyMethod="destroyUsuario")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Usuario usuarioArturo() {
		
		Usuario usu = new Usuario();
		usu.setUsuario("ArturoIllia");
		usu.setContrasenia("Arturo@123");
		
		return usu;
	}
	
	@Bean(initMethod="initUsuario", destroyMethod="destroyUsuario")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Usuario usuarioJose() {
		
		return new Usuario("JoseLuisPerales", "Jose@123");
	}
	
	@Bean
	@Scope(value= ConfigurableBeanFactory.SCOPE_SINGLETON)
	public UsuarioNegocio usuarioNegocio() {
		
		return new UsuarioNegocio();
	}
	
	@Bean
	@Scope(value= ConfigurableBeanFactory.SCOPE_SINGLETON)
	public UsuarioDao usuarioDao() {
		
		return new UsuarioDao();
	}
}
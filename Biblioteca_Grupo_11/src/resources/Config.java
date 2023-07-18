package resources;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import biblioteca.dao.DaoSession;
import biblioteca.dao.daoUsuario;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Prestamo;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Nacionalidad;
import biblioteca.dao.daoBiblioteca;
import biblioteca.dao.daoPrestamos;
import biblioteca.dao.daoCliente;

/**  *********************************************************************************** 
SE DEBE USAR ESTE ARCHIVO Ó EL OTRO, INTENTAR NO USAR AMBOS

Comentario importante. Hay dos formas de usar los BEANS:

Si se declara previamente el 
ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
se debe usar el BEAN del "Beans.xml"

Si se declara previamente el 
ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
se debe usar el BEAN del Config.java

*************************************************************************************/

@Configuration
public class Config {
	
	//Beans de entidades 
	
	@Bean//(initMethod = "initBiblioteca", destroyMethod = "destroyBiblioteca")
	@Scope("prototype")
    public Biblioteca BibliotecaBean() {
        return new Biblioteca();
    }
	
	@Bean(initMethod = "initPrestamo", destroyMethod = "destroyPrestamo")
	@Scope("prototype")
    public Prestamo PrestamoBean() {
        return new Prestamo();
    }
	
	@Bean(initMethod = "initPersona", destroyMethod = "destroyPersona")
	@Scope("prototype")
    public Clientes ClienteBean() {
        return new Clientes();
    }
	
	@Bean(initMethod = "initNacionalidad", destroyMethod = "destroyNacionalidad")
	@Scope("prototype")
    public Nacionalidad NacionalidadBean() {
        return new Nacionalidad();
    }		
	
    //Beans de daos  
	
	@Bean
	//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public DaoSession daoSession() {
        return new DaoSession();
    }
    
    @Bean
    public daoPrestamos daoPrestamosBean() {
        return new daoPrestamos();
    }	
    	
    @Bean
    public daoBiblioteca daoBibliotecaBean() {
        return new daoBiblioteca();
    }    
    
    @Bean
    public daoCliente daoClienteBean() {
        return new daoCliente();
    }    
    
    @Bean
    @Scope("prototype")
    public daoUsuario daoUsuarioBean() {
        return new daoUsuario();
    }
	
}
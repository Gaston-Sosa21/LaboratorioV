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
import biblioteca.negocio.NegocioBiblioteca;
import biblioteca.negocio.NegocioCliente;
import biblioteca.negocio.NegocioPrestamos;
import biblioteca.negocio.NegocioUsuario;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Nacionalidad;
import biblioteca.dao.daoBiblioteca;
import biblioteca.dao.daoPrestamos;
import biblioteca.dao.daoCliente;

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
	
	@Bean(initMethod = "initLibro", destroyMethod = "destroyLibro")
	@Scope("prototype")
    public Libro LibroBean() {
        return new Libro();
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
    
    //Beans Negocios
    
    @Bean
    public NegocioBiblioteca NegocioBibliotecaBean() {    	
        return new NegocioBiblioteca();
    }
    
    @Bean
    public NegocioCliente NegocioClienteBean() {
        return new NegocioCliente();
    }  
    
    @Bean
    public NegocioUsuario NegocioUsuarioBean() {
        return new NegocioUsuario();
    } 
    
    @Bean
    public NegocioPrestamos NegocioPrestamosBean() {
        return new NegocioPrestamos();    
    }
    
    
    
   
    
	
}
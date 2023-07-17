package resources;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import biblioteca.dao.DaoSession;
import biblioteca.dao.daoUsuario;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Prestamo;
import biblioteca.entidad.Clientes;
import biblioteca.dao.daoBiblioteca;
import biblioteca.dao.daoPrestamos;
import biblioteca.dao.daoCliente;

//Aca dejo los beans de las entidades y por xml los beans de los dao

@Configuration
public class Config {
	
	//Beans de entidades 
	
	@Bean(initMethod = "initBiblioteca", destroyMethod = "destroyBiblioteca")
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
		
	
    //Beans de daos
    
    @Bean
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
    public daoUsuario daoUsuarioBean() {
        return new daoUsuario();
    }
	
}
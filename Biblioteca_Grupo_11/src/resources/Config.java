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
import biblioteca.dao.daoBiblioteca;
import biblioteca.dao.daoPrestamos;
import biblioteca.dao.daoCliente;


@Configuration
public class Config {

	@Bean
    public Biblioteca biblioteca() {
        return new Biblioteca();
    }

	@Bean
    public DaoSession daoSession() {
        return new DaoSession();
    }
	
	

	@Bean
    public Prestamo prestamobean() {
        return new Prestamo();
    }
    /*	
    @Bean
    public daoBiblioteca daoBibliotecabean() {
        return new daoBiblioteca();
    }
    
    @Bean
    public daoPrestamos daoPrestamosbean() {
        return new daoPrestamos();
    }
    
    @Bean
    public daoCliente daoClientebean() {
        return new daoCliente();
    }
    
    @Bean
    public daoUsuario daoUsuariobean() {
        return new daoUsuario();
    }
	*/
}
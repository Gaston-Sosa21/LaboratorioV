package resources;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import biblioteca.dao.daoBiblioteca;
import biblioteca.dao.daoPrestamos;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Prestamo;
import biblioteca.negocio.NegocioBiblioteca;
import biblioteca.negocio.NegocioPrestamos;



@Configuration
public class ConfigPrestamo {
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigBiblioteca.class);

	@Bean(initMethod="initPrestamo", destroyMethod="destroyPrestamo")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Prestamo nuevoPrestamo() {

		return new Prestamo();
	}
	
	@Bean(initMethod="initPrestamo", destroyMethod="destroyPrestamo")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public daoPrestamos nuevoDaoPrestamo() {
		
		return new daoPrestamos();
		
	}
	
	@Bean(initMethod="initPrestamo", destroyMethod="destroyPrestamo")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public NegocioPrestamos nuevoNegocioPrestamo() {
		
		return new NegocioPrestamos((daoPrestamos)appContext.getBean("nuevoDaoPrestamos"));
		
	}
	
}
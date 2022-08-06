package resources;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import biblioteca.entidad.Biblioteca;


@Configuration
public class Config {

	@Bean(initMethod="initBiblioteca", destroyMethod="destroyBiblioteca")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Biblioteca nuevaBiblioteca() {
		
		Biblioteca bib = new Biblioteca();
		return bib;
	}	
	
}
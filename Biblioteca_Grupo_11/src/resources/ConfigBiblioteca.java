package resources;

import java.util.ArrayList;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import biblioteca.dao.daoBiblioteca;
import biblioteca.entidad.Autor;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Genero;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Nacionalidad;
import biblioteca.negocio.NegocioBiblioteca;



@Configuration
public class ConfigBiblioteca {
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigBiblioteca.class);

	@Bean(initMethod="initBiblioteca", destroyMethod="destroyBiblioteca")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Biblioteca nuevaBiblioteca() {

		return new Biblioteca();
	}
	
	@Bean(initMethod="initBiblioteca", destroyMethod="destroyBiblioteca")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ArrayList<Biblioteca> nuevaListaBibliotecas() {

		return new ArrayList<Biblioteca>();
	}
	
	@Bean(initMethod="initLibro", destroyMethod="destroyLibro")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Libro nuevoLibro() {

		return new Libro();
	}
	
	@Bean(initMethod="initGenero", destroyMethod="destroyGenero")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Genero nuevoGenero() {

		return new Genero();
	}
	
	@Bean(initMethod="initAutor", destroyMethod="destroyAutor")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Autor nuevoAutor() {

		return new Autor();
	}
	
	@Bean(initMethod="initNacionalidad", destroyMethod="destroyNacionalidad")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Nacionalidad nuevoNacionalidad() {

		return new Nacionalidad();
	}
	
	@Bean(initMethod="initBiblioteca", destroyMethod="destroyBiblioteca")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public daoBiblioteca nuevoDaoBiblioteca() {
		
		return new daoBiblioteca();
		
	}
	
	@Bean(initMethod="initBiblioteca", destroyMethod="destroyBiblioteca")
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public NegocioBiblioteca nuevoNegocioBiblioteca() {
		
		return new NegocioBiblioteca((daoBiblioteca)appContext.getBean("nuevoDaoBiblioteca"));
		
	}
	
}
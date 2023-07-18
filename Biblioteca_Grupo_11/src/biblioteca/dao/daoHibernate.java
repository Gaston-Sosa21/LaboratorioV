package biblioteca.dao;
import javax.persistence.Entity;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Libro;
import resources.Config;

public class daoHibernate {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	
	public void InsertBiblioteca(String ISBN, String FechaAlta, int Estado, Session session) {
		//SI NO ANDAN LOS BEANS DEL Config.JAVA dejar esta de abajo y borrar el otro context
		//ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
		//ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
	     session.beginTransaction();	     
	     Biblioteca bbta = (Biblioteca) appContext.getBean("BibliotecaBean");
	     bbta.setFecha_alta(java.sql.Date.valueOf(FechaAlta.toString()));
	     bbta.setEstado(Estado);  
	     Libro lib = (Libro)session.get(Libro.class, ISBN);	     
	     ArrayList<Biblioteca> lb= new ArrayList<Biblioteca>();
	     lb.add(bbta);    	
	     lib.setBiblioteca(lb);	     
	     session.save(lib);
	     session.getTransaction().commit();
	 }
	
	public void DeleteBiblioteca(Biblioteca biblio, ArrayList<Biblioteca> listaBibliotecas4, Session session) {		 
		session.beginTransaction();
		listaBibliotecas4.remove(biblio);
		session.delete(biblio);
	    session.getTransaction().commit();
	 }
	
	public Biblioteca ListarBiblioteca(Biblioteca biblioteca, Session session) { 
	     Biblioteca bib = (Biblioteca)session.get(Biblioteca.class, biblioteca.getId());	     
	     return bib;
	 }
	
	 public void UpdateBiblioteca(Biblioteca biblioteca, Session session) {
	     session.beginTransaction();
	     session.update(biblioteca);
	     session.getTransaction().commit();
	 }


	 
}

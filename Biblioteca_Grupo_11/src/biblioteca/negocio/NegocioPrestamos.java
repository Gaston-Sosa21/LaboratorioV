package biblioteca.negocio;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biblioteca.dao.daoPrestamos;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Prestamo;
import resources.Config;

public class NegocioPrestamos {

	//SI NO ANDAN LOS BEANS DEL Config.JAVA dejar esta de abajo y borrar el otro context
	ApplicationContext appContext = new ClassPathXmlApplicationContext("resources/Beans.xml");
	//ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);	
	daoPrestamos pdao = (daoPrestamos) appContext.getBean("daoPrestamosBean");

public Boolean AltaPrestamo(Biblioteca biblioteca, String fecha_prestamo, Integer cantidad_dias, Clientes cliente) {

		try {	    

			return pdao.CargarPrestamo(biblioteca, fecha_prestamo, cantidad_dias,cliente);

		}catch(Exception ex){

			System.out.println("Error: " + ex.toString());
			return false;
		}
	}

	//TERMINAR!
	public Boolean EditarPrestamo(String IdPrestamo, int txtCantidadDias){

		try {

		    return pdao.ModificarPrestamo(IdPrestamo, txtCantidadDias);

		}catch(Exception ex){

			System.out.println("Error: " + ex.toString());
			return false;
		}
	}

	public Boolean EliminarPrestamo(String idPrestamo) {

		try {

			return pdao.EliminarPrestamo(idPrestamo);		   

		}catch(Exception ex){

			System.out.println("Error: " + ex.toString());
			return false;
		}
	}


	public List<Object[]> ObtenerPrestamo(){

		try {

			return pdao.ListarObjPrestamos();
		}
		catch(Exception e) {

			System.out.println("Error: " + e.toString());

			return null;
		}
	}

	public  List<Object[]> ObtenerPrestamos(){

			try {

				return pdao.ListarPrestamosCompuestos();
			}
			catch(Exception e) {

				System.out.println("Error: " + e.toString());

				return null;
			}
	}
	
	public  List<Libro> ObtenerLibrosDeBiblioteca(){

		try {

			return pdao.ObtenerLibrosDeBiblioteca();
		}
		catch(Exception e) {

			System.out.println("Error: " + e.toString());

			return null;
		}
}
	

	public Prestamo ObtenerPrestamoPorId(String Id){

		try {

			return pdao.BuscarPrestamo(Id);
		}
		catch(Exception e) {

			System.out.println("Error: " + e.toString());

			return null;
		}
	}

	public Object[] ObtenerObjPrestamoPorId(String Id){

		try {

			return pdao.BuscarObjPrestamo(Id);
		}
		catch(Exception e) {

			System.out.println("Error: " + e.toString());

			return null;
		}
	}
}
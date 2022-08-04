package biblioteca.negocio;

import java.sql.Date;
import java.util.List;

import biblioteca.dao.daoPrestamos;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Prestamo;

public class NegocioPrestamos {

	daoPrestamos pdao = new daoPrestamos();

public Boolean AltaPrestamo(Biblioteca biblioteca, String fecha_prestamo, Integer cantidad_dias, Clientes cliente) {

		try {	    

			return pdao.CargarPrestamo(biblioteca, fecha_prestamo, cantidad_dias,cliente);

		}catch(Exception ex){

			System.out.println("Error: " + ex.toString());
			return false;
		}
	}

	//TERMINAR!
	public Boolean EditarPrestamo(int Id, Biblioteca biblioteca, Date fecha_prestamo, Integer cantidad_dias, Clientes cliente){

		try {

		    return true;

		//	return pdao.ModificarPrestamo(biblioteca, fecha_prestamo, cantidad_dias,cliente);


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
package biblioteca.negocio;

import java.sql.Date;
import java.util.List;

import biblioteca.dao.daoPrestamos;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Cliente;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Prestamo;

public class NegocioPrestamos {

	daoPrestamos pdao = new daoPrestamos();
	
public Boolean AltaPrestamo(Libro libro, Date fecha_prestamo, Integer cantidad_dias, Cliente cliente) {
		
		try {	    
		    
			return pdao.CargarPrestamo(libro, fecha_prestamo, cantidad_dias,cliente);
			
		}catch(Exception ex){
			
			System.out.println("Error: " + ex.toString());
			return false;
		}
	}
	
	//TERMINAR!
	public Boolean EditarPrestamo(int Id, Libro libro, Date fecha_prestamo, Integer cantidad_dias, Cliente cliente){
		
		try {
			
		    return true;
		    
		//	return pdao.ModificarPrestamo(biblioteca, fecha_prestamo, cantidad_dias,cliente);
		   
			
		}catch(Exception ex){
			
			System.out.println("Error: " + ex.toString());
			return false;
		}
	}
	
	public Boolean EliminarPrestamo(int Id) {
		
		try {
		    
			return pdao.EliminarPrestamo(Id);		   
			
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
	
	public List<Prestamo> ObtenerPrestamos(){
			
			try {
				
				return pdao.ListarPrestamos();
			}
			catch(Exception e) {
				
				System.out.println("Error: " + e.toString());
				
				return null;
			}
	}
	
	public Prestamo ObtenerPrestamoPorId(int Id){
		
		try {
			
			return pdao.BuscarPrestamo(Id);
		}
		catch(Exception e) {
			
			System.out.println("Error: " + e.toString());
			
			return null;
		}
	}
	
	public Object[] ObtenerObjPrestamoPorId(int Id){
		
		try {
			
			return pdao.BuscarObjPrestamo(Id);
		}
		catch(Exception e) {
			
			System.out.println("Error: " + e.toString());
			
			return null;
		}
	}
}

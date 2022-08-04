package biblioteca.negocio;

import java.util.ArrayList;
import java.util.List;

import biblioteca.dao.daoBiblioteca;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Libro;

public class NegocioBiblioteca {

	daoBiblioteca bdao = new daoBiblioteca();
	
	public Boolean AltaBiblioteca(String ISBN, String FechaAlta, int Estado) {
		
		try {
			
		    
		    
			return bdao.CargarBiblioteca(ISBN, FechaAlta, Estado);
		   
			
		}catch(Exception ex){
			
			System.out.println("Error: " + ex.toString());
			return false;
		}
	}
	
	public Boolean EditarBiblioteca(String id, String ISBN, String FechaAlta, int Estado) {
		
		try {
			
		    
		    
			return bdao.ModificarBiblioteca(id, ISBN, FechaAlta, Estado);
		   
			
		}catch(Exception ex){
			
			System.out.println("Error: " + ex.toString());
			return false;
		}
	}
	
	public Boolean EliminarBiblioteca(String id) {
		
		try {
			
		    
		    
			return bdao.EliminarBiblioteca(id);
		   
			
		}catch(Exception ex){
			
			System.out.println("Error: " + ex.toString());
			return false;
		}
	}
		
	
	public List<Object[]> ObtenerBibliotecas(){
		
		try {
			
			return bdao.ListarBibliotecas();
		}
		catch(Exception e) {
			
			System.out.println("Error: " + e.toString());
			
			return null;
		}
	}
	
	public List<Libro> ObtenerLibros(){
			
			try {
				
				return bdao.ListarLibros();
			}
			catch(Exception e) {
				
				System.out.println("Error: " + e.toString());
				
				return null;
			}
	}
	
	public Libro ObtenerLibroPorId(String ISBN){
		
		try {
			
			return bdao.BuscarLibro(ISBN);
		}
		catch(Exception e) {
			
			System.out.println("Error: " + e.toString());
			
			return null;
		}
	}
	
	public Object[] ObtenerBibliotecaPorId(String id){		
		try {			
			return bdao.BuscarBiblioteca(id);
		}
		catch(Exception e) {			
			System.out.println("Error: " + e.toString());			
			return null;
		}
	}
	
	public Biblioteca ObtenerBibliotecaPorISBN(String ISBN){		
		try {			
			return bdao.ObtenerBiblioteca(ISBN);
		}
		catch(Exception e) {			
			System.out.println("Error: " + e.toString());			
			return null;
		}
	}
}

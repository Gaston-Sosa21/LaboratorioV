package biblioteca.negocio;

import java.util.ArrayList;
import java.util.List;

import biblioteca.dao.daoBiblioteca;
import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Libro;

public class NegocioBiblioteca {

	daoBiblioteca bdao = new daoBiblioteca();
	
	public int AltaBiblioteca(String ISBN, String FechaAlta, int Estado) {
		
		try {
			
		    int valor = bdao.CargarBiblioteca(ISBN, FechaAlta, Estado);
			
		    return valor;
			
		}catch(Exception ex){
			
			System.out.println("Error: " + ex.toString());
			return 0;
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
}

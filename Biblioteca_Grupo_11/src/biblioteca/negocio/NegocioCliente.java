package biblioteca.negocio;

import java.util.ArrayList;
import java.util.List;

import biblioteca.dao.daoCliente;
import biblioteca.entidad.Cliente;
import biblioteca.entidad.Nacionalidad;

public class NegocioCliente {

	daoCliente dc = new daoCliente();
	
	public int AltaNuevoCliente(Cliente cli)
	{
		try {
		   
			int valor = dc.CargarCliente(cli);
		    return valor;
			
			}catch(Exception ex){
				
			System.out.println("Error: " + ex.toString());
			return 0;
		}	
	}
	
	
	public List<Object[]> ListarClientes()
	{
		try {
			List<Object[]> Clients = dc.ListarClientes(); 
			return Clients;
			
			}catch(Exception ex) {
			
			System.out.println("Error: " + ex.toString());
			return null;
		}
	}
	
	public Cliente ObtenerClientePorID(String ID)
	{
		try {
			Cliente Clients = dc.BuscarClienteID(ID); 
			return Clients;
			
			}catch(Exception ex) {
			
			System.out.println("Error: " + ex.toString());
			return null;
		}
	}
	
	public int ModificarCliente(Cliente cli) {
		try {
			 return dc.ActualizarDatosCliente(cli);
		}catch(Exception ex) {
		System.out.println("Error: " + ex.toString());
		return 0;
		}
	}
	
	public int BorrarCliente(String idCliente) {
		try {
			  Cliente Cliente = dc.BuscarClienteID(idCliente);
			  int i = dc.BorrarCliente(Cliente);
			  return i;
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
			return 0;	
		}
	}
	
	public List<Object[]> ListaNacionalidades()
	{
		try {
			List<Object[]> Nacio = dc.ListarNacionalidades(); 
			return Nacio;
			
			}catch(Exception ex) {
			
			System.out.println("Error: " + ex.toString());
			return null;
		}
	}
	
	public String BuscarNacionalidad(String Id) {
		try {
			  Nacionalidad i = dc.BuscarIdNacionalidad(Integer.parseInt(Id));
			  
			  String DescNacionalidad = i.getDescripcion();
			  return DescNacionalidad;
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
			return null;	
		}
		

	}
	public String ValidarDatos(String txtFecha,String txtDni, String txtMail, String txtTelefono) {
		try {
			  
			  String DescNacionalidad;
			  return "";
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
			return null;	
		}
	}
	
	public List<String> ListaLocalidades(){
		try {
			
			List<String> Ld = new ArrayList<String>();
			 Ld.add("Benavidez");
			 Ld.add("Don Torcuato");
			 Ld.add("El Talar");
			 Ld.add("Gral Pacheco");
			 Ld.add("Nordelta");
			 Ld.add("Ricardo Rojas");

			 System.out.println("Localidades: "+ Ld.toString());
			 return Ld;
		}catch(Exception ex) {
			System.out.println("Error: "+ ex.toString());
			return null;
		}
 
	}
}

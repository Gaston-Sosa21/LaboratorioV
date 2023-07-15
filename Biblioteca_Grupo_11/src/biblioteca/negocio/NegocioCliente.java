package biblioteca.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import biblioteca.dao.DaoSession;
import biblioteca.dao.daoCliente;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Nacionalidad;
import resources.Config;

public class NegocioCliente {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	
	daoCliente dc = new daoCliente();//(daoCliente) appContext.getBean("daoClientebean");
	
	public int AltaNuevoCliente(Clientes cli)
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
	
	public Clientes ObtenerClientePorID(String ID)
	{
		try {
			Clientes Clients = dc.BuscarClienteID(ID); 
			return Clients;
			
			}catch(Exception ex) {
			
			System.out.println("Error: " + ex.toString());
			return null;
		}
	}
	
	public int ModificarCliente(Clientes cli) {
		try {

			if(dc.ExisteDNI(cli.getDni())<1) {
				 return dc.ActualizarDatosCliente(cli);
			}else {
				return 2;
			}
			
		}catch(Exception ex) {
		System.out.println("Error: " + ex.toString());
		return 0;
		}
	}
	
	public int BorrarCliente(String idCliente) {
		try {
			  Clientes Cliente = dc.BuscarClienteID(idCliente);
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
	
	public String ValidarDatos(String txtFecha,String txtDni, String txtMail, String txtTelefono) {
		try {
			  
			  String Mensaje="";
			  
			  return "Ok";
		}catch(Exception ex) {
			System.out.println("Error: " + ex.toString());
			return null;	
		}
	}
	

	
	public int ValidarExistencia(String dni) {
		try {
			
			return dc.ExisteDNI(Integer.parseInt(dni));
			
		}catch(Exception ex) {
			System.out.println("Error: "+ ex.toString());
			return 0;	
		}
	}
	
	public int ClienteTienePrestamos(String id) {
		
		return dc.ClienteConPrestamos(Integer.parseInt(id));
	}
}

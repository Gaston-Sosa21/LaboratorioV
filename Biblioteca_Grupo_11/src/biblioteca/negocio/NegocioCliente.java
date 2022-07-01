package biblioteca.negocio;

import biblioteca.dao.daoCliente;
import biblioteca.entidad.Cliente;

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
	
	
	
	
}

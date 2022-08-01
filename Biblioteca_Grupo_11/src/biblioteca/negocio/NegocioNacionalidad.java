package biblioteca.negocio;

import java.util.List;

import biblioteca.dao.daoNacionalidad;
import biblioteca.entidad.Nacionalidad;


public class NegocioNacionalidad {

	daoNacionalidad dnac = new daoNacionalidad();
	
	public List<Nacionalidad> ObtenerNacionalidades(){
		
		try {
			
			return dnac.ListarNacionalidades();
		}
		catch(Exception e) {
			
			System.out.println("Error: " + e.toString());
			
			return null;
		}
}
}

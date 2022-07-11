package biblioteca.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.entidad.Cliente;
import biblioteca.entidad.Nacionalidad;
import biblioteca.negocio.NegocioCliente;

@Controller
public class ControladorCliente {

	NegocioCliente nc = new NegocioCliente();
	
	/* ********************* REDIRECCIONES CLIENTE *********************** */
	 
	 @RequestMapping("Redireccionar_ClienteAlta.html")
		public ModelAndView eventoRedireccionarClienteAlta()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("AltaCliente");
			return MV;
		}
	 
	 
	 @RequestMapping("Redireccionar_EdicionCliente.html")
		public ModelAndView eventoRedireccionarEdicionCliente()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("AltaCliente");
			return MV;
		}
	 
	 
    @RequestMapping("GuardarCliente.html")
	public ModelAndView eventoGuardarCliente(String txtNombre,String txtApellido, String txtDni,String date4 , String txtDireccion,String txtNacionalidad, String txtLocalidad, String txtMail, String txtTelefono )
	{
		try {
				
				Cliente cl = new Cliente();

				SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy");

				Nacionalidad nacionalidad = new Nacionalidad();
		    	nacionalidad.setDescripcion(txtNacionalidad);
		    	
				cl.setNombres(txtNombre.toString());
				cl.setApellidos(txtApellido.toString());
				cl.setDni(Integer.parseInt(txtDni));
				cl.setFecha_nacimiento(null);
				cl.setDireccion(txtDireccion);
				cl.setNacionalidad(nacionalidad); 
				cl.setLocalidad(txtLocalidad);
				cl.setEmail(txtMail);
				cl.setTelefono(txtTelefono);

				String NameCliente= txtNombre+" "+txtApellido;
				
				int i  = nc.AltaNuevoCliente(cl); 
				
				String Mensaje="Se agrego el nuevo cliente ";
				
				if(i<0) {
				  Mensaje = "Error! No pudo agregarse el nuevo cliente ";	
				}
				
				ModelAndView MV = new ModelAndView();
				MV.addObject(Mensaje, NameCliente);
				MV.setViewName("ListaClientes");
				return MV;
				
		}catch(Exception ex) {
				
			    System.out.println("Error: "+ ex.toString());
			    return null;
		}
	    	
	}
	 
}

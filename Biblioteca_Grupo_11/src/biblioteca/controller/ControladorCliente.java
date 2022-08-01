package biblioteca.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.entidad.Cliente;
import biblioteca.entidad.Nacionalidad;
import biblioteca.negocio.NegocioCliente;
import biblioteca.negocio.NegocioNacionalidad;

@Controller
public class ControladorCliente {

	NegocioCliente nc = new NegocioCliente();
	NegocioNacionalidad nNac = new NegocioNacionalidad();
	
	/* ********************* REDIRECCIONES CLIENTE *********************** */
	 
	 @RequestMapping("Redireccionar_ClienteAlta.html")
		public ModelAndView eventoRedireccionarClienteAlta()
		{			
			ModelAndView MV = new ModelAndView();
			MV.addObject("listaNacionalidades", nNac.ObtenerNacionalidades());
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

				//FORMATEAR FECHA PAR LA CARGA		
				date4 += "T00:00";
				SimpleDateFormat sd =  new SimpleDateFormat("yyyy-MM-dd");	
				java.util.Date d = sd.parse(date4); 				
				SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
				String str_f_nac = outputDateFormat.format(d);
				java.util.Date f_nac = sd.parse(str_f_nac); 
				

				Nacionalidad nacionalidad = new Nacionalidad();
		    	nacionalidad.setDescripcion(txtNacionalidad);
		    	
				cl.setNombres(txtNombre.toString());
				cl.setApellidos(txtApellido.toString());
				cl.setDni(Integer.parseInt(txtDni));
				
				cl.setFecha_nacimiento(f_nac);
				
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

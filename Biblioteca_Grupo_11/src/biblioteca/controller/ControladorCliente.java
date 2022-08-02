package biblioteca.controller;


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
			MV.addObject("ListaNacionalidades",nc.ListaNacionalidades());
			MV.addObject("ListarLocalidadaes",nc.ListaLocalidades());
			MV.setViewName("AltaCliente");
			return MV;
		}
	 
	 
	 @RequestMapping("Redireccionar_EdicionCliente.html")
	public ModelAndView eventoRedireccionarEdicionCliente(String IdCliente)
	{
		 try {
				ModelAndView MV = new ModelAndView();
				System.out.println("Recibí el ID: "+ IdCliente);
				Cliente cli = nc.ObtenerClientePorID(IdCliente);
				MV.addObject("ListaNacionalidades",nc.ListaNacionalidades());
				MV.addObject("DatosCliente", cli);		
				int IdNacionalidad = cli.getNacionalidad().getId();
				MV.addObject("IdNacionalidad",Integer.toString(IdNacionalidad));
				System.out.println("La nacionalidad es "+ IdNacionalidad);
				MV.addObject("ListarLocalidadaes",nc.ListaLocalidades());

				MV.setViewName("AltaCliente");
				return MV;
		 }catch(Exception ex) {
			 return null;
		 }

	}
	 
	 
    @RequestMapping("GuardarCliente.html")
	public ModelAndView eventoGuardarCliente(String IdCliente,String txtNombre,String txtApellido,String txtFecha,String txtDni , String txtDireccion,String txtNacionalidad, String txtLocalidad, String txtMail, String txtTelefono )
	{
		try {
			    
				String Mensaje;

				String dato = "Ok";// nc.ValidarDatos(txtFecha.toString(), txtDni.toString(),txtMail.toString(),txtTelefono.toString());
				
				if(dato!="Ok") {
					Mensaje="Error! "+ dato;
					System.out.println(Mensaje);
					return null;
				}
				Cliente cl = new Cliente();
	
				System.out.println("Recibí el id: "+IdCliente);
				System.out.println("Nacionalidad : "+txtNacionalidad);
				Nacionalidad nacionalidad = new Nacionalidad();

				cl.setNombres(txtNombre.toString());
				cl.setApellidos(txtApellido.toString());
				cl.setDni(Integer.parseInt(txtDni));
				cl.setFecha_nacimiento(java.sql.Date.valueOf(txtFecha.toString()));
				cl.setDireccion(txtDireccion);
		    	
				String NombreNacionalidad = nc.BuscarNacionalidad(txtNacionalidad);
				nacionalidad.setId(Integer.parseInt(txtNacionalidad));
				nacionalidad.setDescripcion(NombreNacionalidad);
				
				cl.setNacionalidad(nacionalidad);
				
				cl.setLocalidad(txtLocalidad);
				cl.setEmail(txtMail);
				//Solo números
				cl.setTelefono(txtTelefono);
				
				
				String NameCliente= txtNombre+" "+txtApellido;
				int i = 0;
				if(IdCliente!="") {
					
					  cl.setId(Integer.parseInt(IdCliente));
					  i  = nc.ModificarCliente(cl); 
					
					  Mensaje="Se actualizaron los datos del cliente ";
					
					if(i<0) {
					  Mensaje = "Error! No pudo guardar los datos del cliente ";	
					}
					
				}else {
					 i  = nc.AltaNuevoCliente(cl); 
					
					 Mensaje="Se agrego el nuevo cliente ";
					
					if(i<0) {
					  Mensaje = "Error! No pudo agregarse el nuevo cliente ";	
					}				
				}
				

				Mensaje = Mensaje + NameCliente;
				System.out.println(Mensaje);
				ModelAndView MV = new ModelAndView();
				MV.addObject("ListarClientes", nc.ListarClientes());
				MV.setViewName("ListaClientes");
				return MV;
				
		}catch(Exception ex) {
				
			    System.out.println("Error: "+ ex.toString());
			    return null;
		}
	    	
	}
	@RequestMapping("EliminarCliente.html")
	public ModelAndView EliminarCliente(String EliminarCliente) {
		try {
			
			ModelAndView MV = new ModelAndView();
			int i = nc.BorrarCliente(EliminarCliente);
			String Mensaje="Se elimino al cliente ";// + nombrecompletoCliente();
			if(i<1) {
				Mensaje="No se pudo eliminar al cliente";
			}
			MV.addObject("Mensaje", Mensaje);
			MV.addObject("ListarClientes", nc.ListarClientes());
			MV.setViewName("ListaClientes");
			return MV;
		}catch(Exception ex) {
			return null;
		}
	}

 }
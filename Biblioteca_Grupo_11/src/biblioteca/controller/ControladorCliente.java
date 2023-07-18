package biblioteca.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biblioteca.entidad.Clientes;
import biblioteca.entidad.Nacionalidad;
import biblioteca.negocio.NegocioBiblioteca;
import biblioteca.negocio.NegocioCliente;
import resources.Config;

@Controller
public class ControladorCliente {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	NegocioCliente nc = (NegocioCliente) appContext.getBean("NegocioClienteBean");
	
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
				Clientes cli = nc.ObtenerClientePorID(IdCliente);
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
				String Mensaje="";
			/*	String dato =  nc.ValidarDatos(txtFecha.toString(), txtDni.toString(),txtMail.toString(),txtTelefono.toString());
				
				if(dato!="Ok") {
					Mensaje="Error! "+ dato;
					System.out.println(Mensaje);
					return null;
				}*/
				
				Clientes cl = (Clientes) appContext.getBean("ClienteBean");
				
				System.out.println("Se creo el CLIENTE usando Bean desde el XML");
				System.out.println("Recibí el id: "+IdCliente);
				System.out.println("Nacionalidad : "+txtNacionalidad);
				
				Nacionalidad nacionalidad = (Nacionalidad) appContext.getBean("NacionalidadBean");
				
				String NameCliente= txtNombre+" "+txtApellido;

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
				cl.setTelefono(txtTelefono);
				
				int i = 0;
				ModelAndView MV = new ModelAndView();

				if(IdCliente!="") { //Si es un cliente que se edita
					
					  cl.setId(Integer.parseInt(IdCliente));
					  i  = nc.ModificarCliente(cl); 
										
					  if(i<0) {					
						  Mensaje = "Error! No pudo guardar los datos del cliente ";
						  MV.addObject("Edito", 0);

					  }else if(i==2) {
						  Mensaje = "Error! Ya existe un cliente con el DNI ingresado, no se pudo editar al cliente ";
						  MV.addObject("Edito", 0);
					  }else {
						  Mensaje="Se actualizaron los datos del cliente ";
						  MV.addObject("Edito", 1);
					  }
					  	 
					  MV.addObject("accion", "editar");		
					  	  
				}else { // Si es nuevo cliente:
					
						if(nc.ValidarExistencia(txtDni) < 1) { //Corroboro que no existe el dni
						
							i  = nc.AltaNuevoCliente(cl); 
					
							Mensaje="Se agrego el nuevo cliente: ";
					
					 	if(i<0) {
					 		Mensaje = "Error! No pudo agregarse el cliente ";	
							MV.addObject("Agrego", 0);

					 	}else {
							MV.addObject("Agrego", 1);

					 	}
					
						}else { //Caso que ya exista el dni ingresado
							Mensaje="Error! El cliente con este dni ya existe.";
							NameCliente = " DNI :"+txtDni;
							MV.addObject("Agrego", 0);

					}
					
					MV.addObject("accion", "agregar");		
					
				}// End del else del primer if
				
			
 				Mensaje = Mensaje + NameCliente;
				System.out.println(Mensaje);
				MV.addObject("mostrarMensaje", true);
				MV.addObject("Mensaje", Mensaje);
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
		    String Mensaje = "";
	    if(nc.ClienteTienePrestamos(EliminarCliente) != 0) {
	    	
	    	Mensaje="No se pudo eliminar al cliente, este posee prestamos.";
			MV.addObject("Elimino", 0);

		}else {
			
			int i = nc.BorrarCliente(EliminarCliente);
		    Mensaje="Se elimino al cliente ";// + nombrecompletoCliente();

			
			if(i<1) {
				
				Mensaje="No se pudo eliminar al cliente.";
				MV.addObject("Elimino", 0);

			}else {
				MV.addObject("Elimino", 1);
			}

		}
			MV.addObject("mostrarMensaje", true);
			MV.addObject("Mensaje", Mensaje);
			MV.addObject("accion", "eliminar");
			System.out.println(Mensaje);
			MV.addObject("ListarClientes", nc.ListarClientes());
			MV.setViewName("ListaClientes");
			return MV;
		}catch(Exception ex) {
			return null;
		}
	}

 }




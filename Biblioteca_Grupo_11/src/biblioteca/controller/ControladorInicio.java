package biblioteca.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.dao.daoCliente;
import biblioteca.entidad.Cliente;
import biblioteca.entidad.Nacionalidad;

@Controller
public class ControladorInicio {

	
	@RequestMapping("Redireccionar_index.html")
	public ModelAndView eventoRedireccionarPag1()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping("Redireccionar_Login.html")
	public ModelAndView eventoRedireccionarLogin()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");
		return MV;
	}	

	 
	 @RequestMapping("Redireccionar_PostLogin.html")
	public ModelAndView eventoRedireccionarPostLogin(/*String txtUsuario,Integer txtContrasenia*/)
	{			
		ModelAndView MV = new ModelAndView();
	//	MV.addObject("usuario", txtUsuario);
	//	MV.addObject("contrasenia", txtContrasenia);
		MV.setViewName("PostLogin");
		return MV;
	} 
	
	 /* ********************* REDIRECCIONES POST LOGIN *********************** */
	 
	 @RequestMapping("Redireccionar_ListaClientes.html")
	public ModelAndView eventoRedireccionarListaClientes(/*String txtUsuario,Integer txtContrasenia*/)
	{			
		ModelAndView MV = new ModelAndView();
	//	MV.addObject("usuario", txtUsuario);
	//	MV.addObject("contrasenia", txtContrasenia);
	//	MV.setViewName("ListaClientes");
		MV.setViewName("ListaClientes");
		return MV;
	}
	 
	 @RequestMapping("Redireccionar_ListaBiblioteca.html")
	public ModelAndView eventoRedireccionarListaBiblioteca(/*String txtUsuario,Integer txtContrasenia*/)
	{			
		ModelAndView MV = new ModelAndView();
	//	MV.addObject("usuario", txtUsuario);
	//	MV.addObject("contrasenia", txtContrasenia);
		MV.setViewName("ListaBiblioteca");
		return MV;
	}
	 
	 @RequestMapping("Redireccionar_ListaPrestamos.html")
	public ModelAndView eventoRedireccionarListaPrestamos(/*String txtUsuario,Integer txtContrasenia*/)
	{			
		ModelAndView MV = new ModelAndView();
	//	MV.addObject("usuario", txtUsuario);
	//	MV.addObject("contrasenia", txtContrasenia);
		MV.setViewName("ListaPrestamos");
		return MV;
	}
	 
	 
	 /* ********************* REDIRECCIONES CLIENTE *********************** */
	 
	 @RequestMapping("Redireccionar_ClienteAlta.html")
		public ModelAndView eventoRedireccionarClienteAlta()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("ClienteAlta");
			return MV;
		}
	 
	 @RequestMapping("Redireccionar_EdicionCliente.html")
		public ModelAndView eventoRedireccionarEdicionCliente()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("ClienteAlta");
			return MV;
		}
	 
	     @RequestMapping("GuardarCliente.html")
		public ModelAndView eventoGuardarCliente(String txtNombre,String txtApellido, String txtDni,String date4 , String txtDireccion,String txtNacionalidad, String txtLocalidad, String txtMail, String txtTelefono )
		{
			try {
				Cliente cl = new Cliente();
				daoCliente dc = new daoCliente();

				SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy");
				//Date fecha = sd.parse(date4);
				//cl.setFecha_nacimiento(fecha);
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
				
				dc.CargarCliente(cl);

				
				ModelAndView MV = new ModelAndView();
				MV.addObject("Correcto", NameCliente);
			//	MV.setViewName("ListaClientes");
				MV.setViewName("ListaClientes");
				return MV;
			}catch(Exception ex) {
				
				System.out.println("Error: "+ ex.toString());
				return null;
			}
	    	
		}
	 
	 /* ********************* REDIRECCIONES BIBLIOTECA *********************** */
	 
	 @RequestMapping("Redireccionar_BibliotecaAlta.html")
		public ModelAndView eventoRedireccionarBicliotecaAlta()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("BibliotecaAlta");
			return MV;
		}
	 
	 @RequestMapping("Redireccionar_EdicionBiblioteca.html")
		public ModelAndView eventoRedireccionarEdicionBiblioteca()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("BibliotecaAlta");
			return MV;
		}
	 
	 /* ********************* REDIRECCIONES PERSTAMOS *********************** */
	 
	 @RequestMapping("Redireccionar_PrestamosAlta.html")
		public ModelAndView eventoRedireccionarPrestamosAlta()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("PrestamoAlta");
			return MV;
		}
	 
	 @RequestMapping("Redireccionar_EdicionPrestamos.html")
		public ModelAndView eventoRedireccionarEdicionPrestamo()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("PrestamoAlta");
			return MV;
		}
}

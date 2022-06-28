package biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

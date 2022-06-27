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
	
	 @RequestMapping("Redireccionar_ClienteAlta.html")
	public ModelAndView eventoRedireccionarClienteAlta(/*String txtUsuario,Integer txtContrasenia*/)
	{			
		ModelAndView MV = new ModelAndView();
	//	MV.addObject("usuario", txtUsuario);
	//	MV.addObject("contrasenia", txtContrasenia);
		MV.setViewName("ClienteAlta");
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
}

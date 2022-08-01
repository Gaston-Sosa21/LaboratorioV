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
import biblioteca.negocio.NegocioBiblioteca;

@Controller
public class ControladorInicio {

	NegocioBiblioteca bneg = new NegocioBiblioteca();
	
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
	
	 
	 @RequestMapping("ListaBiblioteca.html")
		public ModelAndView eventoListarBibliotecas2()
		{
			try {
					
					ModelAndView MV = new ModelAndView();
					MV.addObject("listaBibliotecas", bneg.ObtenerBibliotecas());
					MV.setViewName("ListaBiblioteca");
					return MV;
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
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

package biblioteca.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.dao.daoCliente;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Nacionalidad;
import biblioteca.negocio.NegocioBiblioteca;
import biblioteca.negocio.NegocioCliente;
import biblioteca.negocio.NegocioPrestamos;
import biblioteca.negocio.NegocioUsuario;
import resources.ConfigBiblioteca;
import resources.ConfigPrestamo;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ControladorInicio {
	
	ApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigBiblioteca.class, ConfigPrestamo.class);
	
	NegocioBiblioteca bneg = (NegocioBiblioteca)appContext.getBean("nuevoNegocioBiblioteca");
	NegocioUsuario busu = new NegocioUsuario();
	NegocioPrestamos pneg = (NegocioPrestamos)appContext.getBean("nuevoNegocioPrestamos");
	
	/*@RequestMapping("Redireccionar_index.html")
	public ModelAndView eventoRedireccionarPag1()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("index");
		return MV;
	}*/
	
	@RequestMapping("Redireccionar_Login.html")
	public ModelAndView eventoRedireccionarLogin()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");
		return MV;
	}	

	/*ModelAndView MV = new ModelAndView();
	MV.addObject("usuario", txtUsuario);
	MV.addObject("contrasenia", txtContrasenia);
		MV.setViewName("PostLogin");
		return MV;*/
	@RequestMapping("Home.html")
	public ModelAndView eventoRedireccionarPrincipal()
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("PostLogin");
		return MV;
	}
	
	@RequestMapping("Redireccionar_PostLogin.html")
	public ModelAndView eventoRedireccionarPostLogin(HttpServletRequest request,String txtUsuario,String txtClave)
	{	
		 String pagina = "";
		 String Logeo = "";
		 try {	
			 if(busu.AltaUsuario(txtUsuario, txtClave)) {
				 pagina = "PostLogin";
				 request.getSession().setAttribute("nombre",txtUsuario);
			 }
			 else {
				 pagina = "Login";
				 Logeo = "no";
			 }
			 ModelAndView MV = new ModelAndView();
				MV.addObject("usuario", txtUsuario);
				MV.addObject("mostrarMensaje", true);
				MV.addObject("Logeo", Logeo);
				MV.addObject("contrasenia", txtClave);
				MV.setViewName(pagina);
				return MV;
		 }
		 catch(Exception ex) {
				
			    System.out.println("Error: "+ ex.toString());
			    return null;
		}	
		
	}
	
	 /* ********************* REDIRECCIONES POST LOGIN *********************** */
	 
	 @RequestMapping("Redireccionar_ListaClientes.html")
	public ModelAndView eventoRedireccionarListaClientes(/*String txtUsuario,Integer txtContrasenia*/)
	{	NegocioCliente nc = new NegocioCliente();		
		ModelAndView MV = new ModelAndView();
	//	MV.addObject("usuario", txtUsuario);
	//	MV.addObject("contrasenia", txtContrasenia);
	//	MV.setViewName("ListaClientes");
		MV.addObject("ListarClientes", nc.ListarClientes());
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
		MV.addObject("listaPrestamos", pneg.ObtenerPrestamos());
		MV.setViewName("ListaPrestamos");
		return MV;
	}
	 
	 

}

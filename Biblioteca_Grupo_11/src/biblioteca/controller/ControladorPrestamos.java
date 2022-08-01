package biblioteca.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.negocio.NegocioBiblioteca;
import biblioteca.negocio.NegocioCliente;
import biblioteca.negocio.NegocioPrestamos;

@Controller
public class ControladorPrestamos {

	NegocioPrestamos pneg = new NegocioPrestamos();
	NegocioBiblioteca bneg = new NegocioBiblioteca();
	NegocioCliente cneg = new NegocioCliente();
	 
	 @RequestMapping("Redireccionar_PrestamosAlta.html")
		public ModelAndView eventoRedireccionarPrestamosAlta()
		{	
		 	
		 	ModelAndView MV = new ModelAndView();
		 
			MV.addObject("listaLibros", bneg.ObtenerLibros());
			MV.addObject("listaClientes", cneg.ObtenerClientes());
			MV.addObject("date", LocalDate.now().toString());
			
			MV.setViewName("AltaPrestamo");
			return MV;
		}
	 
	 @RequestMapping("Redireccionar_EdicionPrestamos.html")
		public ModelAndView eventoRedireccionarEdicionPrestamo()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("AltaPrestamo");
			return MV;
		}
	 
	 
}

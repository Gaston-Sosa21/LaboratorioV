package biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.negocio.NegocioBiblioteca;

@Controller
public class ControladorBiblioteca {

	NegocioBiblioteca bneg = new NegocioBiblioteca();
	
	 @RequestMapping("Redireccionar_BibliotecaAlta.html")
		public ModelAndView eventoRedireccionarBicliotecaAlta()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("AltaBiblioteca");
			return MV;
		}
	 
	 @RequestMapping("Redireccionar_EdicionBiblioteca.html")
		public ModelAndView eventoRedireccionarEdicionBiblioteca()
		{			
			ModelAndView MV = new ModelAndView();
			MV.setViewName("BibliotecaAlta");
			return MV;
		}
	 
}

package biblioteca.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.entidad.Cliente;
import biblioteca.entidad.Nacionalidad;
import biblioteca.negocio.NegocioBiblioteca;

@Controller
public class ControladorBiblioteca {

	NegocioBiblioteca bneg = new NegocioBiblioteca();
	
	 @RequestMapping("Redireccionar_BibliotecaAlta.html")
		public ModelAndView eventoRedireccionarBibliotecaAlta()
		{			
			ModelAndView MV = new ModelAndView();
			MV.addObject("listaLibros", bneg.ObtenerLibros());
			MV.addObject("date", LocalDate.now().toString());
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
	 
	 @RequestMapping("AltaBiblioteca.html")
		public ModelAndView eventoGuardarBiblioteca(String ddlLibro, String ddlEstado)
		{
			try {
					
					int filas  = bneg.AltaBiblioteca(ddlLibro, LocalDate.now().toString(), Integer.parseInt(ddlEstado)); 
					
					String Mensaje="Se agrego una nueva biblioteca del libro " + ddlLibro;
					
					if(filas<0) {
					  Mensaje = "Error! No pudo agregarse la nueva biblioteca ";	
					}
					
					ModelAndView MV = new ModelAndView();
					MV.addObject(Mensaje, ddlLibro);
					MV.setViewName("ListaBiblioteca");
					MV.addObject("listaBibliotecas", bneg.ObtenerBibliotecas());
					MV.setViewName("ListaBiblioteca");
					return MV;
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
		}

}

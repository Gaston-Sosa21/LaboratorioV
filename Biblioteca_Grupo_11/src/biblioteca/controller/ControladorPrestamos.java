package biblioteca.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.entidad.Libro;
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
			MV.addObject("listaClientes", cneg.ListarClientes());
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
	 
	 @RequestMapping("AltaPrestamo.html")
		public ModelAndView eventoGuardarPrestamo(/*String ddlLibro, String ddlEstado, String txtVolver*/)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String agrego= "no";
				
					/*
					//aca agrego el prestamo
					 
					if(ddlLibro != null && Integer.parseInt(ddlEstado) != -1) {
						
																		
						if(bneg.AltaBiblioteca(ddlLibro, LocalDate.now().toString(), Integer.parseInt(ddlEstado))) {
							
							Libro lib = bneg.ObtenerLibroPorId(ddlLibro);
							MV.addObject("Libro", lib.getTitulo());
							agrego = "si";
							
						}
					}	
					*/
					
					MV.setViewName("ListaPrestamos");
					MV.addObject("mostrarMensaje", true);
					MV.addObject("accion", "agregar");
					//MV.addObject("Agrego", agrego);
					//MV.addObject("listaBibliotecas", bneg.ObtenerBibliotecas());
					return MV;
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
		}


}

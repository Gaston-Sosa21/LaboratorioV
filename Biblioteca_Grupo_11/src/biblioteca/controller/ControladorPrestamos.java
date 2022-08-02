package biblioteca.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Cliente;
import biblioteca.entidad.Libro;
import biblioteca.entidad.Prestamo;
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
	 
	 /*
	 @RequestMapping("Redireccionar_ListaClientes.html")
		public ModelAndView eventoGuardarPrestamo(String ddlLibro, String cte, String txtFecha, String txtCantidad)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String agrego= "no";
				
					
					if(ddlLibro != null && cte != null && txtFecha != null && txtCantidad != null ) {						
						//Integer.parseInt(ddlEstado) != -1	
						
						if(pneg.AltaPrestamo(Biblioteca biblioteca, Date fecha_prestamo, Integer cantidad_dias, Cliente cliente)) {		
							agrego = "si";							
						}
						
					}
					
					MV.setViewName("ListaBiblioteca");
					MV.addObject("mostrarMensaje", true);
					MV.addObject("accion", "agregar");
					MV.addObject("Agrego", agrego);
					MV.addObject("listaPrestamos", pneg.ObtenerPrestamos());
					MV.setViewName("ListaBiblioteca");
					return MV;
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
		}
	 */
	 
}

package biblioteca.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
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
							
		   MV.addObject("listaLibros", pneg.ObtenerLibrosDeBiblioteca());
			MV.addObject("listaClientes", cneg.ListarClientes());
			MV.addObject("date", LocalDate.now().toString());

			MV.setViewName("AltaPrestamo");
			return MV;
		}
	 
	 @RequestMapping("Redireccionar_EditarPrestamo.html")
		public ModelAndView eventoRedireccionarEdicionPrestamo(String txtEditar)
		{			
			ModelAndView MV = new ModelAndView();
			Prestamo p = pneg.ObtenerPrestamoPorId(txtEditar);
			MV.addObject("Prestamo", p);
			MV.addObject("Cliente", p.getCliente());
			MV.addObject("CantidadDias", p.getCantidad_dias());
			MV.addObject("FechaAlta", p.getFecha_prestamo());
			MV.addObject("Libro", bneg.ObtenerBibliotecaPorId(String.valueOf(p.getBiblioteca().getId()))[0]);
			MV.setViewName("EditarPrestamo");
			return MV;
		}
	 
	 @RequestMapping("AltaPrestamo.html")
		public ModelAndView eventoGuardarPrestamo(String ddlLibro, String txtFecha, String txtCantidad, String cliente)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String agrego= "no";				
			
					//List<Object[]> list_bteca = bneg.ObtenerBibliotecas();
					Biblioteca biblio = bneg.ObtenerBibliotecaPorISBN(ddlLibro);
					Clientes cte = cneg.ObtenerClientePorID(cliente);
					 
					if(ddlLibro != null ) {										
								
						if (pneg.AltaPrestamo(biblio,  LocalDate.now().toString(), Integer.parseInt(txtCantidad), cte)) {							
							agrego = "si";
							//actualizar estado de biblioteca
							bneg.ActualizarEstadoBiblioteca(String.valueOf(bneg.ObtenerBibliotecaPorISBN(ddlLibro).getId()), 1);							
						}
					}	
														
					MV.addObject("mostrarMensaje", true);
					MV.addObject("accion", "agregar");
					MV.addObject("Agrego", agrego);
					MV.addObject("listaPrestamos", pneg.ObtenerPrestamos());
					MV.setViewName("ListaPrestamos");
					return MV;
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}		    	
		}
	 
	 @RequestMapping("EditarPrestamo.html")
		public ModelAndView eventoEditarPrestamo(String IdPrestamo, int txtCantidadDias)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String edito= "no";
				
					if(IdPrestamo != null ) {
						
						if(pneg.EditarPrestamo(IdPrestamo,txtCantidadDias)) {	
							MV.addObject("Prestamo", IdPrestamo);
							edito = "si";							
						}
					}		
					
					
					MV.addObject("mostrarMensaje", true);
					MV.addObject("accion", "editar");
					MV.addObject("Edito", edito);
					MV.addObject("listaPrestamos", pneg.ObtenerPrestamos());
					MV.setViewName("ListaPrestamos");
					return MV;
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
		}
	 
	 @RequestMapping("EliminarPrestamo.html")
		public ModelAndView eventoEliminarPrestamo(String txtEliminar)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String elimino= "no";
						
					//if(confirmarEliminar == "si") {
					   
					   //actualizamos el estado de la biblioteca
						bneg.ActualizarEstadoBiblioteca(String.valueOf(pneg.ObtenerPrestamoPorId(txtEliminar).getBiblioteca().getId()), 0);
						if(pneg.EliminarPrestamo(txtEliminar)) {
							MV.addObject("Prestamo", txtEliminar);
							elimino = "si";	
														
						}					
						
					//}

					MV.addObject("mostrarMensaje", true);
					MV.addObject("accion", "eliminar");
					MV.addObject("Elimino", elimino);
					MV.addObject("listaPrestamos", pneg.ObtenerPrestamos());
					MV.setViewName("ListaPrestamos");
					return MV;
					
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
		}


}

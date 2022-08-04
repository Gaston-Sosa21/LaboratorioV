package biblioteca.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.negocio.NegocioBiblioteca;
import biblioteca.negocio.NegocioCliente;
import biblioteca.negocio.NegocioPrestamos;
import javassist.bytecode.Descriptor.Iterator;

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
		public ModelAndView eventoRedireccionarEdicionPrestamo(int IdPrestamo)
		{			
			ModelAndView MV = new ModelAndView();
			MV.addObject("prestamo", pneg.ObtenerPrestamoPorId(IdPrestamo));
			MV.addObject("listaLibros", bneg.ObtenerLibros());
			MV.setViewName("EditarPrestamo");
			return MV;
		}
	 
	 @RequestMapping("AltaPrestamo.html")
		public ModelAndView eventoGuardarPrestamo(String ddlLibro, String txtFecha, String txtCantidad, String cliente)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String agrego= "no";				
			
					List<Object[]> list_bteca = bneg.ObtenerBibliotecas();
					Biblioteca biblio = bneg.ObtenerBibliotecaPorISBN(ddlLibro);
					Clientes cte = cneg.ObtenerClientePorID(cliente);
					 
					if(ddlLibro != null ) {		
						
						/*
						//FORMATEAR FECHA PAR LA CARGA		
						txtFecha += "T00:00";
						SimpleDateFormat sd =  new SimpleDateFormat("yyyy-MM-dd");	
						java.util.Date d = sd.parse(txtFecha); 				
						SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
						String str_f_nac = outputDateFormat.format(d);
						java.util.Date f_alta = sd.parse(str_f_nac); 
						*/
						
										
								
						if (pneg.AltaPrestamo(biblio,  new Date(10,10,2022), Integer.parseInt(txtCantidad), cte)) {							
							agrego = "si";
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
		public ModelAndView eventoEditarPrestamo(/*String ddlLibro, String ddlEstado, String txtVolver, String txtFecha, String txtId*/)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String edito= "no";
				/*
					if(ddlLibro != null && Integer.parseInt(ddlEstado) != -1) {		
						if(bneg.EditarBiblioteca(txtId, ddlLibro, txtFecha, Integer.parseInt(ddlEstado))) {							
							Object[] obj = bneg.ObtenerBibliotecaPorId(txtId);
							Biblioteca bib = (Biblioteca)obj[1];
							MV.addObject("Biblioteca", bib.getId());
							edito = "si";							
						}
					}		
					*/
					
					MV.addObject("mostrarMensaje", true);
					MV.addObject("accion", "editar");
					//MV.addObject("Edito", edito);
					MV.addObject("listaPrestamos", pneg.ObtenerPrestamos());
					MV.setViewName("ListaPrestamos");
					return MV;
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
		}
	 
	 @RequestMapping("EliminarPrestamo.html")
		public ModelAndView eventoEliminarPrestamo(int IdPrestamo)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String elimino= "no";
						
					//if(confirmarEliminar == "si") {
						
						if(pneg.EliminarPrestamo(IdPrestamo)) {
							MV.addObject("Prestamo", IdPrestamo);
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

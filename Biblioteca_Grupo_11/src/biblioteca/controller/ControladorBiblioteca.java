package biblioteca.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import biblioteca.entidad.Biblioteca;
import biblioteca.entidad.Clientes;
import biblioteca.entidad.Libro;
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
	 
	 @RequestMapping("Redireccionar_EditarBiblioteca.html")
		public ModelAndView eventoRedireccionarEdicionBiblioteca(String txtEditar)
		{			
			ModelAndView MV = new ModelAndView();
			
			MV.addObject("biblioteca", bneg.ObtenerBibliotecaPorId(txtEditar));
			MV.addObject("listaLibros", bneg.ObtenerLibros());
			MV.setViewName("EditarBiblioteca");
			return MV;
		}
	 
	 @RequestMapping("AltaBiblioteca.html")
		public ModelAndView eventoGuardarBiblioteca(String ddlLibro)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String agrego= "no";
				
					if(ddlLibro != null) {
						
																		
						if(bneg.AltaBiblioteca(ddlLibro, LocalDate.now().toString(), 0)) {
							
							Libro lib = bneg.ObtenerLibroPorId(ddlLibro);
							MV.addObject("Libro", lib.getTitulo());
							agrego = "si";
							
						}
					}					
					
					MV.setViewName("ListaBiblioteca");
					MV.addObject("mostrarMensaje", true);
					MV.addObject("accion", "agregar");
					MV.addObject("Agrego", agrego);
					MV.addObject("listaBibliotecas", bneg.ObtenerBibliotecas());
					MV.setViewName("ListaBiblioteca");
					return MV;
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
		}
	 
	 @RequestMapping("EditarBiblioteca.html")
		public ModelAndView eventoEditarBiblioteca(String ddlLibro, String txtFecha, String txtId)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String edito= "no";
				
					if(ddlLibro != null) {
						
																		
						if(bneg.EditarBiblioteca(txtId, ddlLibro, txtFecha)) {
							
							Object[] obj = bneg.ObtenerBibliotecaPorId(txtId);
							Biblioteca bib = (Biblioteca)obj[1];
							MV.addObject("Biblioteca", bib.getId());
							edito = "si";
							
						}
					}
					
					MV.setViewName("ListaBiblioteca");
					MV.addObject("mostrarMensaje", true);
					MV.addObject("accion", "editar");
					MV.addObject("Edito", edito);
					MV.addObject("listaBibliotecas", bneg.ObtenerBibliotecas());
					MV.setViewName("ListaBiblioteca");
					return MV;
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
		}
	 
	 @RequestMapping("EliminarBiblioteca.html")
		public ModelAndView eventoEliminarBiblioteca(String txtEliminar)
		{
			try {
					ModelAndView MV = new ModelAndView();
					String elimino= "no";
						
					//if(confirmarEliminar == "si") {
						
						if(bneg.EliminarBiblioteca(txtEliminar)) {

							MV.addObject("Biblioteca", txtEliminar);
							elimino = "si";							
						}					
						
					//}
				
					MV.setViewName("ListaBiblioteca");
					MV.addObject("mostrarMensaje", true);
					MV.addObject("accion", "eliminar");
					MV.addObject("Elimino", elimino);
					MV.addObject("listaBibliotecas", bneg.ObtenerBibliotecas());
					MV.setViewName("ListaBiblioteca");
					return MV;					
					
			}catch(Exception ex) {
					
				    System.out.println("Error: "+ ex.toString());
				    return null;
			}
		    	
		}
}

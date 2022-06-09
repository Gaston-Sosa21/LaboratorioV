package Dao;

import java.util.List;

import org.hibernate.Session;

import Ejercicio1.Tarjeta;
import Ejercicio1.Titular;
import Ejercicio4.Equipo;
import Ejercicio4.Torneo;
import Ejercicio2.Articulos;
import Ejercicio2.Tienda;
import Ejercicio3.Cliente;
import Ejercicio3.Pedido;




public class daoHibernate {

	public static void leerEjercicio1()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
        List<Object[]> listaObject= (List<Object[]>) session.createQuery("FROM Tarjeta tar inner join tar.titular titu where titu.idTitular = 1").list();
       
        
        
        System.out.println("---------Ejercicio 1---------");
        System.out.println();
        for (Object[] obj : listaObject) {
	        
        	Tarjeta tar = (Tarjeta) obj[0];
	        Titular titu = (Titular) obj[1];
	        System.out.println("INFORMACIÓN DE LA TARJETA:");
        	System.out.println("- Número de tarjeta: "+ tar.getNumero());
        	System.out.println("- Nombre y apellido titular: " + titu.getNombreYApellido());
        	System.out.println("- Código de seguridad: " + tar.getCodigoSeguridad());
        	System.out.println("- Fecha de vencimiento: "+ tar.getFechaVencimiento());
        	System.out.println();
        	System.out.println("INFORMACIÓN DEL TITULAR");
        	System.out.println("- DNI: "+ titu.getDNI());
        	System.out.println("- Dirección: "+ titu.getDireccion());
        	System.out.println("- Teléfono: "+ titu.getTelefono());
		}
    
        
        ch.cerrarSession();
	}
	
	public static void leerEjercicio4()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		
        List<Object[]> listaObject= (List<Object[]>) session.createQuery("FROM Torneo torneo INNER JOIN torneo.listaEquipos equipos WHERE torneo.id = 1").list();
      
        System.out.println("---------Ejercicio 4---------");
        System.out.println();
        Object[] objeto = listaObject.get(0);
        Torneo torneo =  (Torneo) objeto[0];
        
        System.out.println(torneo.toString());
    	System.out.println("   "+"Equipos:");

        for (Object[] obj : listaObject) {
	        Equipo equipo = (Equipo) obj[1];
        	System.out.println("   "+ equipo.toString());

		}
    
        ch.cerrarSession();
	}
	
			
	public static void leerEjercicio2()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();

        List<Object[]> listaObject= (List<Object[]>) session.createQuery("FROM Tienda til inner join til.ListaArticulos").list();

        
        System.out.println("-------------Ejercicio 2-------------");
        System.out.println();
    	boolean paso = true;

        for (Object[] comp : listaObject) {
        	
	        Tienda tie = (Tienda) comp[0];
        	Articulos ar = (Articulos) comp[1];

        	if(paso == true) {
            	System.out.println("EMPRESA: " + tie.getRAZONSOCIAL());
            	System.out.println("	CUIT: "+ tie.getCUIT());
            	System.out.println("	CONTACTO MAIL: "+tie.getMail());
            	System.out.println("	CONTACTO TEL: "+ tie.getTelefono());
            	
            	System.out.println();

            	System.out.println("	Lista de Articulos ");
            	paso=false;
        	}
        	System.out.println("-----------------------------");

        	System.out.println(" Codigo: "+  ar.getIdArticulo());
        	System.out.println(" Descripcion: " + ar.getDescripcion());
        	System.out.println(" Precio de Venta: "+ ar.getTotal());
        	System.out.println(" Fecha Ingreso: "+ ar.getFechaIngreso());
        }
     ch.cerrarSession();
	}

	public static void leerEjercicio3()
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		String query = "FROM Pedido pe inner join pe.cliente cli WHERE cli.id = 1 ";
	    List<Object[]> listaObject= (List<Object[]>) session.createQuery(query).list();
	    
	    
	    System.out.println("---------Ejercicio 3---------");
	    System.out.println();
	    
	    Object[] objeto = listaObject.get(0);
	    Cliente cliente =  (Cliente) objeto[1];
	    
	    System.out.println("INFORMACIÓN CLIENTE:");
		System.out.println("- Id Cliente: "+ cliente.getId());
		System.out.println("- Nombre y apellido: " + cliente.getNombre() + " " + cliente.getApellido());
		System.out.println("- Localidad: " + cliente.getLocalidad());
		System.out.println("- Direccion: "+ cliente.getDireccion());
		System.out.println("- Telefono: "+ cliente.getTelefono());
		System.out.println();
	    
	   
	    for (Object[] obj : listaObject) {
	        
	    	
	        Pedido pedido = (Pedido) obj[0];
	        
	    	System.out.println("INFORMACIÓN PEDIDO");
	    	System.out.println("- Id. Pedido: "+ pedido.getIdPedido());
	    	System.out.println("- Cantidad: "+ pedido.getCantidad());
	    	System.out.println("- Fecha pedido: "+ pedido.getFecha());
	    	System.out.println("- Detalle: "+ pedido.getDetalle());
	    	System.out.println();
		}
	
	    ch.cerrarSession();
	}
}

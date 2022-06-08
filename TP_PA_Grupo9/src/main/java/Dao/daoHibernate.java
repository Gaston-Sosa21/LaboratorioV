package Dao;

import java.util.List;

import org.hibernate.Session;

import Ejercicio1.Tarjeta;
import Ejercicio1.Titular;




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
}

package Ejercicio1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Dao.ConfigHibernate;
import Dao.daoHibernate;

/**
 * Hello world!
 *
 */
public class MainEjercicio1 
{
    public static void main( String[] args )
    {
    	ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
    	
    	session.beginTransaction();
    	
		Titular titular =  new Titular();
		titular.setDNI("42576103");
		titular.setNombreYApellido("Francisco Madoery");
		titular.setTelefono("1150266957");
		titular.setDireccion("Av 123");
		
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setNumero("1234567890");
		tarjeta.setTitular(titular);
		tarjeta.setFechaVencimiento(java.sql.Date.valueOf("2022-10-04"));
		tarjeta.setCodigoSeguridad("123");
		
		
		session.save(tarjeta);
		session.getTransaction().commit();
		
		ch.cerrarSession();
		
		daoHibernate.leerEjercicio1();
    }
}

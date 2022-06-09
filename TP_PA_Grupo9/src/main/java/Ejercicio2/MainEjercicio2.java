package Ejercicio2;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



import Dao.ConfigHibernate;
import Dao.daoHibernate;


public class MainEjercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
    	
    	session.beginTransaction();

    	///Articulos
    	Articulos arti2 = new Articulos();
    	arti2.setDescripcion("SSD 950Gb");	
    	arti2.setTotal(15600);
    	arti2.setFechaIngreso(java.sql.Date.valueOf("2022-05-02"));

    	Articulos arti3 = new Articulos();
    	arti3.setDescripcion("Ryzen 7 5700G");	
    	arti3.setTotal(52276);
    	arti3.setFechaIngreso(java.sql.Date.valueOf("2022-06-07"));
    
     	Articulos arti4 = new Articulos("Cooler Disipador",19010,java.sql.Date.valueOf("2022-06-06"));

    	ArrayList<Articulos> articul = new ArrayList<Articulos>();
    	articul.add(arti2);
    	articul.add(arti3);
    	articul.add(arti4);
    	
       	Tienda tiend = new Tienda();
       	tiend.setRAZONSOCIAL("AQUATECH");
    	tiend.setCUIT("30-42980654-0");
    	tiend.setMail("Andrede_Agustin@gmail.com");
    	tiend.setTelefono(1123068598);
    	tiend.setListaArticulos(articul);
    	
    	
    	//session.save(client);
    	//session.save(client2);
    	session.save(tiend);
    	session.getTransaction().commit();
		
		ch.cerrarSession();
    	
        daoHibernate.leerEjercicio2();
	}

}

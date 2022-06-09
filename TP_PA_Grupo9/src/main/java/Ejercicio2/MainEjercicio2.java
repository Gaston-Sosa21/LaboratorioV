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

    	
    	Compras Compra = new Compras();
    	Compra.setDescripcion("SSD 950Gb");	
    	Compra.setTotal(15600);
    	Compra.setFecha(java.sql.Date.valueOf("2022-05-02"));

    	Compras Compra2 = new Compras();
    	Compra2.setDescripcion("Ryzen 7 5700G");	
    	Compra2.setTotal(52276);
     	Compra2.setFecha(java.sql.Date.valueOf("2022-06-07"));
    
    	Compras Compra3 = new Compras("Cooler Disipador",19010,java.sql.Date.valueOf("2022-06-06"));

    	Compras Compra4 = new Compras();
    	Compra4.setDescripcion("Gabinete + Fuente");	
    	Compra4.setTotal(6000);
    	Compra4.setFecha(java.sql.Date.valueOf("2022-06-07"));
    
    	Compras Compra5 = new Compras("Teclado RGB",6500,java.sql.Date.valueOf("2022-06-08"));

    	ArrayList<Compras> CompraCliente = new ArrayList<Compras>();
    	CompraCliente.add(Compra);
    	CompraCliente.add(Compra4);
    	CompraCliente.add(Compra3);
    	
    	ArrayList<Compras> CompraCliente2 = new ArrayList<Compras>();
    	CompraCliente2.add(Compra2);
    	CompraCliente2.add(Compra5);
    	
    	Cliente client = new Cliente();
    	client.setNombre("Agustín");
    	client.setApellido("Andrede");
    	client.setDNI("42980654");
    	client.setMail("Andrede_Agustin@gmail.com");
    	client.setTelefono(1123064598);
    	client.setListaPedidos(CompraCliente);
    	
    	Cliente client2 = new Cliente();
    	client2.setNombre("Marta");
    	client2.setApellido("Konig");
    	client2.setDNI("43900654");
    	client2.setMail("Martha@gmail.com");
    	client2.setTelefono(1156987422);
    	client2.setListaPedidos(CompraCliente2);
//-------------------------------------------------------
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

package Ejercicio3;

import org.hibernate.Session;

import Dao.ConfigHibernate;
import Dao.daoHibernate;

public class MainEjercicio3 {

	public static void main(String[] args) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Gonzalo");
		cliente1.setApellido("Alderete");
		cliente1.setLocalidad("Garin");
		cliente1.setDireccion("calle falsa");
		cliente1.setTelefono(123456);
		
		Pedido pedido1 = new Pedido();
		pedido1.setCliente(cliente1);
		pedido1.setCantidad(10);
		pedido1.setFecha("08/06/2022");
		pedido1.setDetalle("Fragil");
		
		session.save(pedido1);
		//session.getTransaction().commit();
		
		Pedido pedido2 = new Pedido();
		pedido2.setCliente(cliente1);
		pedido2.setCantidad(5);
		pedido2.setFecha("08/06/2022");
		pedido2.setDetalle("Ligero");
		
		session.save(pedido2);
		
		session.getTransaction().commit();
		
		ch.cerrarSession();

		daoHibernate.leerEjercicio3();
	}

}

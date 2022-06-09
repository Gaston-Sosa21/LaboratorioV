package Ejercicio4;

import java.util.HashSet;
import org.hibernate.Session;
import Dao.ConfigHibernate;
import Dao.daoHibernate;

public class MainEjercicio4 {
	
	
	public static void main( String[] args )
    {
	ConfigHibernate ch = new ConfigHibernate();
	Session session= ch.abrirConexion();
	
	session.beginTransaction();
		
	Torneo torneo1 = new Torneo("Torneo el Pecho Frio");
	
	Equipo equipo1 =  new Equipo();
	equipo1.setNombre("Vodka Junior");
	
	Equipo equipo2 =  new Equipo();
	equipo2.setNombre("Aston Birra");
	
	Equipo equipo3 =  new Equipo();
	equipo3.setNombre("Yayo Vallecano");
	
	Equipo equipo4 = new Equipo();
	equipo4.setNombre("Real Furcia");

	
	HashSet<Equipo> listaEquipos = new HashSet<Equipo>();
	
	listaEquipos.add(equipo1);
	listaEquipos.add(equipo2);
	listaEquipos.add(equipo3);
	listaEquipos.add(equipo4);
	
	torneo1.setListaEquipos(listaEquipos);
	
	session.save(torneo1);
	session.getTransaction().commit();
	
	ch.cerrarSession();
	
	daoHibernate.leerEjercicio4();
    }
}

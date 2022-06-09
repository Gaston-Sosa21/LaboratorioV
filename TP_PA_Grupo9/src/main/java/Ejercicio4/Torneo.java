package Ejercicio4;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="torneo")
public class Torneo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idTorneo")
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	
	private String nombre;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="torneos_equipos",
		joinColumns = {@JoinColumn(name="idTorneo")}, 
		inverseJoinColumns = {@JoinColumn(name="idEquipo")})
	private Set<Equipo> listaEquipos = new HashSet<Equipo>();

	public Set<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setListaEquipos(Set<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public Torneo(int id, Set<Equipo> listaEquipos) {
		super();
		this.id = id;
		this.listaEquipos = listaEquipos;
	}
	public Torneo(int id) {
		super();
		this.id = id;
	}

	public Torneo() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Torneo #" + id + ": " + nombre;
	}

	public Torneo(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	
}

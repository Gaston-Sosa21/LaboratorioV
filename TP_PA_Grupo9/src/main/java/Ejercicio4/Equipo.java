package Ejercicio4;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Equipo")
public class Equipo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idEquipo")
	@GeneratedValue(strategy=GenerationType.AUTO)  
	private int id;
	
	private String nombre;
	
	//@ManyToMany(mappedBy = "listaEquipos")
	//private Set<Torneo> torneos;
	
	public Equipo(int id, Set<Torneo> torneos, String nombre) {
		super();
		this.id = id;
		//this.torneos = torneos;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo() {
		super();
	}
	
	@Override
	public String toString() {
		return "#" + id + ": " + nombre;
	}
}

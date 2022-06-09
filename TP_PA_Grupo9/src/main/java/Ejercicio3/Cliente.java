package Ejercicio3;

import java.io.Serializable;
import Ejercicio3.Cliente;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Clientes")
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="IDCliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String nombre;
	private String apellido;
	private String localidad;
	private String direccion;
	private int telefono;
	
	public Cliente() {}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Clientes [Id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", localidad=" + localidad
				+ ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
}

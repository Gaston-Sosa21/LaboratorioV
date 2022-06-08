package Ejercicio1;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Titular")
public class Titular implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTitular;
	private String DNI;
	private String NombreYApellido;
	private String direccion;
	private String telefono;
	
	public Titular() {}
	
	public int getIdTitular() {
		return idTitular;
	}

	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dni) {
		DNI = dni;
	}
	public String getNombreYApellido() {
		return NombreYApellido;
	}
	public void setNombreYApellido(String nombreYApellido) {
		NombreYApellido = nombreYApellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Titular [idTitular=" + idTitular + ", DNI=" + DNI + ", NombreYApellido=" + NombreYApellido
				+ ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	
	
	
}

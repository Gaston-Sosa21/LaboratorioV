package Ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Cliente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCliente;
	private String DNI;
	private String Nombre;
	private String Apellido;
	private String Mail;
	private int Telefono;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="Id_Cliente")
	private List<Compras> ListaPedidos = new ArrayList<Compras>();
	

	public int getIdCliente() {
		return IdCliente;
	}


	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	public String getMail() {
		return Mail;
	}


	public void setMail(String mail) {
		Mail = mail;
	}


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}


	public List<Compras> getListaPedidos() {
		return ListaPedidos;
	}


	public void setListaPedidos(List<Compras> listaPedidos) {
		ListaPedidos = listaPedidos;
	}


	public Cliente(int ClienteID, String dni, String Nombre, String Apellido, int telefono) {
		
		this.IdCliente = ClienteID;
		this.DNI = dni;
		this.Nombre = Nombre;
		this.Apellido = Apellido;
		this.Telefono = telefono;
	}
	public Cliente() {
		
	}
}



















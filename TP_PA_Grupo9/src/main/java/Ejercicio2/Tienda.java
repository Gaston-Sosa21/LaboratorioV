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
public class Tienda implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdTienda;
	private String CUIT;
	private String RAZONSOCIAL;
	private String Mail;
	private int Telefono;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="Id_Tienda")
	private List<Articulos> ListaArticulos = new ArrayList<Articulos>();

	

	public int getIdTienda() {
		return IdTienda;
	}
	public void setIdTienda(int idTienda) {
		IdTienda = idTienda;
	}
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	public String getRAZONSOCIAL() {
		return RAZONSOCIAL;
	}
	public void setRAZONSOCIAL(String rAZONSOCIAL) {
		RAZONSOCIAL = rAZONSOCIAL;
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
	public List<Articulos> getListaArticulos() {
		return ListaArticulos;
	}
	public void setListaArticulos(List<Articulos> listaArticulos) {
		ListaArticulos = listaArticulos;
	}
	public Tienda(int IdTienda, String CUIT, String RAZONSOCIAL, int telefono) {
		
		this.IdTienda = IdTienda;
		this.CUIT = CUIT;
		this.RAZONSOCIAL = RAZONSOCIAL;
		this.Telefono = telefono;
	}
	public Tienda() {
		
	}
}

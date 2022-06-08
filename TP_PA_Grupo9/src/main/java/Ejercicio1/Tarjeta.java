package Ejercicio1;

import java.io.Serializable;
import java.util.Date;
import Ejercicio1.Titular;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tarjeta")
public class Tarjeta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="numeroTarjeta")
	private String numero;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idTitular")
	private Titular titular;
	
	private java.sql.Date fechaVencimiento;
	private String codigoSeguridad;
	
	public Tarjeta () {}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Titular getTitular() {
		return titular;
	}
	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	public java.sql.Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(java.sql.Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}
	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	@Override
	public String toString() {
		return "Tarjeta [numero=" + numero + ", titular=" + titular + ", fechaVencimiento=" + fechaVencimiento
				+ ", codigoSeguridad=" + codigoSeguridad + "]";
	}
	
	
}

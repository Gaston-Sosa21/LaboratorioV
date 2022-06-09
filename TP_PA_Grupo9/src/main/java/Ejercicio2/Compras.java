package Ejercicio2;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name="Compras")
public class Compras implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Compra")
	private int IdCompra;

	private String Descripcion;
	private double Total;
	private Date Fecha;

	public int getIdCompra() {
		return IdCompra;
	}

	public void setIdCompra(int idCompra) {
		IdCompra = idCompra;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public Compras(String descrip, double total, Date fecha) {
		super();
		this.Descripcion = descrip;
		this.Total=total;
		this.Fecha = fecha;
	}
	
	public Compras() {
		
	}
	
	}

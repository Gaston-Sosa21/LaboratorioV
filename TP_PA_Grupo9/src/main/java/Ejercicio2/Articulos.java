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
public class Articulos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_articulo")
	private int IdArticulo;

	private String Descripcion;
	private double Total;
	private Date FechaIngreso;


	public int getIdArticulo() {
		return IdArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		IdArticulo = idArticulo;
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

	public Date getFechaIngreso() {
		return FechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}

	public Articulos(String descrip, double total, Date fecha) {
		super();
		this.Descripcion = descrip;
		this.Total=total;
		this.FechaIngreso = fecha;
	}
	
	public Articulos() {
		
	}
	
}

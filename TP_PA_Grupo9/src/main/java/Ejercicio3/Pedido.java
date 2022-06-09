package Ejercicio3;

import java.io.Serializable;
import Ejercicio3.Pedido;
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
@Table(name="Pedidos")
public class Pedido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDPedido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdPedido;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="IDCliente")
	private Cliente cliente;
	
	private int cantidad;
	private String fecha;
	private String detalle;
	
	public Pedido() {}

	public int getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(int idPedido) {
		IdPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Pedidos [IdPedido=" + IdPedido + ", cliente=" + cliente + ", cantidad=" + cantidad + ", fecha=" + fecha
				+ ", detalle=" + detalle + "]";
	}
	
}

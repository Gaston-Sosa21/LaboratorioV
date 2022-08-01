package biblioteca.entidad;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="Prestamos")
public class Prestamo implements Serializable{
	
			//Implementar serializable
			private static final long serialVersionUID = 1L;
			
			@Id
			@Column(name="id")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
			
			@ManyToOne(cascade = {CascadeType.ALL})
			@JoinColumn(name= "idBiblioteca")
			private Biblioteca biblioteca;
			
			@Column(name ="fecha_prestamo")
			private java.sql.Date  fecha_prestamo;
			
			@Column(name="cantidad_dias")
			private Integer cantidad_dias;
			
			@ManyToOne(cascade = {CascadeType.ALL})
			@JoinColumn(name= "idCliente")
			private Cliente cliente;

			public Prestamo() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Prestamo(int id, Biblioteca biblioteca, Date fecha_prestamo, Integer cantidad_dias,
					Cliente cliente) {
				super();
				this.id = id;
				this.biblioteca = biblioteca;
				this.fecha_prestamo = fecha_prestamo;
				this.cantidad_dias = cantidad_dias;
				this.cliente = cliente;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public Biblioteca getBiblioteca() {
				return biblioteca;
			}

			public void setBiblioteca(Biblioteca biblioteca) {
				this.biblioteca = biblioteca;
			}

			public java.sql.Date getFecha_prestamo() {
				return fecha_prestamo;
			}

			public void setFecha_prestamo(java.sql.Date fecha_prestamo) {
				this.fecha_prestamo = fecha_prestamo;
			}

			public Integer getCantidad_dias() {
				return cantidad_dias;
			}

			public void setCantidad_dias(Integer cantidad_dias) {
				this.cantidad_dias = cantidad_dias;
			}

			public Cliente getCliente() {
				return cliente;
			}

			public void setCliente(Cliente cliente) {
				this.cliente = cliente;
			}

			public static long getSerialversionuid() {
				return serialVersionUID;
			}

			@Override
			public String toString() {
				return "Prestamo [id=" + id + ", biblioteca=" + biblioteca + ", fecha_prestamo=" + fecha_prestamo
						+ ", cantidad_dias=" + cantidad_dias + ", cliente=" + cliente + "]";
			}			
			

}

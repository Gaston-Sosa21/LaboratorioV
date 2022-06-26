package biblioteca.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bibliotecas")
public class Biblioteca implements Serializable{

		//Implementar serializable
		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		
		@Column(name ="fecha_alta")
		private java.sql.Date  fecha_alta;
		
		@Column(name ="estado")
		private int estado;
		
		public Biblioteca(){}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


		public java.sql.Date getFecha_alta() {
			return fecha_alta;
		}

		public void setFecha_alta(java.sql.Date date) {
			this.fecha_alta = date;
		}

		public int isEstado() {
			return estado;
		}

		public void setEstado(int estado) {
			this.estado = estado;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Biblioteca [id=" + id + ", fecha_alta=" + fecha_alta + ", estado=" + estado + "]";
		}
	

}
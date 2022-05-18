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
		
		@OneToMany(cascade = {CascadeType.ALL})
		@JoinColumn(name= "ISBN_Libro")
		private List<Libro> libro = new ArrayList<Libro>();
		
		@Column(name ="fecha_alta")
		private LocalDate  fecha_alta;
		
		@Column(name ="estado")
		private boolean estado;
		
		public Biblioteca(){}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public List<Libro> getLibro() {
			return libro;
		}

		public void setLibro(List<Libro> libro) {
			this.libro = libro;
		}

		public LocalDate getFecha_alta() {
			return fecha_alta;
		}

		public void setFecha_alta(LocalDate fecha_alta) {
			this.fecha_alta = fecha_alta;
		}

		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Biblioteca [id=" + id + ", libro=" + libro + ", fecha_alta=" + fecha_alta + ", estado=" + estado
					+ "]";
		}		

}

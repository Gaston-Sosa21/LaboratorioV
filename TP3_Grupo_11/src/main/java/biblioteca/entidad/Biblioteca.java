package biblioteca.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		
		@Column(name ="libro")
		private String libro;
		
		@Column(name ="fecha_alta")
		private Date  fecha_alta;
		
		@Column(name ="estado")
		private boolean estado;
		
		public Biblioteca(){}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getLibro() {
			return libro;
		}

		public void setLibro(String libro) {
			this.libro = libro;
		}

		public Date getFecha_alta() {
			return fecha_alta;
		}

		public void setFecha_alta(Date fecha_alta) {
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

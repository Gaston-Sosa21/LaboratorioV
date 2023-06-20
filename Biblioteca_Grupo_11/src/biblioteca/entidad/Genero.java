package biblioteca.entidad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Generos")
public class Genero implements Serializable{

		//Implementar serializable
		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name ="descripcion")
		private String descripcion;
		
		public Genero(){}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return "Genero [id=" + id + ", descripcion=" + descripcion + "]";
		}	
		
		public void initGenero() {
			System.out.println("Se inicializa un genero");
		}
		
		public void destroyGenero() {
			System.out.println("Se destruye un genero");
		}
		
}

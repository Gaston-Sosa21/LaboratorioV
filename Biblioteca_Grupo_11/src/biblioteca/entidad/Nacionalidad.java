package biblioteca.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Nacionalidades")
public class Nacionalidad implements Serializable{

		//Implementar serializable
		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name ="descripcion")
		private String descripcion;
		
		public Nacionalidad(){}

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
			return "Nacionalidad [id=" + id + ", descripcion=" + descripcion + "]";
		}
		
		//Desarrollo métodos init y destroy
		public void initNacionalidad() {
			System.out.println("Se inicializa el bean Nacionalidad");
		}
		public void destroyNacionalidad() {
			System.out.println("Se destruye el bean Nacionalidad");
		}
		
}
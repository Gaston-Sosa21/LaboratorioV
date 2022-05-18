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
@Table(name="Libros")
public class Libro implements Serializable{
	
		//Implementar serializable
		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name ="sibn")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String isbn;
		
		@Column(name ="titulo")
		private String titulo;
		
		@Column(name ="fecha_lanzamiento")
		private Date  fecha_lanzamiento;
		
		@Column(name ="idioma")
		private String idioma;
		
		@Column(name ="cantidad_paginas")
		private int cantidad_paginas;
		
		@Column(name ="autor")
		private Autor autor;
		
		@Column(name ="descripcion")
		private String descripcion;
		
		public Libro(){}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public Date getFecha_lanzamiento() {
			return fecha_lanzamiento;
		}

		public void setFecha_lanzamiento(Date fecha_lanzamiento) {
			this.fecha_lanzamiento = fecha_lanzamiento;
		}

		public String getIdioma() {
			return idioma;
		}

		public void setIdioma(String idioma) {
			this.idioma = idioma;
		}

		public int getCantidad_paginas() {
			return cantidad_paginas;
		}

		public void setCantidad_paginas(int cantidad_paginas) {
			this.cantidad_paginas = cantidad_paginas;
		}

		public Autor getAutor() {
			return autor;
		}

		public void setAutor(Autor autor) {
			this.autor = autor;
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
			return "libro [isbn=" + isbn + ", titulo=" + titulo + ", fecha_lanzamiento=" + fecha_lanzamiento
					+ ", idioma=" + idioma + ", cantidad_paginas=" + cantidad_paginas + ", autor=" + autor
					+ ", descripcion=" + descripcion + "]";
		}
		
		
}

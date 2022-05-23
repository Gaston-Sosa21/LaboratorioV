package biblioteca.entidad;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Libros")
public class Libro implements Serializable{
	
		//Implementar serializable
		private static final long serialVersionUID = 1L;
		
		@Id/*
		@Column(name ="ISBN")
		@GeneratedValue(strategy = GenerationType.IDENTITY)*/
		private String ISBN;
		
		@Column(name ="titulo")
		private String titulo;
		
		@Column(name ="fecha_lanzamiento")
		private java.sql.Date  fecha_lanzamiento;
		
		@Column(name ="idioma")
		private String idioma;
		
		@Column(name ="cantidad_paginas")
		private int cantidad_paginas;
		
		@ManyToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name= "idAutor")
		private Autor autor;
		
		@Column(name ="descripcion")
		private String descripcion;
		
		@ManyToMany(cascade = {CascadeType.ALL})
		@JoinTable( name = "Libros_x_Genero", 
					joinColumns = {@JoinColumn (name = "ISBN_Libro")}, 
					inverseJoinColumns= {@JoinColumn (name = "idGenero")})
		private Set<Genero> listaGeneros =  new HashSet<Genero> ();
		
		@OneToMany(cascade = {CascadeType.ALL})
		@JoinColumn(name= "ISBN_Libro", nullable = false)
		
		private List<Biblioteca> biblioteca = new ArrayList<Biblioteca>();
		
		public Libro(){}

		public String getISBN() {
			return ISBN;
		}

		public void setISBN(String isbn) {
			this.ISBN = isbn;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public java.sql.Date getFecha_lanzamiento() {
			return fecha_lanzamiento;
		}

		public void setFecha_lanzamiento(java.sql.Date date) {
			this.fecha_lanzamiento = date;
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
		
		public Set<Genero> getListaGeneros() {
			return listaGeneros;
		}
		public void setListaGeneros(Set<Genero> listaGeneros) {
			this.listaGeneros = listaGeneros;
		}

		public List<Biblioteca> getBiblioteca() {
			return biblioteca;
		}

		public void setBiblioteca(List<Biblioteca> biblioteca) {
			this.biblioteca = biblioteca;
		}

		@Override
		public String toString() {
			return "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", fecha_lanzamiento=" + fecha_lanzamiento
					+ ", idioma=" + idioma + ", cantidad_paginas=" + cantidad_paginas + ", autor=" + autor
					+ ", descripcion=" + descripcion + ", listaGeneros=" + listaGeneros + ", biblioteca=" + biblioteca
					+ "]";
		}

	
		
		
		
}

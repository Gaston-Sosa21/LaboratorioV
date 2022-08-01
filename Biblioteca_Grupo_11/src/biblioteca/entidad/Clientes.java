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
@Table(name="Clientes")
public class Clientes implements Serializable{
	
		//Implementar serializable
		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name="dni")
		private int dni;
		
		@Column(name="nombres")
		private String nombres;
		
		@Column(name="apellidos")
		private String apellidos;
		
		@ManyToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name= "idNacionalidad")
		private Nacionalidad nacionalidad;
		
		@Column(name="email")
		private String email;
		
		@Column(name="direccion")
		private String direccion;
		
		@Column(name="localidad")
		private String localidad;
		
		@Column(name="telefono")
		private String telefono;
		
		@Column(name ="fecha_nacimiento")
		private java.sql.Date fecha_nacimiento;				

		public Clientes() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Clientes(int id, int dni, String nombres, String apellidos, Nacionalidad nacionalidad, String email,
				String direccion, String localidad, String telefono, Date fecha_nacimiento) {
			super();
			this.id = id;
			this.dni = dni;
			this.nombres = nombres;
			this.apellidos = apellidos;
			this.nacionalidad = nacionalidad;
			this.email = email;
			this.direccion = direccion;
			this.localidad = localidad;
			this.telefono = telefono;
			this.fecha_nacimiento = fecha_nacimiento;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getDni() {
			return dni;
		}


		public void setDni(int dni) {
			this.dni = dni;
		}


		public String getNombres() {
			return nombres;
		}


		public void setNombres(String nombres) {
			this.nombres = nombres;
		}


		public String getApellidos() {
			return apellidos;
		}


		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}


		public Nacionalidad getNacionalidad() {
			return nacionalidad;
		}


		public void setNacionalidad(Nacionalidad nacionalidad) {
			this.nacionalidad = nacionalidad;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public String getLocalidad() {
			return localidad;
		}


		public void setLocalidad(String localidad) {
			this.localidad = localidad;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


		public java.util.Date getFecha_nacimiento() {
			return fecha_nacimiento;
		}


		public void setFecha_nacimiento(java.sql.Date fecha) {
			this.fecha_nacimiento = fecha;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		@Override
		public String toString() {
			return "Cliente [id=" + id + ", dni=" + dni + ", nombres=" + nombres + ", apellidos=" + apellidos
					+ ", nacionalidad=" + nacionalidad + ", email=" + email + ", direccion=" + direccion
					+ ", localidad=" + localidad + ", telefono=" + telefono + ", fecha_nacimiento=" + fecha_nacimiento
					+ "]";
		}
}

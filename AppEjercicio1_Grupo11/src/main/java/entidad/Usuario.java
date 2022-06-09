package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user")
	private String usuario;
	
	@Column(name="pass")
	private String contrasenia;
	
	//Constructor vacio
	public Usuario()
	{
		
	}
		
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}
	
	//Metodos init, destroy y constructor
	
	//Se argego este constructor para poder utilizar las dos formas en el bean
		public Usuario(String usuario, String contrasenia) {
			this.usuario = usuario;
			this.contrasenia = contrasenia;
		}
	
	public void initUsuario() {
		System.out.println("Se inicializa un usuario");
	}
	
	public void destroyUsuario() {
		System.out.println("Se destruye un usuario");
	}

}

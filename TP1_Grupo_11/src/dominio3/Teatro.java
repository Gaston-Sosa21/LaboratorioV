package dominio3;

public class Teatro extends Evento{

	private String tipoEntrada;
	private GenerosTeatro genero;
	private String actor1;
	private String actor2;
	private String actor3;
	
	
	public String getTipoEntrada() {
		return tipoEntrada;
	}


	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}


	public GenerosTeatro getGenero() {
		return genero;
	}


	public void setGenero(GenerosTeatro genero) {
		this.genero = genero;
	}


	public String getActor1() {
		return actor1;
	}


	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}


	public String getActor2() {
		return actor2;
	}


	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}


	public String getActor3() {
		return actor3;
	}


	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}

	public Teatro(String tipoEntrada, GenerosTeatro genero, String actor1) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.genero = genero;
		this.actor1 = actor1;
	}
	
	public Teatro(String tipoEntrada, GenerosTeatro genero, String actor1, String actor2) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.genero = genero;
		this.actor1 = actor1;
		this.actor2 = actor2;
	}
		
	public Teatro(String tipoEntrada, GenerosTeatro genero, String actor1, String actor2, String actor3) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.genero = genero;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.actor3 = actor3;
	}


	@Override
	public String toString() {
		return "Teatro [tipoEntrada=" + tipoEntrada + ", genero=" + genero + ", actor1=" + actor1 + ", actor2=" + actor2
				+ ", actor3=" + actor3 + "]";
	}


	@Override
	public float calcularPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

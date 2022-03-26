package dominio2;

public class Genero {
	private String genero;
	
	//constructor
	public Genero(){}
	
	public Genero(String genero)
	{
		this.genero = genero;
	}
	
	//get set
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return genero;
	}
}

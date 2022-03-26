package dominio2;

public class Banda extends Genero{
	private String banda;
	
	//constructor
	public Banda(){}
	
	public Banda(String banda,String genero)
	{
		super(genero);
		this.banda = banda;
	}
	
	//get set
	public String getNombre() {
		return banda;
	}
	public void setNombre(String banda) {
		this.banda = banda;
	}

	@Override
	public String toString() {
		return "Banda [banda=" + banda + ", genero=" + this.getGenero() + "]";
	}

	
}

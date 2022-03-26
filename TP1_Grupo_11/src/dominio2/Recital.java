package dominio2;

public class Recital{
	private Banda bandaPrin;
	private Banda bandaSec1;
	private Banda bandaSec2;
	private String mensaje;
	
	private int cantBandas=0; //Bandas Secundarias
	
	//CONSTRUCTOR
	public Recital()
	{
	}
	public Recital(Banda bandaPrin,int cantBandas)
	{
		switch(bandaPrin.getGenero())
		{
			case"rock":
			case"heavy metal":
			case"reggaetón":
			case"trap":
			case"latinos":
			case"pop":
				this.bandaPrin = bandaPrin;
				break;
			default:
				System.err.println("Genero incorrecto para el recital Banda1");
				break;
		}
		this.cantBandas = cantBandas;
	}
	
	//GET SET
	public Banda getBandaPrin() {
		return bandaPrin;
	}
	
	public void setBandaPrin(Banda bandaPrin) {
		switch(bandaPrin.getGenero())
		{
			case"rock":
			case"heavy metal":
			case"reggaetón":
			case"trap":
			case"latinos":
			case"pop":
				this.bandaPrin = bandaPrin;
				break;
			default:
				System.err.println("Genero incorrecto para el recital Banda1");
				break;
		}
	}
	
	public Banda getBandaSec1() {
		return bandaSec1;
	}
	
	public void setBandaSec1(Banda bandaSec1) {
		switch(bandaSec1.getGenero())
		{
			case"rock":
			case"heavy metal":
			case"reggaetón":
			case"trap":
			case"latinos":
			case"pop":
				this.bandaSec1 = bandaSec1;
				break;
			default:
				System.err.println("Genero incorrecto para el recital BandaSec1");
				break;
		}
	}	
	
	public Banda getBandaSec2() {
		return bandaSec2;
	}
	
	public void setBandaSec2(Banda bandaSec2) {
		switch(bandaSec2.getGenero())
		{
			case"rock":
			case"heavy metal":
			case"reggaetón":
			case"trap":
			case"latinos":
			case"pop":
				this.bandaSec2 = bandaSec2;
				break;
			default:
				System.err.println("Genero incorrecto para el recital BandaSec2");
				break;
		}
	}
	
	public int getCantBandas() {
		return cantBandas;
	}
	
	public void setCantBandas(int cantBandas) {
		this.cantBandas = cantBandas;
	}
	
	//ToString
	@Override
	public String toString() {
		switch(cantBandas)
		{
		case 0:
			mensaje = "Recital [Banda = " + bandaPrin.getNombre() + "]";
			break;
		case 1:
			mensaje = "Recital [Banda = " + bandaPrin.getNombre() 
			+ ", BandaSec1 = " + bandaSec1.getNombre() + "]";
			break;
		case 2:
			mensaje = "Recital [Banda = " + bandaPrin.getNombre() 
			+ ", BandaSec1 = " + bandaSec1.getNombre() 
			+ ", BandaSec2 = " + bandaSec2.getNombre() + "]";
			break;
		}
		return mensaje;
	}
}

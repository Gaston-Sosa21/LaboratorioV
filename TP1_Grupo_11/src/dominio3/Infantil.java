package dominio3;

public class Infantil extends Evento  implements IPrecioEntrada{

	private TiposEntradaInfantil tipoEntrada;
	private Boolean incluyeSouvenir;
	
	
	public Boolean getIncluyeSouvenir() {
		return incluyeSouvenir;
	}
	public void setIncluyeSouvenir(Boolean incluyeSouvenir) {
		this.incluyeSouvenir = incluyeSouvenir;
	}
		
	public Infantil(TiposEntradaInfantil tipoEntrada, Boolean incluyeSouvenir) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.incluyeSouvenir = incluyeSouvenir;
	}
	
	@Override
	public String toString() {
		
		String souvenir, rangoEdad="";
		
		if(incluyeSouvenir) {
			souvenir = "incluye souvenir";
		}
		else {
			souvenir = "no incluye souvenir";
		}
		
		if(tipoEntrada == TiposEntradaInfantil.Menor8) {
			
			rangoEdad = "menores de 8 a�os";
		}
		else if(tipoEntrada == TiposEntradaInfantil.Mayor8) {
			
			rangoEdad = "mayores de 8 a�os";
		}
		
		return " Es para "+ rangoEdad + ", tiene un precio de $" + calcularPrecio() + " y " + souvenir;
	}
	
	@Override
	public float calcularPrecio() {
		
		float precio=0;
		
		if(tipoEntrada == TiposEntradaInfantil.Menor8) {
			precio = 250;
		}
		
		else if(tipoEntrada == TiposEntradaInfantil.Mayor8) {
			
			precio = 500;
			
		}
		
		return precio;
	}
	
}

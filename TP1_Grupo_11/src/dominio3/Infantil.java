package dominio3;

public class Infantil extends Evento  implements IPrecioEntrada{

	private TiposEntradaInfantil tipoEntrada;
	private Boolean incluyeSouvenir;
	
	//Constructores
	
	public Infantil(String nombreShow, TiposEntradaInfantil tipoEntrada, Boolean incluyeSouvenir, int duracionAproximadaMinutos) {
		
		//invocacion al constructor del padre
		super(nombreShow,0,duracionAproximadaMinutos);
		this.tipoEntrada = tipoEntrada;
		this.incluyeSouvenir = incluyeSouvenir;
	}
	
	//gettes y setters
	
	public Boolean getIncluyeSouvenir() {
		return incluyeSouvenir;
	}
	public void setIncluyeSouvenir(Boolean incluyeSouvenir) {
		this.incluyeSouvenir = incluyeSouvenir;
	}	
	
	@Override
	public String toString() {
		
		String souvenir, rangoEdad="";
		
		if(incluyeSouvenir) {
			souvenir = " e incluye souvenir";
		}
		else {
			souvenir = " y no incluye souvenir";
		}
		
		if(tipoEntrada == TiposEntradaInfantil.Menor8) {
			
			rangoEdad = "menores de 8 a�os";
		}
		else if(tipoEntrada == TiposEntradaInfantil.Mayor8) {
			
			rangoEdad = "mayores de 8 a�os";
		}
		
		return getNombreShow() + " el cual dura " + getDuracionAproximadaMinutos() + " minutos. Es para "+ rangoEdad + ", tiene un precio de $" + calcularPrecio() + souvenir;
	}
	
	@Override
	public float calcularPrecio() {
		
		float precio=0;
		
		switch (tipoEntrada) {			
	        case Menor8:     precio = 250;  break;
	        case Mayor8:     precio = 500;  break;  
			default: break;
		}	
		
		return precio;
	}
	
}
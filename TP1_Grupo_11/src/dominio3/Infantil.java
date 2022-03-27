package dominio3;

public class Infantil extends Evento{

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
		return "Infantil [tipoEntrada=" + tipoEntrada + ", incluyeSouvenir=" + incluyeSouvenir + "]";
	}
	@Override
	public float calcularPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

package dominio3;

public class Deporte extends Evento{
	
	private TiposEntradaDeporte tipoEntrada;
	private Boolean esInternacional;
	
	public TiposEntradaDeporte getTipoEntrada() {
		return tipoEntrada;
	}
	public void setTipoEntrada(TiposEntradaDeporte tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}
	public Boolean getEsInternacional() {
		return esInternacional;
	}
	public void setEsInternacional(Boolean esInternacional) {
		this.esInternacional = esInternacional;
	}
	public Deporte(TiposEntradaDeporte tipoEntrada, Boolean esInternacional) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.esInternacional = esInternacional;
	}
	@Override
	public String toString() {
		return "Deporte [tipoEntrada=" + tipoEntrada + ", esInternacional=" + esInternacional + "]";
	}
	
	@Override
	public float calcularPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}

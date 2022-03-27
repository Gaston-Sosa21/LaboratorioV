package dominio3;



public class Recital extends Evento {
	
	private TipoEntradaRecital tipoEntrada;
	private GeneroRecital genero;
	private String bandaPrinc;
	private String bandaSoporte1;
	private String bandaSoporte2;
	
	public TipoEntradaRecital getTipoEntrada() {
		return tipoEntrada;
	}
	public void setTipoEntrada(TipoEntradaRecital tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}
	public GeneroRecital getGenero() {
		return genero;
	}
	public void setGenero(GeneroRecital genero) {
		this.genero = genero;
	}
	public String getBandaPrinc() {
		return bandaPrinc;
	}
	public void setBandaPrinc(String bandaPrinc) {
		this.bandaPrinc = bandaPrinc;
	}
	public String getBandaSoporte1() {
		return bandaSoporte1;
	}
	public void setBandaSoporte1(String bandaSoporte1) {
		this.bandaSoporte1 = bandaSoporte1;
	}
	public String getBandaSoporte2() {
		return bandaSoporte2;
	}
	public void setBandaSoporte2(String bandaSoporte2) {
		this.bandaSoporte2 = bandaSoporte2;
	}
	
	public Recital(TipoEntradaRecital tipoEntrada, GeneroRecital genero, String bandaPrinc, String bandaSoporte1) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.genero = genero;
		this.bandaPrinc = bandaPrinc;
		this.bandaSoporte1 = bandaSoporte1;
	}
	
	public Recital(TipoEntradaRecital tipoEntrada, GeneroRecital genero, String bandaPrinc, String bandaSoporte1,
			String bandaSoporte2) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.genero = genero;
		this.bandaPrinc = bandaPrinc;
		this.bandaSoporte1 = bandaSoporte1;
		this.bandaSoporte2 = bandaSoporte2;
	}


	@Override
	public String toString() {
		return "Recital [tipoEntrada=" + tipoEntrada + ", genero=" + genero + ", bandaPrinc=" + bandaPrinc
				+ ", bandaSoporte1=" + bandaSoporte1 + ", bandaSoporte2=" + bandaSoporte2 + "]";
	}
	
	@Override
	public float calcularPrecio() {
		
		return 1;
	}
	
}

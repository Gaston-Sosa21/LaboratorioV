package dominio3;

public class Deporte extends Evento  implements IPrecioEntrada{
	
	private TiposEntradaDeporte tipoEntrada;
	private Boolean esInternacional;
	public static final float recargoInternacional = (float)1.3;
	
	public Deporte(String nombreShow,TiposEntradaDeporte tipoEntrada, Boolean esInternacional, int duracionAproximadaMinutos) {
		//invocacion al constructor del padre
		super(nombreShow,0,duracionAproximadaMinutos);		
		this.tipoEntrada = tipoEntrada;
		this.esInternacional = esInternacional;
	}
	
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
	
	@Override
	public String toString() {
		
		String tipoEvento;
		if(esInternacional) {
			tipoEvento = "internacional";
		}
		else {
			tipoEvento = "nacional";
		}
		
		return getNombreShow() + " el cual dura " + getDuracionAproximadaMinutos() + " minutos. Es un evento " + tipoEvento + " de "+ tipoEntrada + " y su precio es de"
				+ " $" + calcularPrecio();
	}
	
	@Override
	public float calcularPrecio() {	

		float precio = 0;
		
		switch (tipoEntrada) {			
	        case Futbol: precio = 300;  break;
	        case Hockey: precio = 380;  break;        
	        case Rugby:  precio = 450;  break;            
			default:
				break;
		}
		
		if(esInternacional) {			
			precio = precio * recargoInternacional;			
		}
		
		return precio;	
	}	
}

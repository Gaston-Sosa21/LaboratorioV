package dominio3;


public abstract class Evento{

	private String NombreShow ;
	private float Precio; 
	private int DuracionAproximadaMinutos;
	
	public String getNombreShow() {
		return NombreShow;
	}
	public void setNombreShow(String nombreShow) {
		NombreShow = nombreShow;
	}
	public float getPrecio() {
		return Precio;
	}
	
	public void setPrecio(float precio) {
		Precio = precio;
	}
	public int getDuracionAproximadaMinutos() {
		return DuracionAproximadaMinutos;
	}
	public void setDuracionAproximadaMinutos(int duracionAproximadaMinutos) {
		DuracionAproximadaMinutos = duracionAproximadaMinutos;
	}
	
	@Override
	public abstract String toString();
	public abstract float calcularPrecio();
	
	
	
}

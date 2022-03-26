package dominio2;

public class Entrada{
	private static int numEntrada=0;
	private String nombreShow;
	private String tipoEvento; // recital, etc. 
	private String fecha;
	private String horaInicio;
	private int durAproxHora;
	private int cantEntradas;
	private float precio;
	
	public Entrada() {}
	
	public Entrada(String nombre,String tipo,
			String fecha, String horaInicio,
			int durAproxHora,float precio)
	{
		numEntrada++;
		this.nombreShow = nombre;
		this.tipoEvento = tipo;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.durAproxHora = durAproxHora;
		this.precio = precio;
	}
	
	//get set
	public static int getNumEntrada() {
		return numEntrada;
	}

	public static void setNumEntrada(int numEntrada) {
		Entrada.numEntrada = numEntrada;
	}

	public String getNombreShow() {
		return nombreShow;
	}

	public void setNombreShow(String nombreShow) {
		this.nombreShow = nombreShow;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getDurAproxHora() {
		return durAproxHora;
	}

	public void setDurAproxHora(int durAproxHora) {
		this.durAproxHora = durAproxHora;
	}

	public int getCantEntradas() {
		return cantEntradas;
	}

	public void setCantEntradas(int cantEntradas) {
		this.cantEntradas = cantEntradas;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}

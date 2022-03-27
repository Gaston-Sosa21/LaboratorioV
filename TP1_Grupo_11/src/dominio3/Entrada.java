package dominio3;

public class Entrada{
	

	private static int numEntrada=0;
	private String nombreShow;
	private Evento evento;
	

	public Entrada(String nombreShow, Evento evento) {
		super();
		numEntrada++;
		this.nombreShow = nombreShow;
		this.evento = evento;
	}
	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public static int getNumEntrada() {
		return numEntrada;
	}

	public String getNombreShow() {
		return nombreShow;
	}
	public void setNombreShow(String nombreShow) {
		this.nombreShow = nombreShow;
	}

	@Override
	public String toString() {
		return "Entrada [nombreShow=" + nombreShow + ", evento=" + evento.toString() + "]";
	}
	
	

}

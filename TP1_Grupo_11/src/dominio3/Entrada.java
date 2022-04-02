package dominio3;



public class Entrada{
	

	private static int numEntrada=0;
	private String fechaHoraShow;
	private Evento evento;


	public Entrada(String fechaHoraShow, Evento evento) {
		super();
		numEntrada++;
		this.fechaHoraShow = fechaHoraShow;
		this.evento = evento;
	}
	
	public String getFechaHoraShow() {
		return fechaHoraShow;
	}

	public void setFechaHoraShow(String fechaHoraShow) {
		this.fechaHoraShow = fechaHoraShow;
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


	@Override
	public String toString() {
		return "Esta es la entrada N°" + getNumEntrada() +", es válida para ingresar el dia " + getFechaHoraShow() +" y corresponde al show " +evento.toString();
	}
	
	

}

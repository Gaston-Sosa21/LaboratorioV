package dominio;

import java.time.LocalDate;

public class Evento extends TipoEvento {

	private int IdEvento;
	private String DescripcionEvento;
	private LocalDate Fecha; 
	private String HoraInicio; 
	private String HoraFin; 
	
	/*Puse los horarios como String porque me pareció más facíl  
	en caso de querer mostrarlo en pantalla*/
	
	//Constructor
	private static int cont=0;
	
	public Evento() {
		super();
		cont++;
		this.IdEvento = cont;
		this.DescripcionEvento="Desconocido";
		this.Fecha= LocalDate.now();
		this.HoraInicio="";
		this.HoraFin="";
	}
	
	public Evento(String Tipo,String Descripcion,String dia,String HInicio,String HFin) {
		super(Tipo);
		cont++;
		this.IdEvento = cont;
		this.DescripcionEvento=Descripcion;
		this.Fecha= LocalDate.parse(dia);
		this.HoraInicio=HInicio;
		this.HoraFin=HFin;
	}

	//Getters and Setters
	public int getIdEvento() {
		return IdEvento;
	}

	public void setIdEvento(int idEvento) {
		IdEvento = idEvento;
	}

	public String getDescripcionEvento() {
		return DescripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		DescripcionEvento = descripcionEvento;
	}

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}

	public String getHoraInicio() {
		return HoraInicio;
	}

	public void setHoraInicio(String horaInicio) {
		HoraInicio = horaInicio;
	}

	public String getHoraFin() {
		return HoraFin;
	}

	public void setHoraFin(String horaFin) {
		HoraFin = horaFin;
	}

	//ToString
	@Override
	public String toString() {
		return "El evento " + DescripcionEvento + " ("+ super.toString() +") se realizara el día " + Fecha
				+ ", de " + HoraInicio + "hs a " + HoraFin + "hs.";
	}
	
}

package dominio;

public class TipoEvento {

	private int IdTipoEvento;
	private String Descripcion;
	
	
	//Constructores
    private static int contador = 0;

	public TipoEvento() {
		contador++;
		this.IdTipoEvento=contador;
		this.Descripcion="Desconocido";
	}
	
	public TipoEvento(String Tipo) {
		contador++;
		this.IdTipoEvento=contador;
		this.Descripcion=Tipo;
	}
	

	
	//Getters y setters
	public int getIdTipoEvento() {
		return IdTipoEvento;
	}
	public void setIdTipoEvento(int idTipoEvento) {
		IdTipoEvento = idTipoEvento;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	//To String
	@Override
	public String toString() {
		return "Evento: "+ Descripcion + " ";
	}
	
	
}

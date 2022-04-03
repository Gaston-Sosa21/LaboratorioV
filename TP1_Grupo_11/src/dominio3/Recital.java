package dominio3;



public class Recital extends Evento implements IPrecioEntrada {
	
	private TipoEntradaRecital tipoEntrada;
	private GeneroRecital genero;
	private String bandaPrinc;
	private String bandaSoporte1="";
	private String bandaSoporte2="";
	
	private static final float precioVip = 1500;
	private static final float precioGeneral = 800;
	
	//constructores
	
	public Recital(String nombreShow,TipoEntradaRecital tipoEntrada, GeneroRecital genero, String bandaPrinc, int duracionAproximadaMinutos) {
		
		//invocacion al constructor del padre
		super(nombreShow,0,duracionAproximadaMinutos);		
		ConstructorBase(tipoEntrada,genero,bandaPrinc);
	}	
	
	public Recital(String nombreShow,TipoEntradaRecital tipoEntrada, GeneroRecital genero, String bandaPrinc, String bandaSoporte1, int duracionAproximadaMinutos) {
		
		//invocacion al constructor del padre
		super(nombreShow,0,duracionAproximadaMinutos);		
		ConstructorBase(tipoEntrada,genero,bandaPrinc);
		this.bandaSoporte1 = bandaSoporte1;
	}
	
	public Recital(String nombreShow,TipoEntradaRecital tipoEntrada, GeneroRecital genero, String bandaPrinc, String bandaSoporte1, String bandaSoporte2, int duracionAproximadaMinutos) {
		
		//invocacion al constructor del padre
		super(nombreShow,0,duracionAproximadaMinutos);		
		ConstructorBase(tipoEntrada,genero,bandaPrinc);
		this.bandaSoporte1 = bandaSoporte1;
		this.bandaSoporte2 = bandaSoporte2;
	}

	private void ConstructorBase(TipoEntradaRecital tipoEntrada, GeneroRecital genero, String bandaPrinc) 
	{
		this.tipoEntrada = tipoEntrada;
		this.genero = genero;
		this.bandaPrinc = bandaPrinc;
	}
	
	//gettes y setters
	
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

	@Override
	public String toString() {
		
		String mensaje = getNombreShow() + " el cual dura " + getDuracionAproximadaMinutos() + " minutos." ;
		
		if(bandaSoporte2.isEmpty())
		{
			if(bandaSoporte1.isEmpty())
			{
				mensaje += " Es de tipo " + tipoEntrada + " y su precio es de $" + calcularPrecio() 
				+", el concierto es del género " + genero + " y las bandas que tocarán son: " + bandaPrinc;
			}
			else
			{
				mensaje += " Es de tipo " + tipoEntrada + " y su precio es de $" + calcularPrecio() 
				+", el concierto es del género " + genero + " y las bandas que tocarán son: " + bandaPrinc + ", " + bandaSoporte1;
			}
		}
		else
		{
			if(bandaSoporte1.isEmpty())
			{
				mensaje += " Es de tipo " + tipoEntrada + " y su precio es de $" + calcularPrecio() 
				+", el concierto es del género " + genero + " y las bandas que tocarán son: " + bandaPrinc + ", " + bandaSoporte2;
			}
			else
			{
				mensaje += " Es de tipo " + tipoEntrada + " y su precio es de $" + calcularPrecio() 
				+", el concierto es del género " + genero + " y las bandas que tocarán son: " + bandaPrinc + ", " + bandaSoporte1 + ", "+ bandaSoporte2;
			}
		}
		return mensaje;
	}

	@Override
	public float calcularPrecio() {
		
		float precio = 0;
		
		if(tipoEntrada == TipoEntradaRecital.VIP) {			
			precio = precioVip;			
		}
		else if (tipoEntrada == TipoEntradaRecital.General) {			
			precio=precioGeneral;
		}		
		return precio;
		
	}
	
}

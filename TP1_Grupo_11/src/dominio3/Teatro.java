package dominio3;

public class Teatro extends Evento  implements IPrecioEntrada{

	private String tipoEntrada;
	private GenerosTeatro genero;
	private String actor1="";
	private String actor2="";
	private String actor3="";
	private String mensaje="";
	
	public String getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public GenerosTeatro getGenero() {
		return genero;
	}

	public void setGenero(GenerosTeatro genero) {
		this.genero = genero;
	}

	public String getActor1() {
		return actor1;
	}

	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}

	public String getActor2() {
		return actor2;
	}

	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}

	public String getActor3() {
		return actor3;
	}

	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}

	public Teatro(String tipoEntrada, GenerosTeatro genero, String actor1) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.genero = genero;
		this.actor1 = actor1;
	}
	
	public Teatro(String tipoEntrada, GenerosTeatro genero, String actor1, String actor2) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.genero = genero;
		this.actor1 = actor1;
		this.actor2 = actor2;
	}
		
	public Teatro(String tipoEntrada, GenerosTeatro genero, String actor1, String actor2, String actor3) {
		super();
		this.tipoEntrada = tipoEntrada;
		this.genero = genero;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.actor3 = actor3;
	}

	@Override
	public String toString() 
	{
		if(actor1 != "")
		{
			if(actor2 != "")
			{
				if(actor3 != "")
				{
					mensaje = " Tiene un precio de $"+ calcularPrecio() + ", la obra es del género "+ genero +
					" y los actores principales son: " + actor1 + ", " + actor2 + ", " + actor3;
				}
				else
				{
					mensaje = " Tiene un precio de $"+ calcularPrecio() + ", la obra es del género "+ genero +
					" y los actores principales son: " + actor1 + ", " + actor2;
				}
			}
			else
			{
				if(actor3 != "")
				{
					mensaje = " Tiene un precio de $"+ calcularPrecio() + ", la obra es del género "+ genero +
					" y los actores principales son: " + actor1 + ", " + actor3;
				}
				else
				{
					mensaje = " Tiene un precio de $"+ calcularPrecio() + ", la obra es del género "+ genero +
					" y los actores principales son: " + actor1;
				}
			}
		}
		else
		{
			if(actor2 != "")
			{
				if(actor3 != "")
				{
					mensaje = " Tiene un precio de $"+ calcularPrecio() + ", la obra es del género "+ genero +
					" y los actores principales son: " + actor2 + ", " + actor3;
				}
				else
				{
					mensaje = " Tiene un precio de $"+ calcularPrecio() + ", la obra es del género "+ genero +
					" y los actores principales son: " + actor2;
				}
			}
			else
			{
				if(actor3 != "")
				{
					mensaje = " Tiene un precio de $"+ calcularPrecio() + ", la obra es del género "+ genero +
					" y los actores principales son: " + actor3;
				}
				else
				{	
					mensaje = " Tiene un precio de $"+ calcularPrecio() + ", la obra es del género "+ genero +
					" y los actores principales son: ";
				}
			}
		}
		return mensaje;
	}

	@Override
	public float calcularPrecio() 
	{
		return (float)1350.50;
	}
}

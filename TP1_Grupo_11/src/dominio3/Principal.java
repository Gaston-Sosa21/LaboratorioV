package dominio3;

public class Principal {

	public static void main(String[] args) {
		
		Evento recital1 =  new Recital(TipoEntradaRecital.General, GeneroRecital.Heavy_metal,"Metallica","Pantera");
		
		Evento recital2 =  new Recital(TipoEntradaRecital.VIP, GeneroRecital.Reggaeton,"Lgante","Cazzu");
		
		Evento infantil =  new Infantil(TiposEntradaInfantil.Mayor8 , true);
		
		Evento deporte =  new Deporte(TiposEntradaDeporte.Futbol, true);
		
		Evento teatro =  new Teatro("General",GenerosTeatro.Comedia, "Di Caprio");
		
		Entrada entrada1 = new Entrada("Recital1", recital1);
		Entrada entrada2 = new Entrada("Recital2", recital2);
		Entrada entrada3 = new Entrada("Infantil", infantil);
		Entrada entrada4 = new Entrada("Deporte", deporte);
		Entrada entrada5 = new Entrada("Teatro", teatro);
		
		System.out.println(entrada1.toString());
		System.out.println(entrada2.toString());
		System.out.println(entrada3.toString());
		System.out.println(entrada4.toString());
		System.out.println(entrada5.toString());
	}
}
